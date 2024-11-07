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
    private VendedorDAO vendedorDAO = new VendedorDAO();

    public Vendedor() {
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    // VALIDA SI EL VENDEDOR EXISTE EN LA BASE DE DATOS
    @Override
    public boolean validarUsuario(String usuario) {
        boolean usaurioExiste = vendedorDAO.consultarExisteUsuario(usuario);
        return usaurioExiste;
    }
    
    // VALIDA EL USUARIO Y CONTRASEÑA
    @Override
    public boolean validarCredenciales(String usuario, String contrasena) {
        if (!validarUsuario(usuario)) {
            return false;
        }
        
        String contrasenaDB = vendedorDAO.consultarContrasena(usuario);
        if (contrasenaDB.equals(contrasena)) {
            return true;
        }
        return false;
    }
    
    public void asignarDatosVendedor(String usuario) {
        // VALIDAMOS QUE EL USUARIO EXISTE
        if (!vendedorDAO.consultarExisteUsuario(usuario)) {
            return;
        }
        this.usuario = usuario;
        this.vendedorID = vendedorDAO.consultarID(usuario);
        this.nombres = vendedorDAO.consultarNombres(usuario);
    }

}
