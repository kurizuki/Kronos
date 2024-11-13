package minerva.model.entity;

import minerva.model.dto.DTOVendedor;
import minerva.dao.TblVendedor;
import minerva.dao.IDAOVendedor;

/**
 *
 * @author L
 */
public class Vendedor implements Autenticable{
    private static IDAOVendedor iVendedorDAO = new TblVendedor();
    
    public static DTOVendedor getVendedorDB(String usuario) throws Exception {
        return iVendedorDAO.getVendedor(usuario);
    }       
        
    @Override
    public String getContrasenaDB(String usuario) throws Exception {
        return iVendedorDAO.getContrasena(usuario);
    }

}
