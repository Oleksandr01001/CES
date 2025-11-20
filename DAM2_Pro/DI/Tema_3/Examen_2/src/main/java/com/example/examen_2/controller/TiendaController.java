package com.example.examen_2.controller;

import com.example.examen_2.dao.UsuarioDAOImp;
import com.example.examen_2.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TiendaController implements Initializable {

    @FXML
    private Button botonLogin;

    @FXML
    private TextField textfieldCoreo;

    @FXML
    private TextField textfieldPass;

    @FXML
    private Button botonDetalle;

    @FXML
    private Button botonFiltrar;

    @FXML
    private ComboBox<?> comboBox;

    private ObservableList<Usuario> listaUsuarios;

    private UsuarioDAOImp usuarioDAOImp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void acciones() {
        botonLogin.setOnAction(new ManejoAcciones());
    }

    private void instancias() {
        usuarioDAOImp = new UsuarioDAOImp();
        listaUsuarios =
                FXCollections.observableArrayList(usuarioDAOImp.obtenerUsuarios());
    }


    private Usuario estaUsuario(String correo) {
        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equalsIgnoreCase(correo)) {
                return item;
            }
        }
        return null;
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonLogin) {

                String correo = textfieldCoreo.getText().trim();
                String pass = textfieldPass.getText().trim();

                if (correo.isEmpty() || pass.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Intoduce datos");
                    alert.setHeaderText("Faltan datos");
                    alert.setContentText("Introduce correo y contraseña");
                    alert.showAndWait();
                    return;
                }

                Usuario usuario = estaUsuario(correo);

                if (usuario == null || !usuario.getPass().equals(pass)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Login incorrecto");
                    alert.setHeaderText("Usuario no encontrado");
                    alert.setContentText("Correo o contraseña incorrectos.");
                    alert.showAndWait();
                } else {
                    System.out.println("Login correcto: " + usuario.getNombre());


                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("segunda-view.fxml"));
                        Parent root = loader.load();

                        Stage stageActual = (Stage) botonLogin.getScene().getWindow();
                        stageActual.close();

                        Stage nuevoStage = new Stage();
                        nuevoStage.setScene(new Scene(root));
                        nuevoStage.setTitle("Tienda");
                        nuevoStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
