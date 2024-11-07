package minerva.dao;

/**
 *
 * @author L
 */
public interface CrudDAO<T> {
    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(int id);
}
