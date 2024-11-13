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

    public Vendedor() {
    }

    public static DTOVendedor readVendedorDB(String usuario) throws Exception {
        return iVendedorDAO.read(usuario);
    }       

    @Override
    public String readContrasenaDB(String usuario) throws Exception {
        return iVendedorDAO.readContrasena(usuario);
    }

}
