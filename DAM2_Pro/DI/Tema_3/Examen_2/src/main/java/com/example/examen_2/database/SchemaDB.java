package com.example.examen_2.database;

public interface SchemaDB {

    String URL = "127.0.0.1";
    String Port = "3306";

    String DB_NAME = "tienda";

    String TAB_USUARIOS = "usuarios";
    String TAB_PRODUCTOS = "productos";

    String TAB_ID_U = "id";
    String TAB_ID_P = "idProducto";

    String COL_NAME_U = "nombre";
    String COL_NAME_P = "nombreProducto";

    String COL_MAIL = "correo";
    String COL_PASS = "pass";
    String COL_CATEGORIA = "categoriaProducto";
    String COL_PRECIO = "precioProducto";

}
