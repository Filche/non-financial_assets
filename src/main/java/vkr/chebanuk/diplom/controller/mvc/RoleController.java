package vkr.chebanuk.diplom.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vkr.chebanuk.diplom.entity.Role;

@Controller
@RequestMapping(RoleController.ROLE_URL)
public class RoleController extends CRUDController<Role, Long> {
    public static final String ROLE_URL ="ui/role";
    public static final String ROLE_NAME ="role";

    @Override
    String getEntityName() {
        return ROLE_NAME;
    }
}
