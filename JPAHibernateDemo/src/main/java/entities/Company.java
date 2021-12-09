package entities;

import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comp_id", nullable = false)
    private Long id;
    @Column(name = "comp_name",nullable = false)
    private String name;
    @Column(name = "comp_city",nullable = false)
    private String city;

    public Company(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Company() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
