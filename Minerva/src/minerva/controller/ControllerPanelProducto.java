package minerva.controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import minerva.model.ExceptionHandler;
import minerva.model.dto.DTOProducto;
import minerva.model.entity.Producto;

/**
 *
 * @author L
 */
public class ControllerPanelProducto {
    private ControllerSystem systemController = null;
    private ExceptionHandler exceptionHandler = null;

    public ControllerPanelProducto(ControllerSystem systemController) {
        this.systemController = systemController;
    }
    
    public boolean createProductoDB(DTOProducto dtoProducto) {
        try {
            Producto.createProductoDB(dtoProducto);
        } catch (Exception e) {
            exceptionHandler = new ExceptionHandler("ERROR AL INGRESAR PRODUCTO", e.toString());
            return false;
        }
        return true;
    }
    
    public DTOProducto readProductoDB(long codigoBarras) {
        DTOProducto dtoProducto = null;
        try {
            dtoProducto = Producto.readProductoDB(codigoBarras);
        } catch (Exception e) {
            exceptionHandler = new ExceptionHandler("ERROR AL CONSULTAR PRODUCTO", e.toString());
        }
        return dtoProducto;
    }
    
    public ArrayList<DTOProducto> listAllProductoDB() {
        ArrayList<DTOProducto> dtoProducto = null;
        try {
            dtoProducto = Producto.listAllProductoDB();
        } catch (Exception e) {
            exceptionHandler = new ExceptionHandler("ERROR AL CONSULTAR PRODUCTO", e.toString());
        }
        return dtoProducto;
    }
    
    public boolean updateProductoDB(DTOProducto dtoProducto) {
        try {
            Producto.updateProductoDB(dtoProducto);
        } catch (Exception e) {            
            exceptionHandler = new ExceptionHandler("ERROR AL ACTUALIZAR", e.toString());
            return false;
        }
        return true;
    }
}
