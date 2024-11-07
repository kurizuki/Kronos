package minerva.controller;

import minerva.model.Vendedor;

/**
 *
 * @author L
 */
public class NuevaVentaController {
    SystemController systemController = null;
    Vendedor vendedor = null;
    private String vendedorUsuario;
    private String cliente = "Anonimo";

    public NuevaVentaController() {
    }

    public NuevaVentaController(SystemController systemController) {
        this.systemController = systemController;
        vendedor = systemController.getVendedor();
        asignarDatosVendedor();
    }
  
    private void asignarDatosVendedor() {
        System.out.println("ASIGNAR DATOS");
        this.vendedorUsuario = vendedor.getUsuario();
        System.out.println(vendedorUsuario);
    }

    public String getVendedorUsuario() {
        return vendedorUsuario;
    }
    
    
  
}
