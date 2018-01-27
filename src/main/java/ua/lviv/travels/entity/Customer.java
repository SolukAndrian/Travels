package ua.lviv.travels.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Apple on 17.04.2017.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String surname;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private String email;
    @Column
    private String login;
    @Column
    private String phone;
    @Column
    private String password;

    @OneToMany(mappedBy = "idCustomer")
    private List<Booking> bookingList;

    public Customer() {
    }

    public Customer(String surname, String name, Integer age, String email, String login, String phone, String password) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.email = email;
        this.login = login;
        this.phone = phone;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
