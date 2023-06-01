package vkr.chebanuk.diplom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vkr.chebanuk.diplom.entity.CustomerRole;

@Repository
public interface CustomerRoleRepository extends CrudRepository<CustomerRole, Long> {
    Iterable<CustomerRole> findAllByCustomerId(Long userId);

}
