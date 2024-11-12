package minerva.model.dto;

/**
 *
 * @author L
 */
public class DetalleVentaDTO {
    private long ventaID;
    private long productoID;
    private long cantidad;
    private double montoTotal;

    public DetalleVentaDTO() {
    }

    public DetalleVentaDTO(long ventaID, long productoID, long cantidad, double montoTotal) {
        this.ventaID = ventaID;
        this.productoID = productoID;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
    }   
    
}
