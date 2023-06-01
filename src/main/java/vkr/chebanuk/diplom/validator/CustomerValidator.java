package vkr.chebanuk.diplom.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vkr.chebanuk.diplom.entity.Customer;
import vkr.chebanuk.diplom.service.impl.CustomerDetailsServiceImpl;

import java.util.Optional;

@Component
public class CustomerValidator implements Validator {

    @Autowired
    private CustomerDetailsServiceImpl customerDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Customer customerToValidate = (Customer) obj;
        Optional<Customer> customerFromDB = customerDetailsService.loadUserOptionalByUsername(customerToValidate.getUsername());
        if (customerFromDB.isPresent()) {
            errors.rejectValue("username", "400", "Username already exists");
        }

    }

}
