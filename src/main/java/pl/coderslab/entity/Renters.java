package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "renters")
public class Renters {
    @Id
    private Long id;
    @Size(max = 30)
    private String firstName;
    @Size(max = 40)
    private String lastName;
    @Size(max = 15)
    private String phoneNumber;
    @OneToMany()
    @JoinColumn(name = "rent_id")
    private List<Rents> rentsList = new ArrayList<>();



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Rents> getRentsList() {
        return rentsList;
    }

    public void setRentsList(List<Rents> rentsList) {
        this.rentsList = rentsList;
    }

    public Renters(String firstName, String lastName, String phoneNumber, List<Rents> rentsList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.rentsList = rentsList;
    }

    public Renters() {
    }
}
