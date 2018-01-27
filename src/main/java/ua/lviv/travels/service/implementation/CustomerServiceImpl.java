package ua.lviv.travels.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.travels.dao.CustomerDao;
import ua.lviv.travels.entity.Customer;
import ua.lviv.travels.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 17.04.2017.
 */
@Service("userDetailService")
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    public void add(Customer customer) {
        customerDao.add(customer);
    }

    public void delete(Integer id) {
        customerDao.delete(customerDao.findById(id));
    }

    public Customer findById(Integer id) {
        return customerDao.findById(id);
    }

    public Customer findByLogin(String login) {
        return customerDao.findByLogin(login);
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer = customerDao.findByLogin(login);
        List<SimpleGrantedAuthority> authorityList=new ArrayList<SimpleGrantedAuthority>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(customer.getLogin(),customer.getPassword(),authorityList);
    }
}
