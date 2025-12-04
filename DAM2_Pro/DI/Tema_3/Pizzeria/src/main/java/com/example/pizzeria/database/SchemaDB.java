package com.example.pizzeria.database;

public interface SchemaDB {
    String URL = "127.0.0.1";
    String Port = "3306";

    String DB_NAME = "pizzeria2";
    String TAB_PIZZA = "pizza";
    String TAB_PEDIDO = "pedidos";
    String COL_ID_PIZZA = "idPizza";
    String COL_ID_PEDIDO = "id";
    String COL_PIZZA_ID = "pizza_id";
    String COL_NOMBRE_PIZZA = "nombrePizza";
    String COL_NOMBRE = "nombre";
    String COL_TELEFONO = "telefono";
    String COL_PRECIO = "precio";
    String COL_SERVIDO = "servido";
    String COL_TAMANIO = "tamanio";
}
