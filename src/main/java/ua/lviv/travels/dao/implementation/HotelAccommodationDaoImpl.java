package ua.lviv.travels.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.travels.dao.HotelAccommodationDao;
import ua.lviv.travels.entity.HotelAccommodation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Repository
public class HotelAccommodationDaoImpl implements HotelAccommodationDao {

    @PersistenceContext(name = "tourfirm")
    private EntityManager entityManager;

    @Transactional
    public void add(HotelAccommodation hotelAccommodation) {
        entityManager.persist(hotelAccommodation);
    }

    @Transactional
    public void edit(HotelAccommodation hotelAccommodation) {
        entityManager.merge(hotelAccommodation);
    }

    @Transactional
    public void delete(HotelAccommodation hotelAccommodation) {
        entityManager.remove(hotelAccommodation);
    }

    @Transactional
    public HotelAccommodation findById(Integer id) {
        return entityManager.find(HotelAccommodation.class, id);
    }

    @Transactional
    public List<HotelAccommodation> findAll() {
        return entityManager.createQuery("select c from HotelAccommodation c").getResultList();
    }
}
