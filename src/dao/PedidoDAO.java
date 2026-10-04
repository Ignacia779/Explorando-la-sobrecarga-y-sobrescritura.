package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {
    public int insertarPedido(String direccion, String tipo, String estado) {
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";
        int idGenerado = -1;

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, direccion);
            stmt.setString(2, tipo);
            stmt.setString(3, estado);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                }
            }

            System.out.println("✅ Pedido insertado correctamente con ID: " + idGenerado);
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar pedido: " + e.getMessage());
        }
        return idGenerado;
    }

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
    public void actualizarEstadoPedido(int id, String nuevoEstado) {
        String sql = "UPDATE pedido SET estado = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("✅ Estado del pedido actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar estado: " + e.getMessage());
        }
    }
    public void eliminarPedido(int id) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Pedido eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar pedido: " + e.getMessage());
        }
    }

}
