package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "renters")
public class Renters {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
    @Size(max = 30,message = "Imie moze miec maksymalnie 30 znakow")
    private String first_name;
    @Size(max = 40,message = "Nazwisko moze miec maksymalnie 40 znakow")
    private String last_name;
    @Size(max = 15,message = "Numer telefonu nie moze przekraczac 15 znakow")
    private String phone_number;
    @OneToMany()
    @JoinColumn(name = "rent_id")
    private List<Rents> rentsList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public List<Rents> getRentsList() {
        return rentsList;
    }

    public void setRentsList(List<Rents> rentsList) {
        this.rentsList = rentsList;
    }

    public Renters(String first_name, String last_name, String phone_number, List<Rents> rentsList) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.rentsList = rentsList;
    }

    public Renters() {
    }
}
