package com.example.pizzeria.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.example.pizzeria.model.Pedido;

public class DetalleController {

    @FXML
    private Label labelNombre;
    @FXML
    private Label labelTelefono;
    @FXML
    private Label labelPizza;
    @FXML
    private Label labelTamano;
    @FXML
    private Label labelPrecio;
    @FXML
    private Label labelServido;

    public void setPedido(Pedido pedido) {
        labelNombre.setText("Nombre: " + pedido.getNombre());
        labelTelefono.setText("Teléfono: " + pedido.getTelefono());
        labelPizza.setText("Pizza: " + pedido.getPizza().getNombre());
        labelTamano.setText("Tamaño: " + pedido.getPizza().getTamanio());
        labelPrecio.setText("Precio: " + pedido.getPizza().getPrecio());
        labelServido.setText("Servido: " + (pedido.isServido() ? "Sí" : "No"));
    }
}
