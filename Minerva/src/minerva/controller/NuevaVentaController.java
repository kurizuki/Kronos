package minerva.controller;

import minerva.model.Producto;
import minerva.model.Vendedor;

/**
 *
 * @author L
 */
public class NuevaVentaController {
    private SystemController systemController = null;
    
    private Vendedor vendedor = null;
    private String nombreCliente;
    private Producto producto = new Producto();
    
    public NuevaVentaController() {
    }

    public NuevaVentaController(SystemController systemController) {
        this.systemController = systemController;
        vendedor = systemController.getVendedor();
    }

    public String getVendedorUsuario() {
        return this.vendedor.getUsuario();
    }
    
    public String getNombreCliente() {
        return this.nombreCliente;
    }
    
    public Object[] consultarDatosProducto(int codigoBarras) {
        return Producto.consultarDatosProducto(codigoBarras);
    }
   
    private void asignarDatosCliente() {
        
    }

}
