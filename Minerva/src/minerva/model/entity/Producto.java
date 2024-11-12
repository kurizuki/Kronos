package minerva.model.entity;

import minerva.model.dto.DTOProducto;
import java.util.ArrayList;
import minerva.dao.TblProducto;
import minerva.dao.IDAOProducto;

/**
 *
 * @author L
 */
public class Producto {
 
    public static ArrayList<DTOProducto> listarProductoDTO() throws Exception {
        IDAOProducto a = new TblProducto();
        return a.listarProducto();
    }
}
