package model;


import database.DBConnector;
import database.SchemaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static database.DBConnector.getConnection;

public class ProfesorDTO {

    public void insertarProfesor(Profesor profesor) {
        String sql = String.format("Insert into %s (%s,%s,%s) values (?,?,?)",
        SchemaDB.TAB_PROFESORES,
        SchemaDB.COL_NOMBRE,
        SchemaDB.COL_DNI,
        SchemaDB.COL_SALARIO );



        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, profesor.getNombre());
            preparedStatement.setString(2, profesor.getDni());
            preparedStatement.setDouble(3,profesor.getSalario());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarDatos() {
        String sql = String.format("Select * from %s", SchemaDB.TAB_PROFESORES);

        try {
            Connection connection = DBConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = resultSet.getString(SchemaDB.COL_NOMBRE);
                String dni = resultSet.getString(SchemaDB.COL_DNI);
                String salario = resultSet.getString(SchemaDB.COL_SALARIO);
                System.out.println("Nombre: "+nombre);
                System.out.println("Salario: "+salario);
                System.out.println("DNI: "+dni);
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
