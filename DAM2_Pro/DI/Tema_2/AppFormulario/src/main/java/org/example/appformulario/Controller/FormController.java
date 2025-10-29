package org.example.appformulario.Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import org.example.appformulario.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {



    @FXML
    private Button buttonAgregar;

    @FXML
    private Button buttonEliminar;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<Integer> comboEdad;

    @FXML
    private BorderPane panelGeneral;

    @FXML
    private FlowPane parteDerech;

    @FXML
    private RadioButton radioFemenino;

    @FXML
    private RadioButton radioMasculino;

    @FXML
    private TextField textfieldCorreo;

    @FXML
    private TextField textfieldLocalizacion;

    @FXML
    private TextField textfieldNombre;

    @FXML
    private ToggleButton toggleLista;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;

    private ObservableList<Usuario> listaUsuarios;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        buttonAgregar.setOnAction(new ManejoActions());
        buttonEliminar.setOnAction(new ManejoActions());
        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                System.out.println("Venimos de "+oldValue);
                System.out.println("Estamos en "+newValue);
                buttonAgregar.setDisable(!newValue);
            }
        });
        toggleLista.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    panelGeneral.setRight(parteDerech);
                } else {
                    panelGeneral.setRight(null);
                }
            }
        });
    }

    private void instancias() {
        grupoGenero = new ToggleGroup();
        grupoGenero.getToggles().addAll(radioMasculino,radioFemenino);
        listaEdades = FXCollections.observableArrayList();
        for (int i = 18; i < 91; i++) {
            listaEdades.add(i);
        }
    }


    private void initGUI() {
        comboEdad.setItems(listaEdades);
        buttonAgregar.setDisable(!checkDisponibilidad.isSelected());
        if (toggleLista.isSelected()){
            panelGeneral.setRight(parteDerech);
        } else {
            panelGeneral.setRight(null);
        }
    }




class ManejoActions implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == buttonAgregar) {

            if (textfieldNombre.getText().length() > 0
            && textfieldCorreo.getText().length() > 0
            && grupoGenero.getSelectedToggle() != null
            && comboEdad.getSelectionModel().getSelectedItem() >= 0)
            {
                String nombre = textfieldNombre.getText();
                String correo = textfieldCorreo.getText();
                String localizacion = textfieldLocalizacion.getText();
                String genero = ((RadioButton)grupoGenero.getSelectedToggle()).getText();
                boolean disponibilidad = checkDisponibilidad.isSelected();
                int edad = comboEdad.getSelectionModel().getSelectedItem();

                Usuario usuario = new Usuario(nombre,correo,localizacion,genero,edad,disponibilidad);
                listaUsuarios.add(usuario);
            } else {
                System.out.println("Error faltan datos");
            }


        } else if (actionEvent.getSource() == buttonEliminar) {

        }
    }
}

}
