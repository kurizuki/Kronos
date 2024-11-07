package minerva.model;

/**
 *
 * @author L
 */
public class DetalleVenta {
    private Producto producto;
    private int cantidad;
    private double montoTotal = 0;

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
    
    
    
    private void calcularMontoTotal() {
        montoTotal = producto.getPrecio() * cantidad;
    }
}
