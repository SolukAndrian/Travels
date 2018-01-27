package ua.lviv.travels.entity;

import javax.persistence.*;

/**
 * Created by Apple on 17.04.2017.
 */
@Entity
public class HotelAccommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String dateEntry;
    @Column
    private String dateDeparture;
    @Column
    private Integer quantityReservedNumbers;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne(fetch = FetchType.EAGER)
    private Departure departure;

    public HotelAccommodation() {
    }

    public HotelAccommodation(Departure departure) {
        this.departure = departure;
    }

    public HotelAccommodation(String dateEntry, String dateDeparture, Integer quantityReservedNumbers) {
        this.dateEntry = dateEntry;
        this.dateDeparture = dateDeparture;
        this.quantityReservedNumbers = quantityReservedNumbers;
    }

    public HotelAccommodation(String dateEntry, String dateDeparture, Integer quantityReservedNumbers, Departure departure) {
        this.dateEntry = dateEntry;
        this.dateDeparture = dateDeparture;
        this.quantityReservedNumbers = quantityReservedNumbers;
        this.departure = departure;
    }

    public HotelAccommodation(String dateEntry, String dateDeparture, Integer quantityReservedNumbers, Hotel hotel, Departure departure) {
        this.dateEntry = dateEntry;
        this.dateDeparture = dateDeparture;
        this.quantityReservedNumbers = quantityReservedNumbers;
        this.hotel = hotel;
        this.departure = departure;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityReservedNumbers() {
        return quantityReservedNumbers;
    }

    public void setQuantityReservedNumbers(Integer quantityReservedNumbers) {
        this.quantityReservedNumbers = quantityReservedNumbers;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }
}
