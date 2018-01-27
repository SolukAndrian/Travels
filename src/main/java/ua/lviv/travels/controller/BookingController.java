package ua.lviv.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.travels.entity.Booking;
import ua.lviv.travels.entity.Customer;
import ua.lviv.travels.entity.Departure;
import ua.lviv.travels.entity.HotelAccommodation;
import ua.lviv.travels.service.BookingService;
import ua.lviv.travels.service.CustomerService;
import ua.lviv.travels.service.DepartureService;
import ua.lviv.travels.service.HotelAccommodationService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 24.04.2017.
 */
@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DepartureService departureService;

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET)
    public String getConfirmPageWithHotelsAndDepartures(@PathVariable Integer id, Principal principal, Model model) {
        Customer customer = customerService.findByLogin(principal.getName());
        model.addAttribute("user", customer);
        Departure departure = departureService.findById(id);
        model.addAttribute("departure", departure);
        model.addAttribute("hotels", departureService.getAllHotelsForDeparture(departure));
        return "confirmBooking";
    }

    @RequestMapping(value = "confirmBooking", method = RequestMethod.POST)
    public String bookingDepartureTrip(@RequestParam(value = "departureId") Integer departureId, @RequestParam(value = "login") String login) {
        Customer customer = customerService.findByLogin(login);
        Departure departure = departureService.findById(departureId);
        bookingService.add(new Booking(customer, departure));
        return "redirect:/gratitude";
    }

    @RequestMapping(value = "/gratitude", method = RequestMethod.GET)
    public String getFinishPage() {
        return "gratitude";
    }
}
