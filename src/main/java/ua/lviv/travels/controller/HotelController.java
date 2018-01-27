package ua.lviv.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.travels.entity.Departure;
import ua.lviv.travels.entity.Hotel;
import ua.lviv.travels.entity.HotelAccommodation;
import ua.lviv.travels.service.DepartureService;
import ua.lviv.travels.service.HotelAccommodationService;
import ua.lviv.travels.service.HotelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Apple on 18.04.2017.
 */
@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private DepartureService departureService;

    @Autowired
    private HotelAccommodationService hotelAccommodationService;

    @RequestMapping(value = "/hotelAdd", method = RequestMethod.GET)
    public String getHotelAddingPage() {
        return "hotel";
    }

    @RequestMapping(value = "/hotelAdd", method = RequestMethod.POST)
    public String addHotel(@RequestParam(value = "hotelName") String hotelName, @RequestParam(value = "stars") Integer stars,
                           @RequestParam(value = "country") String country, @RequestParam(value = "city") String city,
                           @RequestParam(value = "address") String address, @RequestParam(value = "image") MultipartFile image) throws IOException {
        hotelService.add(new Hotel(hotelName, stars, country, city, address, image.getBytes()));
        return "redirect:/";
    }

    @RequestMapping(value = "/imageDisplay2", method = RequestMethod.GET)
    public void showImage(@RequestParam(value = "id") Integer id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        Hotel hotel = hotelService.findById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(hotel.getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/hotelAccommodation", method = RequestMethod.GET)
    public String getHotelAccommodationPage(Model model) {
        model.addAttribute("hotels", hotelService.findAll());
        model.addAttribute("departures", departureService.findAll());
        return "hotelAccommodation";
    }

    @RequestMapping(value = "/hotelAccommodation", method = RequestMethod.POST)
    public String addHotelAccommodation(@RequestParam(value = "dateEntry") String dateEntry,
                                        @RequestParam(value = "dateDeparture") String dateDeparture,
                                        @RequestParam(value = "quantityReservedNumbers") Integer quantityReservedNumbers,
                                        @RequestParam(value = "idHotel") Integer idHotel,
                                        @RequestParam(value = "idDeparture") Integer idDeparture) {
        HotelAccommodation hotelAccommodation = new HotelAccommodation(dateEntry, dateDeparture, quantityReservedNumbers,
                hotelService.findById(idHotel), departureService.findById(idDeparture));
        hotelAccommodationService.add(hotelAccommodation);
        return "redirect:/";
    }

}
