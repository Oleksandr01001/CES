package org.example.appformulario.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import org.example.appformulario.model.Usuario;

public class DialogoController implements Initializable {


    @FXML
    private Label textoEdad;

    @FXML
    private Label textoGenero;

    @FXML
    private Label textoLocalizacion;

    @FXML
    private Label textoMail;

    @FXML
    private Label textoNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setUsuario(Usuario usuario) {
        textoNombre.setText(usuario.getNombre());
        textoMail.setText(usuario.getNombre());
        textoGenero.setText(usuario.getGenero());
        textoEdad.setText(String.valueOf(usuario.getEdad()));
        textoLocalizacion.setText(String.valueOf(usuario.getLocalizacion()));

    }
}
