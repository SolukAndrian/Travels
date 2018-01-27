package ua.lviv.travels.dao;

import ua.lviv.travels.entity.TourDescription;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface TourDescriptionDao {
    void add(TourDescription tourDescription);

    void delete(TourDescription tourDescription);

    void edit(TourDescription tourDescription);

    TourDescription findById(Integer id);

    List<TourDescription> findAll();
}
