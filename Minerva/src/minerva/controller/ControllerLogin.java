package minerva.controller;

import minerva.model.entity.Vendedor;
import minerva.model.entity.Autenticable;

/**
 *
 * @author L
 */
public class ControllerLogin {
    private static Autenticable vendedor = new Vendedor();
    
    public ControllerLogin() {        
    }
    
    public static boolean validarCredenciales(String usuario, String contrasena) {
        try {
            if (vendedor.getContrasenaDB(usuario).equals(contrasena)) {
                return true;
            }
        } catch (Exception e) {
            return false; // SI EL USUARIO NO EXISTE NO ES VALIDO
        }                
        return false; // SI LA CONTRASEÑA NO ES VALIDA DEVUELVE FALSE
    }
       
}
