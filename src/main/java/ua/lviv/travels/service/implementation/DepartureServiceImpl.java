package ua.lviv.travels.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.travels.dao.DepartureDao;
import ua.lviv.travels.entity.Departure;
import ua.lviv.travels.entity.HotelAccommodation;
import ua.lviv.travels.service.DepartureService;
import ua.lviv.travels.service.HotelAccommodationService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Service
public class DepartureServiceImpl implements DepartureService {

    @Autowired
    private DepartureDao departureDao;

    @Autowired
    private HotelAccommodationService hotelAccommodationService;

    public void add(Departure departure) {
        departureDao.add(departure);
    }

    @Transactional
    public void delete(Integer id) {
        departureDao.delete(departureDao.findById(id));
    }

    public Departure findById(Integer id) {
        return departureDao.findById(id);
    }

    public List<Departure> findAll() {
        return departureDao.findAll();
    }

    public List<HotelAccommodation> getAllHotelsForDeparture(Departure departure) {
        List<HotelAccommodation> hotelAccommodations = new ArrayList<HotelAccommodation>();
        for (HotelAccommodation hotelAccommodation : hotelAccommodationService.findAll()) {
            if (hotelAccommodation.getDeparture() != null) {
                if (hotelAccommodation.getDeparture().getId() == departure.getId()) {
                    hotelAccommodations.add(hotelAccommodation);
                }
            }
        }
        return hotelAccommodations;
    }

    public List<Departure> findAllDeparturesByName(String input) {
        return departureDao.findAllDeparturesByName(input);
    }
}
