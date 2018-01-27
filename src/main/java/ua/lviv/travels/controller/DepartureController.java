package ua.lviv.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.travels.entity.*;
import ua.lviv.travels.service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Controller
public class DepartureController {
    @Autowired
    private DepartureService departureService;

    @Autowired
    private TourDescriptionService tourDescriptionService;

    @RequestMapping(value = "/departureAdd", method = RequestMethod.GET)
    public String getDepartureAddingPage(Model model) {
        List<TourDescription> tourDescriptions = tourDescriptionService.findAll();
        model.addAttribute("tours", tourDescriptions);
        return "departure";
    }

    @RequestMapping(value = "/departureAdd", method = RequestMethod.POST)
    public String addDeparture(@RequestParam(value = "date") String date,
                               @RequestParam(value = "typeTrip") String typeTrip,
                               @RequestParam(value = "price") Double price,
                               @RequestParam(value = "tour") Integer tourId) {
        Departure departure = new Departure(date, typeTrip, price, tourDescriptionService.findById(tourId));
        departureService.add(departure);
        return "redirect:/";
    }

    @RequestMapping(value = "/departureDelete/{id}")
    public String deleteDeparture(@PathVariable Integer id) throws NullPointerException {
        departureService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/departure/{id}", method = RequestMethod.GET)
    public String getDeparturePageWithHotels(@PathVariable Integer id, Model model) {
        Departure departure = departureService.findById(id);
        model.addAttribute("departure", departure);
        model.addAttribute("hotels", departureService.getAllHotelsForDeparture(departure));
        return "departurePage";
    }
}
