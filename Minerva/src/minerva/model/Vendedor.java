package minerva.model;

import minerva.dao.VendedorDAO;

/**
 *
 * @author A
 */
public class Vendedor implements Auntenticable{
    private int VendedorID;
    private String Nombres;
    private String Usuario;
    private VendedorDAO vendedorDAO = new VendedorDAO();

    public Vendedor() {
    }

    public Vendedor(int VendedorID, String Nombres, String Usuario) {
        this.VendedorID = VendedorID;
        this.Nombres = Nombres;
        this.Usuario = Usuario;
    }

    // VALIDA SI EL USUARIO EXISTE EN LA BASE DE DATOS
    @Override
    public boolean validarUsuario(String usuario) {
        boolean usaurioExiste = vendedorDAO.consultarUsuario(usuario);
        return usaurioExiste;
    }
    
    // VALIDA EL USUARIO Y CONTRASEÑA
    @Override
    public boolean validarCredenciales(String usuario, String contrasena) {
        if (!validarUsuario(usuario)) {
            return false;
        }
        
        boolean credenciales = vendedorDAO.consultarCredenciales(usuario, contrasena);        
        return credenciales;
    }

}
