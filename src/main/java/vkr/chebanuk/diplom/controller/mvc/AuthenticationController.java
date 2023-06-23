package vkr.chebanuk.diplom.controller.mvc;

import com.google.zxing.WriterException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vkr.chebanuk.diplom.entity.Customer;
import vkr.chebanuk.diplom.service.intrf.CustomerService;
import vkr.chebanuk.diplom.validator.CustomerValidator;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private CustomerValidator customerValidator;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") Customer user) {
        return "auth/registration";
    }

    @PostMapping("/process-registration")
    public String processRegistration(@ModelAttribute("user") @Valid Customer user,
                                      BindingResult bindingResult) throws IOException, WriterException {

        customerValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            return "/auth/registration";
        }

        customerService.create(user);
        return "redirect:/auth/login";
    }

}
