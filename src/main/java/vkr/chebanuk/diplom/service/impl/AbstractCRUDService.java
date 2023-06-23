package vkr.chebanuk.diplom.service.impl;

import com.google.zxing.WriterException;
import org.springframework.data.repository.CrudRepository;
import vkr.chebanuk.diplom.service.intrf.CRUDService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCRUDService<E, K> implements CRUDService<E, K> {

    abstract CrudRepository<E, K> getRepository();
    @Override
    public void create(E object) throws IOException, WriterException {
        getRepository().save(object);
    }
    @Override
    public E findById(K id) {
        return getRepository().findById(id).orElse(null);
    }
    @Override
    public List<E> findAll() throws IOException, WriterException {
        List<E> objects = new ArrayList<>();
        getRepository().findAll().forEach(objects::add);
        return objects;
    }
    @Override
    public E update(E object) throws IOException, WriterException {
        getRepository().save(object);
        return object;
    }
    @Override
    public void delete(E object) {
        getRepository().delete(object);
    }
}
