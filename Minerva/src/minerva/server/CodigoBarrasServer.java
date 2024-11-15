package minerva.server;

/**
 *
 * @author L
 */
public class CodigoBarras {
    private String codigoBarras;

    public CodigoBarras() {
    }

    public CodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public String toString() {
        return "CodigoBarras{" + "codigoBarras=" + codigoBarras + '}';
    }
    
    
    
    
    
    
}
