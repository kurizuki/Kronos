package minerva.model;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Venta {
    private ArrayList<DetalleVenta> detalleVentas = new ArrayList<>();
    private double montoTotal = 0;

    public Venta() {
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
