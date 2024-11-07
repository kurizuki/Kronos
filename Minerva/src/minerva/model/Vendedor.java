package minerva.model;

import minerva.dao.VendedorDAO;

/**
 *
 * @author L
 */
public class Vendedor implements Autenticable{
    private String VendedorID;
    private String Nombres;
    private String Usuario;
    private VendedorDAO vendedorDAO = new VendedorDAO();

    public Vendedor() {
    }

    // VALIDA SI EL USUARIO EXISTE EN LA BASE DE DATOS
    @Override
    public boolean validarUsuario(String usuario) {
        boolean usaurioExiste = vendedorDAO.consultarExistenciaUsuario(usuario);
        return usaurioExiste;
    }
    
    // VALIDA EL USUARIO Y CONTRASEÑA
    @Override
    public boolean validarCredenciales(String usuario, String contrasena) {
        if (!validarUsuario(usuario)) {
            return false;
        }
        
        String contrasenaDB = vendedorDAO.consultarContrasena(usuario, contrasena);
        if (contrasenaDB.equals(contrasena)) {
            return true;
        }
        return false;
    }
    
    public void asignarDatosVendedor(String usuario) {
        String[] datosUsuario = new String[3];
        datosUsuario = vendedorDAO.consultarDatos(usuario);
        
        this.VendedorID = datosUsuario[0];
        this.Nombres = datosUsuario[1];
        this.Usuario = datosUsuario[2];
        
    }

    public String getVendedorID() {
        return VendedorID;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getUsuario() {
        return Usuario;
    }
 
}
