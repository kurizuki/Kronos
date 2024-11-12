package minerva.dao;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public interface IDAOProducto<T>{
    ArrayList<T> listarProducto() throws Exception;
}
