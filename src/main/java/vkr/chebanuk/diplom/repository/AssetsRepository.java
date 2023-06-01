package vkr.chebanuk.diplom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vkr.chebanuk.diplom.entity.Assets;

@Repository
public interface AssetsRepository extends CrudRepository<Assets, Long> {
}
