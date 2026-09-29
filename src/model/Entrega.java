package model;

public class Entrega {
    private int id;
    private int pedidoId;
    private int repartidorId;
    private String fecha;

    public Entrega() {}

    public Entrega(int id, int pedidoId, int repartidorId, String fecha) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.repartidorId = repartidorId;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPedidoId() { return pedidoId; }
    public void setPedidoId(int pedidoId) { this.pedidoId = pedidoId; }

    public int getRepartidorId() { return repartidorId; }
    public void setRepartidorId(int repartidorId) { this.repartidorId = repartidorId; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Entrega [id=" + id + ", pedidoId=" + pedidoId +
                ", repartidorId=" + repartidorId + ", fecha=" + fecha + "]";
    }
}
