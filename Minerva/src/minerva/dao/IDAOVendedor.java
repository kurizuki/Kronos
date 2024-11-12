package minerva.dao;

import minerva.model.dto.DTOVendedor;

/**
 *
 * @author L
 */
public interface IDAOVendedor {
    DTOVendedor getVendedor(String usuario) throws Exception;
    String getContrasena(String usuario) throws Exception;
}
