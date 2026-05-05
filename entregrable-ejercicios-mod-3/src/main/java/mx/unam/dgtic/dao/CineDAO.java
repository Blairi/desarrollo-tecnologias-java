package mx.unam.dgtic.dao;

import java.util.List;

public interface CineDAO<T> {
    List<T> findAll();
    T findById(int id);
    void save(T entity);
    void update(T entity);
    void delete(int id);
}
