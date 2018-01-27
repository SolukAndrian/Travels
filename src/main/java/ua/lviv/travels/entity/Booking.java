package ua.lviv.travels.entity;

import javax.persistence.*;

/**
 * Created by Apple on 17.04.2017.
 */
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Customer idCustomer;
    @ManyToOne
    private Departure idDeparture;

    public Booking() {
    }

    public Booking(Customer idCustomer, Departure idDeparture) {
        this.idCustomer = idCustomer;
        this.idDeparture = idDeparture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Departure getIdDeparture() {
        return idDeparture;
    }

    public void setIdDeparture(Departure idDeparture) {
        this.idDeparture = idDeparture;
    }
}
