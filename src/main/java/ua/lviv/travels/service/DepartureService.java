package ua.lviv.travels.service;

import ua.lviv.travels.entity.Departure;
import ua.lviv.travels.entity.HotelAccommodation;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface DepartureService {
    void add(Departure departure);

    void delete(Integer id);

    Departure findById(Integer id);

    List<Departure> findAll();

    List<HotelAccommodation> getAllHotelsForDeparture(Departure departure);

    List<Departure> findAllDeparturesByName(String input);
}
