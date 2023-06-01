package vkr.chebanuk.diplom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vkr.chebanuk.diplom.entity.Customer;
import vkr.chebanuk.diplom.entity.CustomerRole;
import vkr.chebanuk.diplom.repository.CustomerRepository;
import vkr.chebanuk.diplom.repository.CustomerRoleRepository;
import vkr.chebanuk.diplom.repository.RoleRepository;
import vkr.chebanuk.diplom.security.CustomerDetailsImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CustomerRoleRepository customerRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> userOptional = loadUserOptionalByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }
        Customer user = userOptional.get();
        setAuthorities(user);
        return new CustomerDetailsImpl(user);
    }

    public Optional<Customer> loadUserOptionalByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    private void setAuthorities(Customer user) {
        Long userId = user.getId();

        List<CustomerRole> userRoles = (List<CustomerRole>) customerRoleRepository.findAllByCustomerId(userId);

        List<Long> roleIds = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());

        List<String> authorities = roleIds.stream().map(roleId -> roleRepository.findById(roleId).get().getTitle()).collect(Collectors.toList());

        user.setAuthorities(authorities);
    }
}
