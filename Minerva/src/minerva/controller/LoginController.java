package minerva.controller;

import minerva.model.Vendedor;
import minerva.model.Autenticable;

/**
 *
 * @author L
 */
public class LoginController {
    private static Autenticable vendedor = new Vendedor();
    
    public LoginController() {
        
    }
    
    public static boolean validarCredenciales(String usuario, String contrasena) {
        boolean credenciales = vendedor.validarCredenciales(usuario, contrasena);
        if (credenciales) {            
            return true; // SI LA CONTRASEÑA ES VALIDA DEVUELVE TRUE
        }
        return false; // SI LA CONTRASEÑA NO ES VALIDA DEVUELVE FALSE
    }
    
    
}
