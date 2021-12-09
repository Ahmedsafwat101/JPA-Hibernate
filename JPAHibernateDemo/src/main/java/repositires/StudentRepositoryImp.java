package repositires;

import entities.Employee;
import entities.Student;
import entities.Tutor;

import javax.persistence.*;
import java.util.List;

public class StudentRepositoryImp {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public StudentRepositoryImp() {
        this.emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        this.entityManager = this.emf.createEntityManager();
    }

    public Student addStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

    public Student addTutor(Long id, Tutor tutor){
        entityManager.getTransaction().begin();
        Student student = findById(id);
        student.setTutor(tutor);
        entityManager.getTransaction().commit();
        return student;
    }

    public boolean deleteStudent(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from Student where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }

    /*public Student updateEmployee(Long id,Employee emp) {
        Employee studentToUpdate = findById(id);
        entityManager.getTransaction().begin();

        studentToUpdate.setName(emp.getName());
        studentToUpdate.setPhone(emp.getPhone());
        studentToUpdate.setSalary(emp.getSalary());
        studentToUpdate.setEmail(emp.getEmail());

        entityManager.getTransaction().commit();
        return studentToUpdate;
    }*/

    public Student updateStudentName(String fName,String lName, Long id) {
        Student studentToUpdate = findById(id);
        entityManager.getTransaction().begin();

        studentToUpdate.setFirstName(fName);
        studentToUpdate.setLastName(lName);

        entityManager.getTransaction().commit();
        entityManager.clear();
        return findById(id);
    }

    public Student getStudent(Long id){
        return findById(id);
    }


    public List<Student> getAllStudent(){
        String strQuery = "SELECT std FROM Student std WHERE std.id IS NOT NULL";
        TypedQuery<Student> tq = entityManager.createQuery(strQuery, Student.class);
        return tq.getResultList();
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void tearDownEntityManagerFactory() {
        emf.close();

    }
}
