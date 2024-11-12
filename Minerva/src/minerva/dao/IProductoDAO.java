package minerva.dao;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public interface IProductoDAO<T>{
    ArrayList<T> listarProducto() throws Exception;
}
