package ua.lviv.travels.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.travels.dao.CustomerDao;
import ua.lviv.travels.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Apple on 17.04.2017.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext(name = "tourfirm")
    EntityManager entityManager;

    @Transactional
    public void add(Customer customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public void edit(Customer customer) {
        entityManager.merge(customer);
    }

    @Transactional
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }

    @Transactional
    public Customer findById(Integer id) {
        return entityManager.find(Customer.class, id);
    }

    @Transactional
    public Customer findByLogin(String login) {
        return (Customer) entityManager.createQuery("select c from Customer c where c.login=:login").setParameter("login", login).getSingleResult();
    }
}
