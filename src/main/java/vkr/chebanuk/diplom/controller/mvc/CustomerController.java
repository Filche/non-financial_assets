package vkr.chebanuk.diplom.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vkr.chebanuk.diplom.entity.Customer;

@Controller
@RequestMapping(CustomerController.CUSTOMER_URL)
public class CustomerController extends CRUDController<Customer, Long>{

    public static final String CUSTOMER_URL = "ui/user";
    public static final String CUSTOMER_NAME = "user";

    @Override
    String getEntityName() {
        return CUSTOMER_NAME;
    }
}
