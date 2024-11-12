package minerva.model.dto;

import java.util.Date;

/**
 *
 * @author L
 */
public class VentaDTO {
    private long ventaID;
    private long vendedorID;
    private long clienteID;
    private Date fechaVenta;
    private double montoTotal;

    public VentaDTO() {
    }

    public VentaDTO(long ventaID, long vendedorID, long clienteID, Date fechaVenta, double montoTotal) {
        this.ventaID = ventaID;
        this.vendedorID = vendedorID;
        this.clienteID = clienteID;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
    }
    
    
}
