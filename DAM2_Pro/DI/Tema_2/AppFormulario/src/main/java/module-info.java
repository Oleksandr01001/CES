module org.example.appformulario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    requires lombok;
    requires java.desktop;
    requires java.sql;


    exports org.example.appformulario;
    exports org.example.appformulario.Controller;
    opens org.example.appformulario.Controller to javafx.fxml, java.sql;


    opens org.example.appformulario.model to lombok, java.sql;
    opens org.example.appformulario to javafx.fxml, lombok, java.sql;
}