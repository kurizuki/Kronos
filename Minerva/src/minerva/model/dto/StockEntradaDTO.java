package minerva.model.dto;

import java.util.Date;

/**
 *
 * @author L
 */
public class StockEntradaDTO {
    private long StockEntradaID;
    private Date fechaStock;
    private long cantidad;

    public StockEntradaDTO() {
    }

    public StockEntradaDTO(long StockEntradaID, Date fechaStock, long cantidad) {
        this.StockEntradaID = StockEntradaID;
        this.fechaStock = fechaStock;
        this.cantidad = cantidad;
    }   
    
}
