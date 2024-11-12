package minerva.model.dto;

/**
 *
 * @author L
 */
public class DTODetalleVenta {
    private long ventaID;
    private long productoID;
    private long cantidad;
    private double montoTotal;

    public DTODetalleVenta() {
    }

    public DTODetalleVenta(long ventaID, long productoID, long cantidad, double montoTotal) {
        this.ventaID = ventaID;
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
    }   
    
}
