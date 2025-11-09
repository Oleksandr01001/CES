package org.example.appformulario.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.appformulario.model.Usuario;

import java.util.Optional;

public class ModificarController {

    @FXML private TextField tfNombre;
    @FXML private TextField tfMail;
    @FXML private TextField tfGenero;
    @FXML private TextField tfEdad;
    @FXML private TextField tfLocalizacion;

    @FXML private Button btnGuardar;
    @FXML private Button btnCancelar;

    private Usuario usuario;          // copia a editar
    private Usuario resultado = null; // se rellena si pulsan Guardar

    @FXML
    private void initialize() {
        btnGuardar.setOnAction(e -> {
            // Validaciones mínimas (opcional)
            if (tfNombre.getText().isEmpty() || tfMail.getText().isEmpty()) {
                // podrías mostrar un alerta
                return;
            }

            usuario.setNombre(tfNombre.getText());
            usuario.setCorreo(tfMail.getText());
            usuario.setGenero(tfGenero.getText());
            try {
                usuario.setEdad(Integer.parseInt(tfEdad.getText()));
            } catch (NumberFormatException ex) {
                // si hay error de número, no guardamos
                return;
            }
            usuario.setLocalizacion(tfLocalizacion.getText());

            resultado = usuario;
            ((Stage) btnGuardar.getScene().getWindow()).close();
        });

        btnCancelar.setOnAction(e ->
                ((Stage) btnCancelar.getScene().getWindow()).close()
        );
    }

    // recibe el usuario a editar (mejor una copia)
    public void setUsuario(Usuario u) {
        this.usuario = u;
        tfNombre.setText(u.getNombre());
        tfMail.setText(u.getCorreo());
        tfGenero.setText(u.getGenero());
        tfEdad.setText(String.valueOf(u.getEdad()));
        tfLocalizacion.setText(u.getLocalizacion());
    }

    public Optional<Usuario> getResultado() {
        return Optional.ofNullable(resultado);
    }
}
