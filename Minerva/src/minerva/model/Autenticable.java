package minerva.model;

/**
 *
 * @author L
 */
public interface Autenticable {
    boolean validarUsuario(String usuario);
    boolean validarCredenciales(String usuario, String contrasena);
}
