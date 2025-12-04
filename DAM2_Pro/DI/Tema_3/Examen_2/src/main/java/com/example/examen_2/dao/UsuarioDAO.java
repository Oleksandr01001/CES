package com.example.examen_2.dao;

import com.example.examen_2.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {



    void insertarUsuario(Usuario usuario) throws SQLException;

    List<Usuario> obtenerUsuarios();


}
