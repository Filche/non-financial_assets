package vkr.chebanuk.diplom.service.intrf;

import java.util.List;

public interface CRUDService<E, K> {
    void create(E entity);
    E findById(K id);
    List<E> findAll();
    E update(E entity);
    void delete(E entity);

}
