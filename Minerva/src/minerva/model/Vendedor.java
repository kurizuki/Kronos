package minerva.model;

import minerva.dao.VendedorDAO;

/**
 *
 * @author L
 */
public class Vendedor implements Autenticable{
    private int vendedorID = -1;
    private String nombres;
    private String usuario;
    private VendedorDAO vendedorDAO = new VendedorDAO();

    public Vendedor() {
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
        System.out.println("TAMOS JOYA");
        this.usuario = usuario;
        System.out.println(this.usuario);
                System.out.println("TAMOS JOYA");

        this.vendedorID = vendedorDAO.consultarID(usuario);
                                System.out.println(vendedorID);

                System.out.println("TAMOS JOYA");

        this.nombres = vendedorDAO.consultarNombres(usuario); 
        System.out.println(nombres);

    }

    public String getUsuario() {
        return usuario;
    }
 
}
