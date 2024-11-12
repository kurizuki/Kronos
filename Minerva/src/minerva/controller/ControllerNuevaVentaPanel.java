package minerva.controller;

import minerva.model.dto.DTOVendedor;

/**
 *
 * @author L
 */
public class ControllerNuevaVentaPanel {
    private ControllerSystem systemController = null;
    
    private DTOVendedor vendedorDTO = null;
    private String nombreCliente = "Anonimo";
    
    public ControllerNuevaVentaPanel() {
    }

    public ControllerNuevaVentaPanel(ControllerSystem systemController) {
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

}
