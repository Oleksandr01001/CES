package org.example.appformulario.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.appformulario.HelloApplication;
import org.example.appformulario.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DialogoController implements Initializable {

    @FXML private Label textoNombre, textoLocalizacion, textoGenero, textoEdad, textoMail;
    @FXML private Button botonContestar; // “Modificar”

    private FormController formController;
    private Usuario usuarioActual;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonContestar.setOnAction(this::onModificar);
    }

    private void onModificar(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("modificar-view.fxml"));
            Parent root = loader.load();

            ModificarController mc = loader.getController();
            mc.setUsuario(new Usuario(
                    usuarioActual.getNombre(),
                    usuarioActual.getCorreo(),
                    usuarioActual.getLocalizacion(),
                    usuarioActual.getGenero(),
                    usuarioActual.getEdad(),
                    usuarioActual.isDisponibilidad()
            ));

            Stage owner = (Stage) botonContestar.getScene().getWindow();
            Stage stage = new Stage();
            stage.initOwner(owner);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setTitle("Modificar usuario");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            Optional<Usuario> res = mc.getResultado();
            if (res.isPresent()) {
                Usuario editado = res.get();
                if (formController != null) formController.actualizarUsuario(editado);
                setUsuario(editado); // refrescar labels del detalle
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setFormController(FormController controller){
        this.formController = controller;
    }

    public void setUsuario(Usuario usuario){
        this.usuarioActual = usuario;
        textoNombre.setText(usuario.getNombre());
        textoMail.setText(usuario.getCorreo());
        textoGenero.setText(usuario.getGenero());
        textoEdad.setText(String.valueOf(usuario.getEdad()));
        textoLocalizacion.setText(usuario.getLocalizacion());
    }
}
