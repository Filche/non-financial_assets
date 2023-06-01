package vkr.chebanuk.diplom.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vkr.chebanuk.diplom.entity.Role;
import vkr.chebanuk.diplom.service.intrf.CRUDService;
import vkr.chebanuk.diplom.service.intrf.RoleService;

@RestController
@RequestMapping(RoleRestController.ROLE_REST_URL)
public class RoleRestController extends CRUDRestController<Role, Long>{

    public static final String ROLE_REST_URL="role";

    @Autowired
    private RoleService roleService;

    @Override
    CRUDService<Role, Long> getService() {
        return roleService;
    }
}
