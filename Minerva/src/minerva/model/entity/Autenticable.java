package minerva.model.entity;

/**
 *
 * @author L
 */
public interface Autenticable {
    String getContrasenaDB(String usuario) throws Exception;
}
