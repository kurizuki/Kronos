package minerva.controller;

import minerva.model.dto.DTOCliente;

/**
 *
 * @author L
 */
public class ControllerPanelNuevaVenta {
    // CONTROLADOR
    private ControllerSystem systemController = null;
    
    // DTO NECESARIOS
    private DTOCliente dTOCliente = null;
    
    public ControllerPanelNuevaVenta() {
    }

    public ControllerPanelNuevaVenta(ControllerSystem systemController) {
        this.systemController = systemController;
        asignarDTO();
    }
    
    // ASIGNAMOS LOS DTO QUE NECESITA EL PANEL    
    private void asignarDTO() {
        dTOCliente = systemController.getDtoCliente();
    }
    
    public String getNombreCliente() {
        return dTOCliente.getNombres();
    }

}
