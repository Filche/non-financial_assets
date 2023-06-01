package vkr.chebanuk.diplom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vkr.chebanuk.diplom.entity.Customer;
import vkr.chebanuk.diplom.entity.CustomerRole;
import vkr.chebanuk.diplom.repository.CustomerRepository;
import vkr.chebanuk.diplom.repository.CustomerRoleRepository;
import vkr.chebanuk.diplom.repository.RoleRepository;
import vkr.chebanuk.diplom.service.intrf.CustomerService;

@Service
public class CustomerServiceImpl extends AbstractCRUDService<Customer,Long> implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CustomerRoleRepository userRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    CrudRepository<Customer, Long> getRepository() {
        return customerRepository;
    }

    @Override
    public void create(Customer user) {
        //encode password
        /*String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);*/

        //save user into user_table
        getRepository().save(user);

        //save user and role into user_role
        /*CustomerRole customerRole = new CustomerRole();
        customerRole.setCustomerId(customer.getId());
        customerRole.setRoleId(roleRepository.findByTitle(Roles.ROLE_USER.name()).get().getId());
        userRoleRepository.save(userRole);*/
    }

}
