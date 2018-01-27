package ua.lviv.travels.service;

import ua.lviv.travels.entity.Customer;

/**
 * Created by Apple on 17.04.2017.
 */
public interface CustomerService {
    void add(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);

    Customer findByLogin(String login);

}
