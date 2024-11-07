package minerva.controller;

/**
 *
 * @author L
 */
public class NuevaVentaController {
    private SystemController systemController = null;
    
    private String vendedorUsuario = "Te saltaste el Login XD";
    private String nombreCliente   = "Anonimo";

    public NuevaVentaController() {
    }

    public NuevaVentaController(SystemController systemController) {
        this.systemController = systemController;
        asignarDatosVendedor();
        asignarDatosCliente();
    }

    public String getVendedorUsuario() {
        return this.vendedorUsuario;
    }
    
    public String getNombreCliente() {
        return this.nombreCliente;
    }

    private void asignarDatosVendedor() {
        this.vendedorUsuario = systemController.getVendedorUsuario();
    }
    
    private void asignarDatosCliente() {
        
    }

}
