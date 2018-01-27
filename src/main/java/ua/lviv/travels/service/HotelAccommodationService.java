package ua.lviv.travels.service;

import ua.lviv.travels.entity.Departure;
import ua.lviv.travels.entity.HotelAccommodation;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface HotelAccommodationService {
    void add(HotelAccommodation hotelAccommodation);

    void edit(Integer id, String dateEntry, String dateDeparture, Integer quantityReservedNumbers, Departure departure);

    void delete(Integer id);

    HotelAccommodation findById(Integer id);

    List<HotelAccommodation> findAll();
}
