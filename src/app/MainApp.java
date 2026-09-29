package app;

import dao.PedidoDAO;
import dao.RepartidorDAO;
import dao.EntregaDAO;

public class MainApp {
    public static void main(String[] args) {
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.insertarPedido("Av. HighMark 17", "COMIDA", "PENDIENTE");
        pedidoDAO.listarPedidos();

        RepartidorDAO repartidorDAO = new RepartidorDAO();
        repartidorDAO.insertarRepartidor("Vince Lombardi", "987654321");
        repartidorDAO.listarRepartidores();

        EntregaDAO entregaDAO = new EntregaDAO();
        entregaDAO.insertarEntrega(1, 1, "2026-09-28");
        entregaDAO.listarEntregas();
    }
}
