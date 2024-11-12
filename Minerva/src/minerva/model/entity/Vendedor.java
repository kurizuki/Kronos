package minerva.model.entity;

import minerva.model.dto.DTOVendedor;
import minerva.dao.TblVendedor;
import minerva.dao.IDAOVendedor;

/**
 *
 * @author L
 */
public class Vendedor implements Autenticable{      
    @Override
    public String getContrasenaDB(String usuario) throws Exception {
        IDAOVendedor iVendedorDAO = new TblVendedor();
        return iVendedorDAO.getContrasena(usuario);
    }
    
    public static DTOVendedor getVendedorDB(String usuario) throws Exception {
        IDAOVendedor iVendedorDAO = new TblVendedor();
        return iVendedorDAO.getVendedor(usuario);
    }
    
    public boolean validarDatos(DTOVendedor vendedorDTO) {
        return  false;
    }

}
