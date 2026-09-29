package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntregaDAO {
    // Insertar una entrega
    public void insertarEntrega(int pedidoId, int repartidorId, String fecha) {
        String sql = "INSERT INTO entrega (pedido_id, repartidor_id, fecha) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedidoId);
            stmt.setInt(2, repartidorId);
            stmt.setString(3, fecha);
            stmt.executeUpdate();

            System.out.println("✅ Entrega registrada correctamente!");
        } catch (SQLException e) {
            System.out.println("❌ Error al registrar entrega: " + e.getMessage());
        }
    }

    public void listarEntregas() {
        String sql = "SELECT e.id, p.direccion, r.nombre, e.fecha " +
                "FROM entrega e " +
                "JOIN pedido p ON e.pedido_id = p.id " +
                "JOIN repartidor r ON e.repartidor_id = r.id";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Entrega ID: " + rs.getInt("id") +
                        ", Pedido: " + rs.getString("direccion") +
                        ", Repartidor: " + rs.getString("nombre") +
                        ", Fecha: " + rs.getString("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar entregas: " + e.getMessage());
        }
    }
}
