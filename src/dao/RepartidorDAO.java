package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepartidorDAO {
    public int insertarRepartidor(String nombre, String telefono) {
        String sql = "INSERT INTO repartidor (nombre, telefono) VALUES (?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar repartidor: " + e.getMessage());
        }
        return -1;
    }

    public void eliminarRepartidor(int id) {
        String sql = "DELETE FROM repartidor WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Repartidor eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar repartidor: " + e.getMessage());
        }
    }
    public void listarRepartidores() {
        String sql = "SELECT * FROM repartidor";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                System.out.println("Repartidor ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + telefono);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar repartidores: " + e.getMessage());
        }
    }
}

