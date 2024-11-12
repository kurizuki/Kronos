package minerva.controller;

import minerva.model.VendedorDTO;

/**
 *
 * @author L
 */
public class NuevaVentaController {
    private SystemController systemController = null;
    
    private VendedorDTO vendedorDTO = null;
    private String nombreCliente = "Anonimo";
    
    public NuevaVentaController() {
    }

    public NuevaVentaController(SystemController systemController) {
        this.systemController = systemController;
        asignarDTO();
    }
    
    // ASIGNAMOS LOS DTO QUE NECESITA EL PANEL    
    private void asignarDTO() {
        vendedorDTO = systemController.getVendedorDTO();
    }

    public String getUsuarioVendendor() {   
        return vendedorDTO.getUsuario();
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
//    public Object[] consultarDatosProducto(int codigoBarras) {
//        return Producto.consultarDatosProducto(codigoBarras);
//    }
   
    private void asignarDatosCliente() {
        
    }

}
