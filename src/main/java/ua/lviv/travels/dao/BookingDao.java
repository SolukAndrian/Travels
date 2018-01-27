package ua.lviv.travels.dao;

import ua.lviv.travels.entity.Booking;

import java.util.List;

/**
 * Created by Apple on 24.04.2017.
 */
public interface BookingDao {
    void add(Booking booking);

    void edit(Booking booking);

    void delete(Booking booking);

    Booking findById(Integer id);

    List<Booking> findAll();
}
