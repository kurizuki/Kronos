package minerva.dao;

import java.util.ArrayList;
import minerva.model.dto.DTOProducto;

/**
 *
 * @author L
 */
public interface IDAOProducto {
    DTOProducto read(long codigoBarras) throws Exception;
    ArrayList<DTOProducto> listAll() throws Exception;
    void create(DTOProducto dtoProducto) throws Exception;
    void update(DTOProducto dTOProducto) throws Exception;
}
