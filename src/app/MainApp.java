package app;

import dao.PedidoDAO;
import dao.RepartidorDAO;
import dao.EntregaDAO;
public class MainApp {
    public static void main(String[] args) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        RepartidorDAO repartidorDAO = new RepartidorDAO();
        EntregaDAO entregaDAO = new EntregaDAO();

        int pedidoId = pedidoDAO.insertarPedido("Av. HighMark 17", "COMIDA", "PENDIENTE");
        System.out.println("✅ Pedido insertado con ID: " + pedidoId);

        int repartidorId = repartidorDAO.insertarRepartidor("Vince Lombardi", "987654321");
        System.out.println("✅ Repartidor insertado con ID: " + repartidorId);

        int entregaId = entregaDAO.insertarEntrega(pedidoId, repartidorId, "2026-10-04");
        System.out.println("✅ Entrega registrada con ID: " + entregaId);

        System.out.println("📋 Repartidores actuales:");
        repartidorDAO.listarRepartidores();

        repartidorDAO.eliminarRepartidor(repartidorId);

        System.out.println("📋 Repartidores después de eliminar:");
        repartidorDAO.listarRepartidores();
    }
}
