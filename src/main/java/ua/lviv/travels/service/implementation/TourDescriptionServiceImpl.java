package ua.lviv.travels.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.travels.dao.TourDescriptionDao;
import ua.lviv.travels.entity.TourDescription;
import ua.lviv.travels.service.TourDescriptionService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Service
public class TourDescriptionServiceImpl implements TourDescriptionService {

    @Autowired
    private TourDescriptionDao tourDescriptionDao;

    public void add(TourDescription tourDescription) {
        tourDescriptionDao.add(tourDescription);
    }

    @Transactional
    public void delete(Integer id) {
        tourDescriptionDao.delete(tourDescriptionDao.findById(id));
    }

    public TourDescription findById(Integer id) {
        return tourDescriptionDao.findById(id);
    }

    public List<TourDescription> findAll() {
        return tourDescriptionDao.findAll();
    }
}
