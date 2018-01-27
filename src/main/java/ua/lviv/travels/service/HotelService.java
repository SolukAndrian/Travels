package ua.lviv.travels.service;

import ua.lviv.travels.entity.Hotel;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface HotelService {
    void add(Hotel hotel);

    void delete(Integer id);

    Hotel findById(Integer id);

    List<Hotel> findAll();

}
