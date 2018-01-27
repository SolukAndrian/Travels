package ua.lviv.travels.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.travels.dao.HotelDao;
import ua.lviv.travels.entity.Hotel;
import ua.lviv.travels.service.HotelService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    public void add(Hotel hotel) {
        hotelDao.add(hotel);
    }

    @Transactional
    public void delete(Integer id) {
        hotelDao.delete(hotelDao.findById(id));
    }

    public Hotel findById(Integer id) {
        return hotelDao.findById(id);
    }

    public List<Hotel> findAll() {
        return hotelDao.findAll();
    }
}
