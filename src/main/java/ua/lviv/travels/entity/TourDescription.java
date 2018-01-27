package ua.lviv.travels.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Apple on 17.04.2017.
 */
@Entity
public class TourDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String countries;
    @Column(nullable = false)
    private String cities;
    @Column(nullable = false)
    private Integer days;
    @Column(nullable = false)
    private String vehicle;
    @Lob()
    private byte [] image;

    @OneToMany(mappedBy = "tourDescription", cascade = CascadeType.REMOVE)
    private List<Departure> departureList;

    public TourDescription() {
    }

    public TourDescription(String name, String countries, String cities, int days, String vehicle, byte[] image) {
        this.name = name;
        this.countries = countries;
        this.cities = cities;
        this.days = days;
        this.vehicle = vehicle;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Departure> getDepartureList() {
        return departureList;
    }

    public void setDepartureList(List<Departure> departureList) {
        this.departureList = departureList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
