package minerva.model.entity;

import minerva.model.dto.DTOProducto;
import java.util.ArrayList;
import minerva.dao.TblProducto;
import minerva.dao.IDAOProducto;
import minerva.model.ExceptionHandler;

/**
 *
 * @author L
 */
public class Producto {
    private static IDAOProducto iDAOProducto = new TblProducto();
    
    public static void registrarProductoDB(DTOProducto dtoProducto) throws Exception {
        try {
            consultarProductoDB(dtoProducto.getCodigoBarras());
        } catch (Exception e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("YA EXISTE EL PRODUCTO", e.toString());
            return;
        }
        iDAOProducto.create(dtoProducto);
    }
    
    public static void consultarProductoDB(long codigoBarras) throws Exception {
        iDAOProducto.read(codigoBarras);
    }
    
    public static void modificarProductoDB() throws Exception {
        
    }
    
    public static ArrayList<DTOProducto> listarProductoDB() throws Exception {
        return iDAOProducto.listAll();
    }
}
