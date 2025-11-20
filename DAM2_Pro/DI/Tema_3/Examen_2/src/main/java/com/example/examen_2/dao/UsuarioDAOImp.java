package com.example.examen_2.dao;

import com.example.examen_2.database.DBConnector;
import com.example.examen_2.database.SchemaDB;
import com.example.examen_2.model.Usuario;

import javax.xml.validation.Schema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO{

    private Connection connection;
    private PreparedStatement preparedStatement;


    public UsuarioDAOImp() {
        connection = DBConnector.getConnection();
    }


    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException {


    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+ SchemaDB.TAB_USUARIOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nombre = resultSet.getString(SchemaDB.COL_NAME_U);
                String mail =resultSet.getString(SchemaDB.COL_MAIL);
                String pass = resultSet.getString(SchemaDB.COL_PASS);
                Usuario usuario = new Usuario(nombre,mail,pass);
                lista.add(usuario);
            }


        } catch (SQLException e) {
            System.out.println("Error en la query");
        }

        return lista;
    }


}



