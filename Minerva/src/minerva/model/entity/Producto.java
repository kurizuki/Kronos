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

    public Producto() {
    }   
    
    public static void createProductoDB(DTOProducto dtoProducto) throws Exception {
        try {
            readProductoDB(dtoProducto.getCodigoBarras());
        } catch (Exception e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("YA EXISTE EL PRODUCTO", e.toString());
            return;
        }
        iDAOProducto.create(dtoProducto);
    }
    
    public static DTOProducto readProductoDB(long codigoBarras) throws Exception {
        return iDAOProducto.read(codigoBarras);
    }
    
    public static void updateProductoDB(DTOProducto dTOProducto) throws Exception {
        iDAOProducto.update(dTOProducto);                       
    }
    
    public static ArrayList<DTOProducto> listAllProductoDB() throws Exception {
        return iDAOProducto.listAll();
    }
}
