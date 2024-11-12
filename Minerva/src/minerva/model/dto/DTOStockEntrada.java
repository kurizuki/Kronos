package minerva.model.dto;

import java.util.Date;

/**
 *
 * @author L
 */
public class DTOStockEntrada {
    private long StockEntradaID;
    private Date fechaStock;
    private long cantidad;

    public DTOStockEntrada() {
    }

    public DTOStockEntrada(long StockEntradaID, Date fechaStock, long cantidad) {
        this.StockEntradaID = StockEntradaID;
        this.fechaStock = fechaStock;
        this.cantidad = cantidad;
    }   
    
}
