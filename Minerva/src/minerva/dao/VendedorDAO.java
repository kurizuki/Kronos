package minerva.dao;

/**
 *
 * @author L
 */
public class VendedorDAO extends DAO{    
    public VendedorDAO() {       
    }
    
    public static boolean consultarExisteUsuario(String usuario) {
        final String QUERY = "SELECT Usuario FROM vendedor WHERE Usuario=?";
        String usuarioDB = "";
        
        try {            
            
            usuarioDB = (String) consultar(usuarioDB, QUERY);
            
        } catch (Exception e) {
            return false; // RETORNA FALSE SI LO QUE DEVUELVE LA BASE DE DATOS ES NULO
        }
        
        if (usuarioDB.equals(usuarioDB)) {
            return true; // RETORNA TRUE SI EL USUARIO EXISTE
        }
        return false; // RETORNA FALSE SI EL USUARIO NO EXISTE
    }
    
    public static String consultarContrasena(String usuario) {
        final String QUERY = "SELECT Contrasena FROM vendedor WHERE Usuario=?";
        String contrasenaDB = "";
        
        try {
            
            contrasenaDB = (String) consultar(usuario, QUERY);
            
        } catch (Exception e) {
            
        } 
        
        return contrasenaDB; 
    }
 
    public static int consultarID(String usuario) {
        final String QUERY = "SELECT VendedorID FROM vendedor WHERE Usuario=?";
        int usuarioID = 0;
        
        try {
            
            usuarioID = (int) (long) consultar(usuario, QUERY);
            
        } catch (Exception e) {
            usuarioID = -404;
        }
        
        return  usuarioID; 
    }
    
    public static String consultarNombres(String usuario) {        
        final String QUERY = "SELECT Nombres FROM vendedor WHERE Usuario=?";
        String nombres = "";
        
        try {
        
            nombres = (String) consultar(usuario, QUERY);
        
        } catch (Exception e) {
            
        }
        
        return nombres;
    }
 
}
