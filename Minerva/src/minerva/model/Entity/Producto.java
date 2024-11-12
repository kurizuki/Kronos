package minerva.model.Entity;

import minerva.model.dto.ProductoDTO;
import java.util.ArrayList;
import minerva.dao.IProductoDAO;
import minerva.dao.TablaProducto;

/**
 *
 * @author L
 */
public class Producto {
 
    public static ArrayList<ProductoDTO> listarProductoDTO() throws Exception {
        IProductoDAO a = new TablaProducto();
        return a.listarProducto();
    }
}
