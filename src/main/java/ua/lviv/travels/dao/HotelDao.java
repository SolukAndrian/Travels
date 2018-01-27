package ua.lviv.travels.dao;

import ua.lviv.travels.entity.Hotel;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface HotelDao {
    void add(Hotel hotel);

    void edit(Hotel hotel);

    void delete(Hotel hotel);

    Hotel findById(Integer id);

    List<Hotel> findAll();
}
