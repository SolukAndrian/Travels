package ua.lviv.travels.dao;

import ua.lviv.travels.entity.HotelAccommodation;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface HotelAccommodationDao {
    void add(HotelAccommodation hotelAccommodation);

    void edit(HotelAccommodation hotelAccommodation);

    void delete(HotelAccommodation hotelAccommodation);

    HotelAccommodation findById(Integer id);

    List<HotelAccommodation> findAll();
}
