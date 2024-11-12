package minerva.dao;

import java.util.LinkedList;

/**
 *
 * @author L
 */
public interface ICrud <T, R>{
    void create(T entidad);
    T read(R identificador) throws Exception;
    void update(T entidad);
    void delete(R identificador);
    LinkedList<T> listAll() throws Exception;
}
