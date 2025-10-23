module org.example.appformulario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens org.example.appformulario to javafx.fxml;
    exports org.example.appformulario;
}