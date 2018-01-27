package ua.lviv.travels.service;

import ua.lviv.travels.entity.TourDescription;

import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
public interface TourDescriptionService {
    void add(TourDescription tourDescription);

    void delete(Integer id);

    TourDescription findById(Integer id);

    List<TourDescription> findAll();
}
