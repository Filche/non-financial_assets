package vkr.chebanuk.diplom.controller.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vkr.chebanuk.diplom.entity.Customer;
import vkr.chebanuk.diplom.security.CustomerDetailsImpl;

import javax.security.auth.login.AccountNotFoundException;

@Controller
@RequestMapping(CustomerDetailsController.CUSTOMER_DETAILS_URL)
public class CustomerDetailsController {

    public static final String CUSTOMER_DETAILS_URL = "ui/user-details";
    public static final String CUSTOMER_DETAILS_NAME = "user-details";

    private String getEntityName(){
        return CUSTOMER_DETAILS_NAME;
    }

    @GetMapping
    public String showRead(Model model) throws AccountNotFoundException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomerDetailsImpl userDetails = (CustomerDetailsImpl) authentication.getPrincipal();

        if (userDetails == null) {
            throw new AccountNotFoundException("Account Error");
        }

        Customer user = userDetails.getUser();

        model.addAttribute("id", user.getId());
        return getEntityName() + "/read";
    }

}
