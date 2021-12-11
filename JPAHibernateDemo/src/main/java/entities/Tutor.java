package entities;

import javax.persistence.*;

@Entity
@Table(name = "Tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 250)
    private String lastName;

    @OneToOne(mappedBy = "tutor")
    private Student student;

    public Tutor( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Tutor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", student=" + student +
                '}';
    }
}
