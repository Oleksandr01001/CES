module com.example.pizzeria {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    requires java.sql;
    requires lombok;
    requires java.desktop;

    opens com.example.pizzeria to javafx.fxml, java.sql;
    exports com.example.pizzeria;
    exports com.example.pizzeria.controller;
    opens com.example.pizzeria.controller to javafx.fxml,java.sql;

    opens com.example.pizzeria.model to lombok,java.sql;
    exports com.example.pizzeria.model;
}