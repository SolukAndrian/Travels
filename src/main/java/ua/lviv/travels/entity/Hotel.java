package ua.lviv.travels.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Apple on 17.04.2017.
 */
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nameHotel;
    @Column(length = 5)
    private Integer stars;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private String address;
    @Lob()
    private byte [] image;

    @OneToMany(mappedBy = "hotel")
    private List<HotelAccommodation> hotelAccommodationList;

    public Hotel() {
    }

    public Hotel(String nameHotel, Integer stars, String country, String city, String address, byte[] image) {
        this.nameHotel = nameHotel;
        this.stars = stars;
        this.country = country;
        this.city = city;
        this.address = address;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<HotelAccommodation> getHotelAccommodationList() {
        return hotelAccommodationList;
    }

    public void setHotelAccommodationList(List<HotelAccommodation> hotelAccommodationList) {
        this.hotelAccommodationList = hotelAccommodationList;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
