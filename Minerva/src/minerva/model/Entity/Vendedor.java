package minerva.model.Entity;

import minerva.model.dto.VendedorDTO;
import minerva.dao.IVendedorDAO;
import minerva.dao.TablaVendedor;

/**
 *
 * @author L
 */
public class Vendedor implements Autenticable{      
    @Override
    public String getContrasenaDB(String usuario) throws Exception {
        IVendedorDAO iVendedorDAO = new TablaVendedor();
        return iVendedorDAO.getContrasena(usuario);
    }
    
    public static VendedorDTO getVendedorDB(String usuario) throws Exception {
        IVendedorDAO iVendedorDAO = new TablaVendedor();
        return iVendedorDAO.getVendedor(usuario);
    }
    
    public boolean validarDatos(VendedorDTO vendedorDTO) {
        return  false;
    }

}
