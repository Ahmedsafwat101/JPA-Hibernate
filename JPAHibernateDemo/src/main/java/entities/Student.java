package entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false,length = 150)
    private String firstName;
    @Column(name = "last_name", nullable = false,length = 150)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "tutor_id",unique = true)
    private Tutor tutor;
    //Modification --> list
    @ManyToMany(targetEntity = Teacher.class)
    private Set<Teacher> teachers = new HashSet<>();



    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }


    public Student(String firstName, String lastName, Tutor tutor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tutor = tutor;
    }

    public Student() {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void addTeacher(Teacher teacher) {
        boolean added = teachers.add(teacher);
        if (added) {
            teacher.getStudents().add(this);
        }
    }

    public void removeTeacher(Teacher teacher) {
        boolean remove = teachers.remove(teacher);
        if (remove) {
            teacher.getStudents().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tutor=" + tutor +
                ", teachers=" + teachers +
                '}';
    }
}
