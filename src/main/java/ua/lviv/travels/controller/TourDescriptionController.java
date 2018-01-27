package ua.lviv.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.travels.entity.TourDescription;
import ua.lviv.travels.service.TourDescriptionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Apple on 18.04.2017.
 */
@Controller
public class TourDescriptionController {
    @Autowired
    private TourDescriptionService tourDescriptionService;

    @RequestMapping(value = "/tourDescription", method = RequestMethod.GET)
    public String getTourDescriptionPage() {
        return "tourDescription";
    }

    @RequestMapping(value = "/tourDescription", method = RequestMethod.POST)
    public String addTourDescription(@RequestParam(value = "tourName") String name, @RequestParam(value = "countries") String countries,
                                     @RequestParam(value = "cities") String cities, @RequestParam(value = "days") int days,
                                     @RequestParam(value = "vehicle") String vehicle, @RequestParam(value = "image") MultipartFile image) throws IOException {
        TourDescription tourDescription = new TourDescription(name, countries, cities, days, vehicle, image.getBytes());
        tourDescriptionService.add(tourDescription);
        return "redirect:/";
    }

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam(value = "id") Integer id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        TourDescription tourDescription = tourDescriptionService.findById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(tourDescription.getImage());
        response.getOutputStream().close();
    }
}
