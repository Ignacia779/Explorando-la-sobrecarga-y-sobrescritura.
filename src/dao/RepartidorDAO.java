package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepartidorDAO {
    // Insertar un repartidor
    public void insertarRepartidor(String nombre, String telefono) {
        String sql = "INSERT INTO repartidor (nombre, telefono) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.executeUpdate();

            System.out.println("✅ Repartidor insertado correctamente!");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar repartidor: " + e.getMessage());
        }
    }

    public void listarRepartidores() {
        String sql = "SELECT * FROM repartidor";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Teléfono: " + rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar repartidores: " + e.getMessage());
        }
    }
}
