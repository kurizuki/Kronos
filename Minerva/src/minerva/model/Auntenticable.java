package minerva.model;

/**
 *
 * @author L
 */
public interface Auntenticable {
    public boolean validarUsuario(String usuario);
    public boolean validarCredenciales(String usuario, String contrasena);
}
