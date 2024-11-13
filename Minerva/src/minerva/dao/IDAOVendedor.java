package minerva.dao;

import minerva.model.dto.DTOVendedor;

/**
 *
 * @author L
 */
public interface IDAOVendedor {
    DTOVendedor read(String usuario) throws Exception;
    String readContrasena(String usuario) throws Exception;
}
