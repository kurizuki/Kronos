package minerva.controller;

import minerva.model.entity.Vendedor;
import minerva.model.dto.DTOVendedor;

/**
 *
 * @author L
 */
public class ControllerSystem {
    private DTOVendedor vendedorDTO = null;

    public ControllerSystem() {
    }

    public ControllerSystem(String usuario) {
        asignarDTO(usuario);
    }
    
    // ASIGNAMOS LOS DTO QUE NECESITA TODO EL PROGRAMA EN GENERAL
    private void asignarDTO(String usuario) {
        try {
            vendedorDTO = Vendedor.getVendedorDB(usuario);
        } catch (Exception ex) {
            System.out.println("CAYO LA UTLIMA BARRERA DE DEFENSA CONTRA LOS ERRRORES XD");
            vendedorDTO = new DTOVendedor(404, "404", "404", null);
        }
    }

    public DTOVendedor getVendedorDTO() {
        return vendedorDTO;
    }
    
}