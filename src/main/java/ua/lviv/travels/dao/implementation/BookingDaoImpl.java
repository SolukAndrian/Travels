package ua.lviv.travels.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.travels.dao.BookingDao;
import ua.lviv.travels.entity.Booking;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 24.04.2017.
 */
@Repository
public class BookingDaoImpl implements BookingDao {
    @PersistenceContext(name = "tourfirm")
    EntityManager entityManager;

    @Transactional
    public void add(Booking booking) {
        entityManager.persist(booking);
    }

    @Transactional
    public void edit(Booking booking) {
        entityManager.merge(booking);
    }

    @Transactional
    public void delete(Booking booking) {
        entityManager.remove(booking);
    }

    @Transactional
    public Booking findById(Integer id) {
        return entityManager.find(Booking.class, id);
    }

    public List<Booking> findAll() {
        return entityManager.createQuery("select c from Booking c").getResultList();
    }
}
