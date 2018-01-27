package ua.lviv.travels.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.travels.dao.TourDescriptionDao;
import ua.lviv.travels.entity.TourDescription;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Repository
public class TourDescriptionDaoImpl implements TourDescriptionDao {

    @PersistenceContext(name = "tourfirm")
    private EntityManager entityManager;

    @Transactional
    public void add(TourDescription tourDescription) {
        entityManager.persist(tourDescription);
    }

    @Transactional
    public void delete(TourDescription tourDescription) {
        entityManager.remove(tourDescription);
    }

    @Transactional
    public void edit(TourDescription tourDescription) {
        entityManager.merge(tourDescription);
    }

    @Transactional
    public TourDescription findById(Integer id) {
        return entityManager.find(TourDescription.class, id);
    }

    @Transactional
    public List<TourDescription> findAll() {
        return entityManager.createQuery("select c from TourDescription c").getResultList();
    }
}
