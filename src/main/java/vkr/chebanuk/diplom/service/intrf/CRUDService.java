package vkr.chebanuk.diplom.service.intrf;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;

public interface CRUDService<E, K> {
    void create(E entity) throws IOException, WriterException;
    E findById(K id);
    List<E> findAll() throws IOException, WriterException;
    E update(E entity) throws IOException, WriterException;
    void delete(E entity);

}
