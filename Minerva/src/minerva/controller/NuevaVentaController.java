package minerva.controller;

import minerva.model.Vendedor;

/**
 *
 * @author L
 */
public class NuevaVentaController {
    private SystemController systemController = null;
    
    private String vendedorUsuario = "Te saltaste el Login XD";
    private String cliente         = "Anonimo";

    public NuevaVentaController() {
    }

    public NuevaVentaController(SystemController systemController) {
        this.systemController = systemController;
        asignarDatosPanel();
    }

    public String getVendedorUsuario() {
        return vendedorUsuario;
    }

    private void asignarDatosPanel() {
        vendedorUsuario = systemController.getVendedorUsuario();
    }

}
