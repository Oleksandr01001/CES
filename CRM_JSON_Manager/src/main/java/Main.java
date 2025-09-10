import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/crm?allowPublicKeyRetrieval=true&useSSL=false";
        String usuario = "root";
        String contraseña = "M1h5o0n4_";

        try (Connection conn = DriverManager.getConnection(jdbcURL, usuario, contraseña)) {
            System.out.println("✅ Підключення до MySQL виконано.");
            System.out.println("➡ Поточна база даних: " + conn.getCatalog());

            conn.setAutoCommit(false);

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    Objects.requireNonNull(Main.class.getResourceAsStream("/ordenes_generadas_completo.json"))
            ));
            JSONTokener tokener = new JSONTokener(reader);
            JSONArray productos = new JSONArray(tokener);

            System.out.println("📦 Кількість продуктів у JSON: " + productos.length());

            String insertSQL = "INSERT INTO productos (code, fecha_lanzada, clientName, units, description, client, fecha_entrega, comment, total) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);

            int insertados = 0;

            for (int i = 0; i < productos.length(); i++) {
                JSONObject prod = productos.getJSONObject(i);

                if (prod.has("comment")) {
                    String comentario = prod.getString("comment");
                    System.out.println("📝 Коментар продукту " + i + ": " + comentario);

                    if (comentario.toLowerCase().contains("probando en ot")) {
                        System.out.println("🔎 Дані продукту: " + prod.toString());

                        pstmt.setInt(1, prod.optInt("code", 0));

                        // fecha_lanzada + fecha_entrega
                        if (prod.has("quote") && prod.getJSONObject("quote").has("initialDate")) {
                            String fechaISO = prod.getJSONObject("quote").getString("initialDate");
                            LocalDate fecha = LocalDate.parse(fechaISO.substring(0, 10));
                            pstmt.setDate(2, Date.valueOf(fecha));
                            pstmt.setDate(7, Date.valueOf(fecha));
                        } else {
                            pstmt.setNull(2, Types.DATE);
                            pstmt.setNull(7, Types.DATE);
                        }

                        pstmt.setString(3, prod.optString("clientName", ""));
                        pstmt.setInt(4, prod.optInt("units", 0));
                        pstmt.setString(5, prod.optString("description", ""));
                        pstmt.setString(6, prod.optString("client", ""));
                        pstmt.setString(8, comentario);

                        // total
                        if (prod.has("total")) {
                            pstmt.setBigDecimal(9, BigDecimal.valueOf(prod.getDouble("total")));
                        } else {
                            pstmt.setNull(9, Types.DECIMAL);
                        }

                        pstmt.executeUpdate();
                        System.out.println("✅ Вставлено продукт: code = " + prod.optInt("code"));
                        insertados++;
                    }
                } else {
                    System.out.println("⚠️ Продукт " + i + " без поля 'comment'");
                }
            }

            pstmt.close();
            conn.commit();
            reader.close();
            System.out.println("✅ Транзакцію збережено.");
            System.out.println("✅ Завершено. Всього вставлено продуктів: " + insertados);

        } catch (Exception e) {
            System.err.println("❌ Помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
