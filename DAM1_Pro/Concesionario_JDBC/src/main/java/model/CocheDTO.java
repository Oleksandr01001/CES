//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import database.DBConector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CocheDTO {
    public CocheDTO() {
    }

    public void insertarCoche(Coche coche) {
        String query = "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?)";
        String queryFormateada = String.format(query, "coches", "id", "marca", "color", "modelo", "matricula", "precio");

        try {
            Connection connection = DBConector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryFormateada);
            preparedStatement.setInt(1, coche.getId());
            preparedStatement.setString(2, coche.getMarca());
            preparedStatement.setString(3, coche.getColor());
            preparedStatement.setString(4, coche.getModelo());
            preparedStatement.setString(5, coche.getMatricula());
            preparedStatement.setInt(6, coche.getPrecio());
            preparedStatement.executeUpdate();
            System.out.println("Coche insertado correctamente.");
        } catch (SQLException var6) {
            SQLException e = var6;
            System.err.println("Error al insertar el coche: " + e.getMessage());
        }

    }

    public boolean getCocheMatricula(String matricula) {
        String query = String.format("SELECT * FROM %s WHERE %s = ?", "coches", "matricula");

        try {
            Connection connection = DBConector.getConnection();

            boolean var5;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, matricula);
                    var5 = preparedStatement.executeQuery().next();
                } catch (Throwable var9) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (connection != null) {
                connection.close();
            }

            return var5;
        } catch (SQLException var11) {
            SQLException e = var11;
            System.err.println("Error al comprobar matrícula: " + e.getMessage());
            return false;
        }
    }

    public void eliminarCoche(int id) {
        String query = String.format("DELETE FROM %s WHERE %s = ?", "coches", "id");

        try {
            Connection conn = DBConector.getConnection();

            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                try {
                    stmt.setInt(1, id);
                    int filasAfectadas = stmt.executeUpdate();
                    if (filasAfectadas > 0) {
                        System.out.println("Coche eliminado de la base de datos.");
                    } else {
                        System.out.println("No se encontró ningún coche con ese ID.");
                    }
                } catch (Throwable var9) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var10) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var11) {
            SQLException e = var11;
            System.out.println("Error al eliminar el coche: " + e.getMessage());
        }

    }

    public void agregarPasajero(int idCoche, int idPasajero) {
        String query = String.format("UPDATE %s SET %s = ? WHERE %s = ?", "coches", "id_pasajero", "id");

        try {
            Connection conn = DBConector.getConnection();

            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                try {
                    stmt.setInt(1, idPasajero);
                    stmt.setInt(2, idCoche);
                    int filas = stmt.executeUpdate();
                    if (filas > 0) {
                        System.out.println("Pasajero asignado correctamente al coche.");
                    } else {
                        System.out.println("No se encontró el coche para asignar pasajero.");
                    }
                } catch (Throwable var10) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var11) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var12) {
            SQLException e = var12;
            System.out.println("Error al asignar pasajero: " + e.getMessage());
        }

    }
}
