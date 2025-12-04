package com.example.pizzeria.dao;

import com.example.pizzeria.database.DBConection;
import com.example.pizzeria.database.SchemaDB;
import com.example.pizzeria.model.Pedido;
import com.example.pizzeria.model.Pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImp implements PedidoDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PedidoDAOImp(){
        connection = DBConection.getConnection();
    }

    @Override
    public void insertarPedido(Pedido pedido) throws SQLException {
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s) VALUES (?,?,?,?,?,?)",
                SchemaDB.TAB_PEDIDO,
                SchemaDB.COL_NOMBRE,
                SchemaDB.COL_TELEFONO,
                SchemaDB.COL_PIZZA_ID,
                SchemaDB.COL_TAMANIO,
                SchemaDB.COL_PRECIO,
                SchemaDB.COL_SERVIDO
        );
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, pedido.getNombre());
        preparedStatement.setString(2,pedido.getTelefono());
        preparedStatement.setInt(3,obtenerPizzaId(pedido.getPizza().getNombre()));
        preparedStatement.setString(4,pedido.getPizza().getTamanio());
        preparedStatement.setDouble(5,pedido.getPizza().getPrecio());
        preparedStatement.setBoolean(6,pedido.isServido());

        preparedStatement.execute();
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        List<Pedido> lista = new ArrayList<>();
        try {

            String query = String.format(
                    "SELECT p.%s, p.%s, p.%s, piz.%s AS %s, p.%s, p.%s, p.%s " +
                            "FROM %s p JOIN %s piz ON p.%s = piz.%s",
                    SchemaDB.COL_ID_PEDIDO,
                    SchemaDB.COL_NOMBRE,
                    SchemaDB.COL_TELEFONO,
                    SchemaDB.COL_NOMBRE_PIZZA, SchemaDB.COL_NOMBRE_PIZZA,
                    SchemaDB.COL_TAMANIO,
                    SchemaDB.COL_PRECIO,
                    SchemaDB.COL_SERVIDO,
                    SchemaDB.TAB_PEDIDO,
                    SchemaDB.TAB_PIZZA,
                    SchemaDB.COL_PIZZA_ID,
                    SchemaDB.COL_ID_PIZZA
            );

            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombrePizza = resultSet.getString(SchemaDB.COL_NOMBRE_PIZZA);
                String nombre = resultSet.getString(SchemaDB.COL_NOMBRE);
                String telefono = resultSet.getString(SchemaDB.COL_TELEFONO);
                String tamanio = resultSet.getString(SchemaDB.COL_TAMANIO);
                boolean servido = resultSet.getBoolean(SchemaDB.COL_SERVIDO);
                double precio = resultSet.getDouble(SchemaDB.COL_PRECIO);
                int idPedido = resultSet.getInt(SchemaDB.COL_ID_PEDIDO);

                Pizza pizza = new Pizza(nombrePizza, tamanio, precio);
                Pedido pedido = new Pedido(idPedido, nombre, telefono, servido, pizza);
                lista.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    @Override
    public List<Pedido> obtenerPedidosPendientes() throws SQLException {
        List<Pedido> listaPendientes = new ArrayList<>();

        String query = String.format("SELECT * FROM %s WHERE %s = 0",
                SchemaDB.TAB_PEDIDO, SchemaDB.COL_SERVIDO);

        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            String nombrePizza = resultSet.getString(SchemaDB.COL_NOMBRE_PIZZA);
            String nombre = resultSet.getString(SchemaDB.COL_NOMBRE);
            String telefono = resultSet.getString(SchemaDB.COL_TELEFONO);
            String tamanio = resultSet.getString(SchemaDB.COL_TAMANIO);
            boolean servido = resultSet.getBoolean(SchemaDB.COL_SERVIDO);
            double precio = resultSet.getDouble(SchemaDB.COL_PRECIO);
            int idPedido = resultSet.getInt(SchemaDB.COL_ID_PEDIDO);

            Pizza pizza = new Pizza(nombrePizza,tamanio,precio);
            Pedido pedido = new Pedido(idPedido,nombre,telefono,servido,pizza);
            listaPendientes.add(pedido);
        }


        return listaPendientes;
    }

    @Override
    public void marcarServido(int idPedido) throws SQLException {
        String query = String.format("UPDATE %s SET %s = 1 WHERE %s = ?",
                SchemaDB.TAB_PEDIDO,SchemaDB.COL_SERVIDO,SchemaDB.COL_ID_PEDIDO);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idPedido);
        preparedStatement.execute();

    }

    @Override
    public Pedido obtenerPedidoPorId(int idPedido) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE %s = ?",
                SchemaDB.TAB_PEDIDO,SchemaDB.COL_ID_PEDIDO);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idPedido);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String nombrePizza = resultSet.getString(SchemaDB.COL_NOMBRE_PIZZA);
            String nombre = resultSet.getString(SchemaDB.COL_NOMBRE);
            String telefono = resultSet.getString(SchemaDB.COL_TELEFONO);
            String tamanio = resultSet.getString(SchemaDB.COL_TAMANIO);
            boolean servido = resultSet.getBoolean(SchemaDB.COL_SERVIDO);
            double precio = resultSet.getDouble(SchemaDB.COL_PRECIO);
            int id = resultSet.getInt(SchemaDB.COL_ID_PEDIDO);



            Pizza pizza = new Pizza(nombrePizza,tamanio,precio);
            Pedido pedido = new Pedido(id,nombre,telefono,servido,pizza);
            return pedido;
        }
        return null;

    }
    private int obtenerPizzaId(String nombrePizza) throws SQLException {
        String query = String.format("SELECT %s FROM %s WHERE %s = ?",
                SchemaDB.COL_ID_PIZZA,
                SchemaDB.TAB_PIZZA,
                SchemaDB.COL_NOMBRE_PIZZA
        );
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, nombrePizza);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(SchemaDB.COL_ID_PIZZA);
                } else {
                    throw new SQLException("Pizza no encontrada: " + nombrePizza);
                }
            }
        }
    }

}
