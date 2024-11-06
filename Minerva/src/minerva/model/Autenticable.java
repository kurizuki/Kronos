package minerva.model;

/**
 *
 * @author L
 */
public interface Autenticable {
    public boolean validarUsuario(String usuario);
    public boolean validarCredenciales(String usuario, String contrasena);
}
