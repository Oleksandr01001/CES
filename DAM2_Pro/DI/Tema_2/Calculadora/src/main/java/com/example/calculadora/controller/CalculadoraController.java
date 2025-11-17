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

    @FXML private Button BotonCos;
    @FXML private Button BotonEntre;
    @FXML private Button BotonIgual;
    @FXML private Button BotonMas;
    @FXML private Button BotonMenos;
    @FXML private Button BotonNum0;
    @FXML private Button BotonNum1;
    @FXML private Button BotonNum2;
    @FXML private Button BotonNum3;
    @FXML private Button BotonNum4;
    @FXML private Button BotonNum5;
    @FXML private Button BotonNum6;
    @FXML private Button BotonNum7;
    @FXML private Button BotonNum8;
    @FXML private Button BotonNum9;
    @FXML private Button BotonPor;
    @FXML private Button BotonRaiz;
    @FXML private Button BotonRecet;
    @FXML private Button BotonSin;
    @FXML private Button BotonTan;

    @FXML private Label LabelProceso;
    @FXML private Label LabelSuma;

    @FXML private GridPane parteC;
    @FXML private BorderPane panelGeneral;

    @FXML private RadioButton RadioB;
    @FXML private RadioButton RadioC;

    private ToggleGroup opcinCalculadora;

    private double primerNumero = 0;
    private String operadorActual = null;
    private boolean esperandoNuevoNumero = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void instancias() {
        opcinCalculadora = new ToggleGroup();
        opcinCalculadora.getToggles().addAll(RadioC, RadioB);
    }

    private void initGUI() {
        LabelProceso.setText("");
        LabelSuma.setText("");
        if (RadioC.isSelected()) {
            panelGeneral.setRight(parteC);
        } else {
            panelGeneral.setRight(null);
        }
    }

    private void acciones() {
        EventHandler<ActionEvent> manejador = new ManejoAcciones();

        BotonNum0.setOnAction(manejador);
        BotonNum1.setOnAction(manejador);
        BotonNum2.setOnAction(manejador);
        BotonNum3.setOnAction(manejador);
        BotonNum4.setOnAction(manejador);
        BotonNum5.setOnAction(manejador);
        BotonNum6.setOnAction(manejador);
        BotonNum7.setOnAction(manejador);
        BotonNum8.setOnAction(manejador);
        BotonNum9.setOnAction(manejador);

        BotonMas.setOnAction(manejador);
        BotonMenos.setOnAction(manejador);
        BotonPor.setOnAction(manejador);
        BotonEntre.setOnAction(manejador);

        BotonIgual.setOnAction(manejador);
        BotonRecet.setOnAction(manejador);

        BotonRaiz.setOnAction(manejador);
        BotonSin.setOnAction(manejador);
        BotonCos.setOnAction(manejador);
        BotonTan.setOnAction(manejador);

        RadioC.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldVal, Boolean newVal) {
                if (newVal) {
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

            if (ae == BotonNum0 || ae == BotonNum1 || ae == BotonNum2 ||
                    ae == BotonNum3 || ae == BotonNum4 || ae == BotonNum5 ||
                    ae == BotonNum6 || ae == BotonNum7 || ae == BotonNum8 ||
                    ae == BotonNum9) {

                Button b = (Button) ae;
                String digito = b.getText();

                if (esperandoNuevoNumero || esOperador(actual) || actual.equals("=")) {
                    LabelSuma.setText(digito);
                    esperandoNuevoNumero = false;
                } else {
                    LabelSuma.setText(actual + digito);
                }

                // <<< NUEVO: actualizar la fila de arriba con toda la expresión >>>
                if (operadorActual != null && !LabelSuma.getText().isEmpty()) {
                    LabelProceso.setText(primerNumero + " " + operadorActual + " " + LabelSuma.getText());
                }

                return;
            }

            if (ae == BotonMas || ae == BotonMenos || ae == BotonPor || ae == BotonEntre) {

                String op = "";
                if (ae == BotonMas) op = "+";
                else if (ae == BotonMenos) op = "-";
                else if (ae == BotonPor) op = "*";
                else if (ae == BotonEntre) op = "/";

                if (!actual.isEmpty() && !esOperador(actual) && !actual.equals("=")) {
                    try {
                        primerNumero = Double.parseDouble(actual);
                    } catch (Exception ignored) {}
                }

                operadorActual = op;
                LabelProceso.setText(primerNumero + " " + operadorActual);
                LabelSuma.setText(op);
                esperandoNuevoNumero = true;
                return;
            }

            if (ae == BotonIgual) {
                if (operadorActual != null && !actual.isEmpty() && !esOperador(actual) && !actual.equals("=")) {

                    double segundoNumero;
                    try {
                        segundoNumero = Double.parseDouble(actual);
                    } catch (Exception e) {
                        segundoNumero = 0;
                    }

                    double resultado = 0;
                    switch (operadorActual) {
                        case "+" -> resultado = primerNumero + segundoNumero;
                        case "-" -> resultado = primerNumero - segundoNumero;
                        case "*" -> resultado = primerNumero * segundoNumero;
                        case "/" -> resultado = segundoNumero != 0 ? primerNumero / segundoNumero : 0;
                    }

                    // <<< NUEVO: mostrar toda la operación con "=" arriba >>>
                    LabelProceso.setText(primerNumero + " " + operadorActual + " " + segundoNumero + " =");

                    LabelSuma.setText(String.valueOf(resultado));
                    primerNumero = resultado;
                    operadorActual = null;
                    esperandoNuevoNumero = true;
                }
                return;
            }

            if (ae == BotonRaiz || ae == BotonSin || ae == BotonCos || ae == BotonTan) {

                if (actual.isEmpty() || esOperador(actual) || actual.equals("=")) return;

                double valor;
                try {
                    valor = Double.parseDouble(actual);
                } catch (Exception e) {
                    return;
                }

                double resultado = valor;
                String textoProceso = "";

                if (ae == BotonRaiz) {
                    resultado = Math.sqrt(valor);
                    textoProceso = "√(" + actual + ")";
                } else if (ae == BotonSin) {
                    resultado = Math.sin(Math.toRadians(valor));
                    textoProceso = "sin(" + actual + ")";
                } else if (ae == BotonCos) {
                    resultado = Math.cos(Math.toRadians(valor));
                    textoProceso = "cos(" + actual + ")";
                } else if (ae == BotonTan) {
                    resultado = Math.tan(Math.toRadians(valor));
                    textoProceso = "tan(" + actual + ")";
                }

                LabelProceso.setText(textoProceso);
                LabelSuma.setText(String.valueOf(resultado));
                primerNumero = resultado;
                operadorActual = null;
                esperandoNuevoNumero = true;
                return;
            }

            if (ae == BotonRecet) {
                LabelSuma.setText("");
                LabelProceso.setText("");
                primerNumero = 0;
                operadorActual = null;
                esperandoNuevoNumero = false;
            }
        }
    }

    private boolean esOperador(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
