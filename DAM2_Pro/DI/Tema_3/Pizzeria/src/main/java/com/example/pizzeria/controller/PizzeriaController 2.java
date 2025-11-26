package com.example.pizzeria.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.pizzeria.dao.PedidoDAOImp;
import com.example.pizzeria.model.Pedido;
import com.example.pizzeria.model.Pizza;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PizzeriaController implements Initializable {

    @FXML
    private Button buttonRealizarPedido;
    @FXML
    private Button botonMostrarDetalle;
    @FXML
    private Button botonPendientes;
    @FXML
    private Button botonServir;

    @FXML
    private ComboBox<String> comboBoxPizzas;

    @FXML
    private ListView<Pedido> listViewPedidos;

    @FXML
    private RadioButton radioButtonFam;
    @FXML
    private RadioButton radioButtonMed;
    @FXML
    private RadioButton radioButtonPeq;

    @FXML
    private TextField textFieldNombre;
    @FXML
    private TextField textFieldTel;

    private ToggleGroup grupoPizza;
    private ObservableList<Pedido> listaPedidos;
    private ObservableList<String> listaPizzas;

    private PedidoDAOImp pedidoDAOImp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
        agregarListenerSeleccion();
    }

    private void instancias() {
        pedidoDAOImp = new PedidoDAOImp();
        listaPedidos = FXCollections.observableArrayList(pedidoDAOImp.obtenerPedidos());
        listaPizzas = FXCollections.observableArrayList("Barbacoa", "Hawaiana", "Jamón y queso", "Cuatro quesos");

        grupoPizza = new ToggleGroup();
        grupoPizza.getToggles().addAll(radioButtonPeq, radioButtonMed, radioButtonFam);


    }

    private void initGUI() {
        listViewPedidos.setItems(listaPedidos);
        comboBoxPizzas.setItems(listaPizzas);
    }

    private void acciones() {
        ManejoActions handler = new ManejoActions();
        buttonRealizarPedido.setOnAction(handler);
        botonServir.setOnAction(handler);
        botonPendientes.setOnAction(handler);
        botonMostrarDetalle.setOnAction(handler);
    }

    private void agregarListenerSeleccion() {
        listViewPedidos.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        mostrarAlerta(Alert.AlertType.INFORMATION,
                                "Datos del pedido",
                                "Nombre: " + newVal.getNombre() + "\n" +
                                        "Teléfono: " + newVal.getTelefono() + "\n" +
                                        "Pizza: " + newVal.getPizza().getNombre() + "\n" +
                                        "Tamaño: " + newVal.getPizza().getTamanio() + "\n" +
                                        "Precio: " + newVal.getPizza().getPrecio() + "\n" +
                                        "Servido: " + (newVal.isServido() ? "Sí" : "No"));
                    }
                }
        );
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    class ManejoActions implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();

            // Realizar pedido
            if (source == buttonRealizarPedido) {
                if (!textFieldNombre.getText().isEmpty() && !textFieldTel.getText().isEmpty()
                        && grupoPizza.getSelectedToggle() != null
                        && comboBoxPizzas.getSelectionModel().getSelectedItem() != null) {

                    String nombre = textFieldNombre.getText();
                    String telefono = textFieldTel.getText();
                    String tamanio = ((RadioButton) grupoPizza.getSelectedToggle()).getText();
                    String pizzaTipo = comboBoxPizzas.getSelectionModel().getSelectedItem();
                    double precio = calcularPrecio(pizzaTipo, tamanio);

                    Pizza pizza = new Pizza(pizzaTipo, tamanio, precio);
                    Pedido pedido = new Pedido(nombre, telefono, pizza);

                    try {
                        pedidoDAOImp.insertarPedido(pedido);
                        listaPedidos.add(pedido);
                        textFieldNombre.clear();
                        textFieldTel.clear();
                        grupoPizza.selectToggle(null);
                        comboBoxPizzas.getSelectionModel().clearSelection();
                        mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Pedido realizado correctamente.");
                    } catch (SQLException e) {
                        mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo insertar el pedido: " + e.getMessage());
                    }
                } else {
                    mostrarAlerta(Alert.AlertType.WARNING, "Campos incompletos", "Completa todos los campos.");
                }
            }

            // Servir pedido
            if (source == botonServir) {
                Pedido seleccionado = listViewPedidos.getSelectionModel().getSelectedItem();
                if (seleccionado == null) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "Selecciona un pedido para servir.");
                    return;
                }
                seleccionado.setServido(true);
                try {
                    pedidoDAOImp.marcarServido(seleccionado.getId());
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                listViewPedidos.refresh();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Pedido marcado como servido.");
            }

            // Mostrar pendientes
            if (source == botonPendientes) {
                listaPedidos.setAll(
                        pedidoDAOImp.obtenerPedidos().stream().filter(p -> !p.isServido()).toList()
                );
            }

            // Mostrar detalle en ventana
            if (source == botonMostrarDetalle) {
                Pedido seleccionado = listViewPedidos.getSelectionModel().getSelectedItem();
                if (seleccionado == null) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "Selecciona un pedido para ver detalle.");
                    return;
                }
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pizzeria/detalle-view.fxml"));
                    Parent root = loader.load();
                    DetalleController controller = loader.getController();
                    controller.setPedido(seleccionado);

                    Stage stage = new Stage();
                    stage.setTitle("Detalle del pedido");
                    stage.setScene(new Scene(root));
                    stage.show();

                } catch (Exception e) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir la ventana de detalle: " + e.getMessage());
                }
            }
        }

        private double calcularPrecio(String pizzaTipo, String tamanio) {
            return switch (pizzaTipo) {
                case "Barbacoa" -> switch (tamanio) {
                    case "Pequeña" -> 7;
                    case "Mediana" -> 12;
                    case "Familiar" -> 15;
                    default -> 0;
                };
                case "Hawaiana" -> switch (tamanio) {
                    case "Pequeña" -> 5;
                    case "Mediana" -> 10;
                    case "Familiar" -> 13;
                    default -> 0;
                };
                case "Jamón y queso" -> switch (tamanio) {
                    case "Pequeña" -> 4;
                    case "Mediana" -> 8;
                    case "Familiar" -> 10;
                    default -> 0;
                };
                case "Cuatro quesos" -> switch (tamanio) {
                    case "Pequeña" -> 8;
                    case "Mediana" -> 13;
                    case "Familiar" -> 17;
                    default -> 0;
                };
                default -> 0;
            };
        }
    }
}
