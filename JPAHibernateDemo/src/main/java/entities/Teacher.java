package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false,length = 150)
    private String firstName;
    @Column(name = "last_name", nullable = false,length = 150)
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private School school;


    @ManyToMany(targetEntity = Student.class)
    private Set<Student> students = new HashSet<>();



    public Teacher( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher() {
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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

    public void addStudent(Student student) {
        boolean added = students.add(student);
        if(added) {
            student.getTeachers().add(this);
        }
    }

    public void removeStudent(Student student) {
        boolean removed = students.remove(student);
        if(removed) {
            student.getTeachers().remove(this);
        }
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {

        this.students = students;
    }


}
