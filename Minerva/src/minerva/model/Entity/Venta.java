package minerva.model.Entity;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Venta {
    private int VendedorID;
    private int clienteID;
    private ArrayList<DetalleVenta> detalleVentas;
    private double montoTotal;

    public Venta() {
    }

    public Venta(int VendedorID, int clienteID, ArrayList<DetalleVenta> detalleVentas) {
        this.VendedorID = VendedorID;
        this.clienteID = clienteID;
        this.detalleVentas = detalleVentas;
        
        calcularMontoTotal();
    }

    public double getMontoTotal() {
        return montoTotal;
    }
    
    private void calcularMontoTotal() {
        for (DetalleVenta detalleVenta : detalleVentas) {
            montoTotal += detalleVenta.getMontoTotal();
        }
    }
}
