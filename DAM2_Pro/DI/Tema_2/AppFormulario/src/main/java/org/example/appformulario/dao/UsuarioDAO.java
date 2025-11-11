package org.example.appformulario.dao;

import org.example.appformulario.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void insertarUsuario(Usuario usuario) throws SQLException;

    List<Usuario> obtenerUsuarios();
    List<Usuario> obtenerUsuarios(String correo);

    int borrarUsuarios(String nombre);
    //int borrarUsuarios(String correo, String nombre);
}
