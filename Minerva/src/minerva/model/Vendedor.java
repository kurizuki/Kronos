package minerva.model;

import minerva.dao.VendedorDAO;

/**
 *
 * @author L
 */
public class Vendedor implements Autenticable{
    private int vendedorID;
    private String nombres;
    private String usuario;

    public Vendedor() {
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    // VALIDA SI EL VENDEDOR EXISTE EN LA BASE DE DATOS
    @Override
    public boolean validarUsuario(String usuario) {
        return VendedorDAO.consultarExisteUsuario(usuario);
    }
    
    // VALIDA EL USUARIO Y CONTRASEÑA
    @Override
    public boolean validarCredenciales(String usuario, String contrasena) {
        if (!validarUsuario(usuario)) {
            return false;
        }
        
        String contrasenaDB = VendedorDAO.consultarContrasena(usuario);
        if (contrasenaDB.equals(contrasena)) {
            return true;
        }
        return false;
    }
    
    public void asignarDatosVendedor(String usuario) {
        // VALIDAMOS QUE EL USUARIO EXISTE EN LA DB
        if (VendedorDAO.consultarExisteUsuario(usuario)) {
            this.usuario = usuario;
            this.vendedorID = VendedorDAO.consultarID(usuario);
            this.nombres = VendedorDAO.consultarNombres(usuario);
        }      
    }

}
