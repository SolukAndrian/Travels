package ua.lviv.travels.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.travels.dao.BookingDao;
import ua.lviv.travels.entity.Booking;
import ua.lviv.travels.service.BookingService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 24.04.2017.
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;

    public void add(Booking booking) {
        bookingDao.add(booking);
    }

    @Transactional
    public void delete(Integer id) {
        bookingDao.delete(bookingDao.findById(id));
    }

    public Booking findById(Integer id) {
        return bookingDao.findById(id);
    }

    public List<Booking> findAll() {
        return bookingDao.findAll();
    }
}
