package vkr.chebanuk.diplom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vkr.chebanuk.diplom.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
