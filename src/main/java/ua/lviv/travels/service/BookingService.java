package ua.lviv.travels.service;

import ua.lviv.travels.entity.Booking;

import java.util.List;

/**
 * Created by Apple on 24.04.2017.
 */
public interface BookingService {
    void add(Booking booking);

    void delete(Integer id);

    Booking findById(Integer id);

    List<Booking> findAll();
}
