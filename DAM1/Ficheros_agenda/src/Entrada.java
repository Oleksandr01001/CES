import model.Usuario;

import java.io.IOException;

public class Entrada {

    Usuario usuario = new Usuario();

    public static void main(String[] args) throws IOException {
        OperacionesUsuario operacionesUsuario = new OperacionesUsuario();
        operacionesUsuario.escribirUsuario(new Usuario("Olek","hush","olek@gmail.com, 611530967"),"src/recursos/agenda.txt");

        operacionesUsuario.lecturaUsuarios("src/recursos/agenda.txt");

        operacionesUsuario.escribirUsuarioObjeto("src/recursos/agenda.obj", new Usuario("olek","hush","olek@gmail.com, 611530967"));
    }

}
