package ua.lviv.travels.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.travels.dao.HotelDao;
import ua.lviv.travels.entity.Hotel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Repository
public class HotelDaoImpl implements HotelDao {
    @PersistenceContext(name = "tourfirm")
    private EntityManager entityManager;

    @Transactional
    public void add(Hotel hotel) {
        entityManager.persist(hotel);
    }

    @Transactional
    public void edit(Hotel hotel) {
        entityManager.merge(hotel);
    }

    @Transactional
    public void delete(Hotel hotel) {
        entityManager.remove(hotel);
    }

    @Transactional
    public Hotel findById(Integer id) {
        return entityManager.find(Hotel.class, id);
    }

    @Transactional
    public List<Hotel> findAll() {
        return entityManager.createQuery("select c from Hotel c").getResultList();
    }
}
