package com.example.calculadora.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {



    @FXML
    private Button BotonCos;

    @FXML
    private Button BotonEntre;

    @FXML
    private Button BotonIgual;

    @FXML
    private Button BotonMas;

    @FXML
    private Button BotonMenos;

    @FXML
    private Button BotonNum0;

    @FXML
    private Button BotonNum1;

    @FXML
    private Button BotonNum2;

    @FXML
    private Button BotonNum3;

    @FXML
    private Button BotonNum4;

    @FXML
    private Button BotonNum5;

    @FXML
    private Button BotonNum6;

    @FXML
    private Button BotonNum7;

    @FXML
    private Button BotonNum8;

    @FXML
    private Button BotonNum9;

    @FXML
    private Button BotonPor;

    @FXML
    private Button BotonRaiz;

    @FXML
    private Button BotonRecet;

    @FXML
    private Button BotonSin;

    @FXML
    private Button BotonTan;

    @FXML
    private Label LabelProceso;

    @FXML
    private Label LabelSuma;

    @FXML
    private GridPane parteC;

    @FXML
    private BorderPane panelGeneral;

    @FXML
    private RadioButton RadioB;

    @FXML
    private RadioButton RadioC;

    private ToggleGroup opcinCalculadora;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        initGUI();
        acciones();

    }


    private void instancias() {
        opcinCalculadora = new ToggleGroup();
        opcinCalculadora.getToggles().addAll(RadioC,RadioB);

    }


    private void initGUI() {
        LabelProceso.setText(null);
        LabelSuma.setText(null);
        if (RadioC.isSelected()) {
            panelGeneral.setRight(parteC);
        } else {
            panelGeneral.setRight(null);
        }
    }



    private void acciones() {
        BotonNum1.setOnAction(new ManejoAcciones());
        BotonNum2.setOnAction(new ManejoAcciones());
        BotonNum3.setOnAction(new ManejoAcciones());
        BotonNum4.setOnAction(new ManejoAcciones());
        BotonNum5.setOnAction(new ManejoAcciones());
        BotonNum6.setOnAction(new ManejoAcciones());
        BotonNum7.setOnAction(new ManejoAcciones());
        BotonNum8.setOnAction(new ManejoAcciones());
        BotonNum9.setOnAction(new ManejoAcciones());
        BotonNum0.setOnAction(new ManejoAcciones());
        BotonMas.setOnAction(new ManejoAcciones());
        BotonMenos.setOnAction(new ManejoAcciones());
        BotonPor.setOnAction(new ManejoAcciones());
        BotonEntre.setOnAction(new ManejoAcciones());
        BotonIgual.setOnAction(new ManejoAcciones());
        BotonRaiz.setOnAction(new ManejoAcciones());
        BotonSin.setOnAction(new ManejoAcciones());
        BotonCos.setOnAction(new ManejoAcciones());
        BotonTan.setOnAction(new ManejoAcciones());
        BotonRecet.setOnAction(new ManejoAcciones());
        RadioC.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (RadioC.isSelected()) {
                    panelGeneral.setRight(parteC);
                } else {
                    panelGeneral.setRight(null);
                }
            }
        });

    }


    class ManejoAcciones implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent actionEvent) {
            Object ae = actionEvent.getSource();
            String actual = LabelSuma.getText();
            if (actual == null) actual = "";



            if (ae == BotonNum0) {
                LabelSuma.setText(actual + "0");
            } else if (ae == BotonNum1) {
                LabelSuma.setText(actual + "1");
            } else if (ae == BotonNum2) {
                LabelSuma.setText(actual + "2");
            } else if (ae == BotonNum3) {
                LabelSuma.setText(actual + "3");
            } else if (ae == BotonNum4) {
                LabelSuma.setText(actual + "4");
            } else if (ae == BotonNum5) {
                LabelSuma.setText(actual + "5");
            } else if (ae == BotonNum6) {
                LabelSuma.setText(actual + "6");
            } else if (ae == BotonNum7) {
                LabelSuma.setText(actual + "7");
            } else if (ae == BotonNum8) {
                LabelSuma.setText(actual + "8");
            } else if (ae == BotonNum9) {
                LabelSuma.setText(actual + "9");
            }



            else if (ae == BotonMas) {
                LabelSuma.setText("+");
            } else if (ae == BotonMenos) {
                LabelSuma.setText("-");
            } else if (ae == BotonPor) {
                LabelSuma.setText("*");
            } else if (ae == BotonEntre) {
                LabelSuma.setText("/");
            } else if (ae == BotonRaiz) {
                LabelSuma.setText("√");
            } else if (ae == BotonSin) {
                LabelSuma.setText("sin");
            } else if (ae == BotonCos) {
                LabelSuma.setText("cos");
            } else if (ae == BotonTan) {
                LabelSuma.setText("tan");
            }



            else if (ae == BotonIgual) {
                LabelSuma.setText("=");
            }




            else if (ae == BotonRecet) {
                LabelSuma.setText("");
                LabelProceso.setText("");
            }



        }


    }


}
