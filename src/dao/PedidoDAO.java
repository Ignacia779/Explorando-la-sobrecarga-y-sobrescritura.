package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {
    // Insertar un pedido
    public void insertarPedido(String direccion, String tipo, String estado) {
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, direccion);
            stmt.setString(2, tipo);
            stmt.setString(3, estado);
            stmt.executeUpdate();

            System.out.println("✅ Pedido insertado correctamente!");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar pedido: " + e.getMessage());
        }
    }

    // Listar pedidos
    public void listarPedidos() {
        String sql = "SELECT * FROM pedido";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Dirección: " + rs.getString("direccion") +
                        ", Tipo: " + rs.getString("tipo") +
                        ", Estado: " + rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar pedidos: " + e.getMessage());
        }
    }
}
