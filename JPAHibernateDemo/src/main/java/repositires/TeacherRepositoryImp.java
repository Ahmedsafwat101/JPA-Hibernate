package repositires;

import entities.School;
import entities.Teacher;

import javax.persistence.*;
import java.util.List;

public class TeacherRepositoryImp {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public TeacherRepositoryImp() {
        this.emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        this.entityManager = this.emf.createEntityManager();
    }

    public Teacher addTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        System.out.println(teacher);
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        return teacher;
    }


    public boolean deleteTeacher(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from Teacher where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }

    public Teacher update(Teacher teacher) {
        Teacher teacherToUpdate = find(teacher.getId());
        entityManager.getTransaction().begin();
        teacherToUpdate.setFirstName(teacher.getFirstName());
        teacherToUpdate.setLastName(teacher.getLastName());
        entityManager.getTransaction().commit();
        return teacherToUpdate;
    }

    public Teacher getTeacher(Long id){
        return find(id);
    }

    public List<Teacher> getAllTeachers(){
        String strQuery = "SELECT tut FROM Teacher tut WHERE tut.id IS NOT NULL";
        TypedQuery<Teacher> tq = entityManager.createQuery(strQuery, Teacher.class);
        return tq.getResultList();
    }

    public Teacher find(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public void tearDownEntityManagerFactory() {
        emf.close();

    }
}
