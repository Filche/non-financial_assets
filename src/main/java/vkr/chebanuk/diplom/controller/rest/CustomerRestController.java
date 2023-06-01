package vkr.chebanuk.diplom.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vkr.chebanuk.diplom.controller.mvc.CRUDController;
import vkr.chebanuk.diplom.entity.Customer;
import vkr.chebanuk.diplom.service.intrf.CRUDService;
import vkr.chebanuk.diplom.service.intrf.CustomerService;

@RestController
@RequestMapping(CustomerRestController.CUSTOMER_REST_URL)
public class CustomerRestController extends CRUDRestController<Customer, Long> {

    public static final String CUSTOMER_REST_URL = "user";

    @Autowired
    private CustomerService customerService;

    @Override
    CRUDService<Customer, Long> getService() {
        return customerService;
    }
}
