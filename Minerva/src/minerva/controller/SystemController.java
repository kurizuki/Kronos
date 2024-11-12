package minerva.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import minerva.model.Vendedor;
import minerva.model.VendedorDTO;

/**
 *
 * @author L
 */
public class SystemController {
    private VendedorDTO vendedorDTO = null;

    public SystemController() {
    }

    public SystemController(String usuario) {
        asignarDTO(usuario);
    }
    
    // ASIGNAMOS LOS DTO QUE NECESITA TODO EL PROGRAMA EN GENERAL
    private void asignarDTO(String usuario) {
        try {
            vendedorDTO = Vendedor.getVendedorDB(usuario);
        } catch (Exception ex) {
            System.out.println("CAYO LA UTLIMA BARRERA DE DEFENSA CONTRA LOS ERRRORES XD");
            vendedorDTO = new VendedorDTO(404, "404", "404");
        }
    }

    public VendedorDTO getVendedorDTO() {
        return vendedorDTO;
    }
    
}
