package minerva.controller;

/**
 *
 * @author L
 */
public class NuevaVentaController {
    private String vendedorUsuario;
    private String cliente = "Anonimo";


    public NuevaVentaController() {
    }

    public String getVendedorUsuario() {
        return vendedorUsuario;
    }

    public void setVendedorUsuario(String vendedor) {
        this.vendedorUsuario = vendedor;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    

    

    
    
}
