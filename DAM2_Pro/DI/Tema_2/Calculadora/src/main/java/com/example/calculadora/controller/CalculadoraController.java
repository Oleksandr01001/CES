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
            if (actionEvent.getSource() == BotonNum1) {
                LabelSuma.setText("1");
            } else if (actionEvent.getSource() == BotonNum2) {
                LabelSuma.setText("2");
            } else if (actionEvent.getSource() == BotonNum3) {
                LabelSuma.setText("3");
            } else if (actionEvent.getSource() == BotonNum4) {
                LabelSuma.setText("4");
            } else if (actionEvent.getSource() == BotonNum5) {
                LabelSuma.setText("5");
            } else if (actionEvent.getSource() == BotonNum6) {
                LabelSuma.setText("6");
            } else if (actionEvent.getSource() == BotonNum7) {
                LabelSuma.setText("7");
            } else if (actionEvent.getSource() == BotonNum8) {
                LabelSuma.setText("8");
            } else if (actionEvent.getSource() == BotonNum9) {
                LabelSuma.setText("9");
            } else if (actionEvent.getSource() == BotonNum0) {
                LabelSuma.setText("0");
            } else if (actionEvent.getSource() == BotonMas) {
                LabelSuma.setText("+");
            } else if (actionEvent.getSource() == BotonMenos) {
                LabelSuma.setText("-");
            } else if (actionEvent.getSource() == BotonPor) {
                LabelSuma.setText("*");
            } else if (actionEvent.getSource() == BotonIgual) {
                LabelSuma.setText("=");
            } else if (actionEvent.getSource() == BotonEntre) {
                LabelSuma.setText("/");
            } else if (actionEvent.getSource() == BotonRaiz) {
                LabelSuma.setText("2");
            } else if (actionEvent.getSource() == BotonSin) {
                LabelSuma.setText("2");
            } else if (actionEvent.getSource() == BotonCos) {
                LabelSuma.setText("2");
            } else if (actionEvent.getSource() == BotonTan) {
                LabelSuma.setText("2");
            } else if (actionEvent.getSource() == BotonRecet) {
                LabelSuma.setText(null);
            }

        }
    }


}
