package vkr.chebanuk.diplom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import vkr.chebanuk.diplom.entity.Role;
import vkr.chebanuk.diplom.repository.RoleRepository;
import vkr.chebanuk.diplom.service.intrf.RoleService;

@Service
public class RoleServiceImpl extends AbstractCRUDService<Role, Long> implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public CrudRepository<Role, Long> getRepository() {
        return roleRepository;
    }
}