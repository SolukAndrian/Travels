package ua.lviv.travels.dao;

import ua.lviv.travels.entity.Departure;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface DepartureDao {
    void add(Departure departure);

    void edit(Departure departure);

    void delete(Departure departure);

    Departure findById(Integer id);

    List<Departure> findAll();

    List<Departure> findAllDeparturesByName(String input);
}
