package ua.lviv.travels.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.travels.dao.HotelAccommodationDao;
import ua.lviv.travels.entity.Departure;
import ua.lviv.travels.entity.HotelAccommodation;
import ua.lviv.travels.service.HotelAccommodationService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Service
public class HotelAccommodationServiceImpl implements HotelAccommodationService {

    @Autowired
    private HotelAccommodationDao hotelAccommodationDao;

    public void add(HotelAccommodation hotelAccommodation) {
        hotelAccommodationDao.add(hotelAccommodation);
    }

    public void edit(Integer id, String dateEntry, String dateDeparture, Integer quantityReservedNumbers, Departure departure) {
        HotelAccommodation hotelAccommodation = hotelAccommodationDao.findById(id);
        if (dateEntry != null && !dateEntry.equals("")) {
            hotelAccommodation.setDateEntry(dateEntry);
        }
        if (dateDeparture != null && !dateDeparture.equals("")) {
            hotelAccommodation.setDateDeparture(dateDeparture);
        }
        if (quantityReservedNumbers != 0) {
            hotelAccommodation.setQuantityReservedNumbers(quantityReservedNumbers);
        }
        hotelAccommodationDao.edit(hotelAccommodation);
    }

    @Transactional
    public void delete(Integer id) {
        hotelAccommodationDao.delete(hotelAccommodationDao.findById(id));
    }

    public HotelAccommodation findById(Integer id) {
        return hotelAccommodationDao.findById(id);
    }

    public List<HotelAccommodation> findAll() {
        return hotelAccommodationDao.findAll();
    }
}
