package org.example.appinicial;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public Label labelSaludo;
    @FXML
    public TextField textfieldNombre;
    @FXML
    public Button bottonPulsar, bottonVaciar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Ejecucuion de la parte logica comenzada");
        acciones();

    }

    private void acciones() {
        /*
        bottonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // el metodo e ejecutar cuandobotton sea pulsado
                // System.out.println("Buttom pulsado correctamente");
                String nombre = textfieldNombre.getText();
                if (nombre.isEmpty()) {
                    System.out.println("Por favor rellena el nombre");
                } else {
                    labelSaludo.setText(String.format("Enorabuena %s has completado tu primer ejercicio", nombre));
                }
            }
        });

        bottonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText("");
                textfieldNombre.clear();
            }
        });
        */

    }


    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");
            if (actionEvent.getSource()==bottonPulsar){
                
            } else if (actionEvent.getSource()==bottonVaciar) {
                
            }
        }
    }
}