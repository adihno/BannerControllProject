package pl.coderslab.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rents")
public class Rents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
    @NotNull(message = "Pole nie moze byc puste")
    private String Rented_until;
    @NotNull(message = "Pole nie moze byc puste")
    private String Rented_from;
    @Min(value = 0,message = "Cena nie moze byc pusta")
    private int price;
    @OneToOne
    @JoinColumn(name = "banner_id")
    private Banners banner;
    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Renters renter;


    public Banners getBanner() {
        return banner;
    }

    public void setBanner(Banners banner) {
        this.banner = banner;
    }

    public Renters getRenter() {
        return renter;
    }

    public void setRenter(Renters renter) {
        this.renter = renter;
    }

    public Rents(String Rented_until, String Rented_from, int price, Banners banner, Renters renter) {
        this.Rented_until = Rented_until;
        this.Rented_from = Rented_from;
        this.price = price;
        this.banner = banner;
        this.renter = renter;
    }

    public Long getId() {
        return id;
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
