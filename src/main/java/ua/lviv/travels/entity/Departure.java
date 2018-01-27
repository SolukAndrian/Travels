package ua.lviv.travels.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Apple on 17.04.2017.
 */
@Entity
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String dateDeparture;
    @Column
    private String typeTrip;
    @Column
    private Double price;

    @ManyToOne
    private TourDescription tourDescription;

    @OneToMany(mappedBy = "departure", cascade = CascadeType.REMOVE)
    private List<HotelAccommodation> hotelAccommodationList2;

    @OneToMany(mappedBy = "idDeparture", cascade = CascadeType.REMOVE)
    private List<Booking> bookingList;

    public Departure() {
    }

    public Departure(String dateDeparture, String typeTrip, double price) {
        this.dateDeparture = dateDeparture;
        this.typeTrip = typeTrip;
        this.price = price;
    }

    public Departure(String dateDeparture, String typeTrip, double price, TourDescription tourDescription) {
        this.dateDeparture = dateDeparture;
        this.typeTrip = typeTrip;
        this.price = price;
        this.tourDescription = tourDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public TourDescription getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(TourDescription tourDescription) {
        this.tourDescription = tourDescription;
    }

    public List<HotelAccommodation> getHotelAccommodationList2() {
        return hotelAccommodationList2;
    }

    public void setHotelAccommodationList2(List<HotelAccommodation> hotelAccommodationList2) {
        this.hotelAccommodationList2 = hotelAccommodationList2;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public String getTypeTrip() {
        return typeTrip;
    }

    public void setTypeTrip(String typeTrip) {
        this.typeTrip = typeTrip;
    }
}
