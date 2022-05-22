package pl.coderslab.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "banners")
public class Banners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
    @Size(max = 40)
    private String street;
    private int price;
    private boolean is_rented;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public boolean getIs_rented() {
        return is_rented;
    }

    public void setIs_rented(boolean is_rented) {
        this.is_rented = is_rented;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Rents getRents() {
        return rents;
    }

    public void setRents(Rents rents) {
        this.rents = rents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "rent_id")
    private Rents rents;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




    public Banners() {
    }

    public Banners(String street, int price, boolean isRented, Admin admin, Rents rents) {
        this.street = street;
        this.price = price;
        this.is_rented = is_rented;
        this.admin = admin;
        this.rents = rents;
    }
}
