package vkr.chebanuk.diplom.service.intrf;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;

public interface CRUDService<E, K> {
    void create(E entity);
    E findById(K id);
    List<E> findAll() throws IOException, WriterException;
    E update(E entity);
    void delete(E entity);

}
