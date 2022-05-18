package pl.coderslab.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rents")
public class Rents {
    @Id
    private int id;
    private String Rented_until;
    private String Rented_from;
    private int price;
    @OneToOne
    @JoinColumn(name = "banner_id")
    private Banners banner;
    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Renters renter;

    public Rents(String Rented_until, String Rented_from, int price, Banners banner, Renters renter) {
        this.Rented_until = Rented_until;
        this.Rented_from = Rented_from;
        this.price = price;
        this.banner = banner;
        this.renter = renter;
    }

    public String getRented_until() {
        return Rented_until;
    }

    public void setRented_until(String rented_until) {
        this.Rented_until = rented_until;
    }

    public String getRented_from() {
        return Rented_from;
    }

    public void setRented_from(String rented_from) {
        this.Rented_from = rented_from;
    }







    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Rents() {
    }
}
