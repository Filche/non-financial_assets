package vkr.chebanuk.diplom.controller.rest;


import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vkr.chebanuk.diplom.service.intrf.CRUDService;

import java.io.IOException;
import java.util.List;

public abstract class CRUDRestController<E, K> {

    abstract CRUDService<E, K> getService();

    @PostMapping
    public ResponseEntity<E> create(@RequestBody E object){
        getService().create(object);
        return ResponseEntity.ok(object);
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable K id){
        E object = getService().findById(id);
        if (object == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(object);
    }

    @GetMapping
    public ResponseEntity<List<E>> findAll() throws IOException, WriterException {
        List<E> objects = getService().findAll();
        return ResponseEntity.ok(objects);
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E object){
        E updatedObject = getService().update(object);
        return ResponseEntity.ok(updatedObject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable K id){
        E objectForDelete = getService().findById(id);
        getService().delete(objectForDelete);
        return ResponseEntity.noContent().build();
    }
}
