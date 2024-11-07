package minerva.controller;

import minerva.model.Vendedor;

/**
 *
 * @author L
 */
public class SystemController {
    private Vendedor vendedor = new Vendedor();    

    public SystemController() {
    }

    public SystemController(String usuario) {
        vendedor.asignarDatosVendedor(usuario);
    }

    public String getVendedorUsuario() {
        return vendedor.getUsuario();
    }
    
}
