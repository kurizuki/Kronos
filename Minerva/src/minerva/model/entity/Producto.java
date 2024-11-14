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
    private static IDAOProducto iDAOProducto = new TblProducto();

    public Producto() {
    }   
    
    public static void createProductoDB(DTOProducto dtoProducto) throws Exception {
        try {
            readProductoDB(dtoProducto.getCodigoBarras());
        } catch (Exception e) {
            iDAOProducto.create(dtoProducto); // BOTA LA EXCEPCION DE NO PUDO HACER LOS INSERTS
            return;
        }
        throw new Exception("EL PRODUCTO YA EXISTE EN LA DB");
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
