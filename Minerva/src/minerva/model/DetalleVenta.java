package minerva.model;

/**
 *
 * @author L
 */
public class DetalleVenta {
    private Producto producto;
    private int cantidad;
    private double montoTotal;

    public DetalleVenta() {
    }

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        
        calcularMontoTotal();
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        
            calcularMontoTotal();
        }        
    }

    private void calcularMontoTotal() {
        montoTotal = producto.getPrecio() * cantidad;
    }
}
