package minerva.controller;

import minerva.model.Vendedor;
import minerva.model.Autenticacion;

/**
 *
 * @author L
 */
public class ControladorLogin {
    private static Autenticacion vendedor = new Vendedor();

    public ControladorLogin() {
        
    }
    
    public static boolean validarCredenciales(String usuario, String contrasena) {
        boolean credenciales = vendedor.validarCredenciales(usuario, contrasena);
        if (credenciales) {
            return true; // SI LA CONTRASEÑA ES VALIDA DEVUELVE TRUE
        }
        return false; // SI LA CONTRASEÑA NO ES VALIDA DEVUELVE FALSE
    }
    
    
}
