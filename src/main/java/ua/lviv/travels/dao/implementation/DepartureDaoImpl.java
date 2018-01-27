package ua.lviv.travels.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.travels.dao.DepartureDao;
import ua.lviv.travels.entity.Departure;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Repository
public class DepartureDaoImpl implements DepartureDao {

    @PersistenceContext(name = "tourfirm")
    private EntityManager entityManager;

    @Transactional
    public void add(Departure departure) {
        entityManager.persist(departure);
    }

    @Transactional
    public void edit(Departure departure) {
        entityManager.merge(departure);
    }

    @Transactional
    public void delete(Departure departure) {
        entityManager.remove(departure);
    }

    @Transactional
    public Departure findById(Integer id) {
        return entityManager.find(Departure.class, id);
    }

    @Transactional
    public List<Departure> findAll() {
        return entityManager.createQuery("select c from Departure c").getResultList();
    }

    @Transactional
    public List<Departure> findAllDeparturesByName(String input) {
        return entityManager.createQuery("select d from Departure d where d.tourDescription.id = (select t.id from TourDescription t where t.name like :input)").setParameter("input", "%" + input + "%").getResultList();
    }
}
