package ua.lviv.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.travels.dto.CustomerDto;
import ua.lviv.travels.entity.Customer;
import ua.lviv.travels.entity.Departure;
import ua.lviv.travels.service.CustomerService;
import ua.lviv.travels.service.DepartureService;
import ua.lviv.travels.service.HotelAccommodationService;

import java.util.List;

/**
 * Created by Apple on 17.04.2017.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private DepartureService departureService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePageWithAllDepartures(Model model) {
        model.addAttribute("dep", departureService.findAll());
        return "home";
    }

    @RequestMapping(value = "/searchByNameDeparture", method = RequestMethod.POST)
    public String searchByNameDeparture(@RequestParam("inputSearch") String inputSearch, Model model) {
        System.out.println(departureService.findAllDeparturesByName(inputSearch));
        model.addAttribute("departures", departureService.findAllDeparturesByName(inputSearch));
        return "searchByNameDeparture";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registration(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getSurname(), customerDto.getName(),
                customerDto.getAge(), customerDto.getEmail(), customerDto.getLogin(),
                customerDto.getPhone(), customerDto.getPassword());
        customerService.add(customer);
    }

    @RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }
}
