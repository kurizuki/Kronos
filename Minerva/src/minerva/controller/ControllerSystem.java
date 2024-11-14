package minerva.controller;

import javax.swing.JOptionPane;
import minerva.model.entity.Vendedor;
import minerva.model.dto.DTOVendedor;

/**
 *
 * @author L
 */
public class ControllerSystem {
    private DTOVendedor dtoVendedor = null;

    public ControllerSystem() {
    }

    public ControllerSystem(String usuario) {
        asignarDTO(usuario);
    }
    
    // ASIGNAMOS LOS DTO QUE NECESITA TODO EL PROGRAMA EN GENERAL
    private void asignarDTO(String usuario) {
        try {
            dtoVendedor = Vendedor.readVendedorDB(usuario);
        } catch (Exception ex) {
            System.out.println("CAYO LA UTLIMA BARRERA DE DEFENSA CONTRA LOS ERRRORES XD");
            dtoVendedor = new DTOVendedor(404, "404", "404", null);
        }
    }
    
    public void mostrarMensaje(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError);
    }
   
}
