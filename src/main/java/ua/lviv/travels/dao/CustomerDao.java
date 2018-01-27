package ua.lviv.travels.dao;

import ua.lviv.travels.entity.Customer;

/**
 * Created by Apple on 17.04.2017.
 */
public interface CustomerDao {
    void add(Customer customer);

    void edit(Customer customer);

    void delete(Customer customer);

    Customer findById(Integer id);

    Customer findByLogin(String login);
}
