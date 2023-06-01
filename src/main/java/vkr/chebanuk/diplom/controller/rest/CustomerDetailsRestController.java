package vkr.chebanuk.diplom.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vkr.chebanuk.diplom.entity.Customer;
import vkr.chebanuk.diplom.security.CustomerDetailsImpl;

@RestController
@RequestMapping(CustomerDetailsRestController.CUSTOMER_DETAILS_REST)
public class CustomerDetailsRestController {

    public static final String CUSTOMER_DETAILS_REST = "user-details";

    @GetMapping
    public ResponseEntity<Customer> findCurrentCustomer(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomerDetailsImpl customerDetails = (CustomerDetailsImpl) authentication.getPrincipal();

        if (customerDetails == null) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = customerDetails.getUser();

        return ResponseEntity.ok(customer);
    }
}
