package minerva.dao;

import minerva.model.dto.VendedorDTO;

/**
 *
 * @author L
 */
public interface IVendedorDAO {
    VendedorDTO getVendedor(String usuario) throws Exception;
    String getContrasena(String usuario) throws Exception;
}
