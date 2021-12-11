package repositires;


import entities.School;
import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchoolRepositoryImp {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public SchoolRepositoryImp() {
        this.emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        this.entityManager = this.emf.createEntityManager();
    }

    public SchoolRepositoryImp(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public School add(School school) {
        entityManager.getTransaction().begin();
        entityManager.persist(school);
        entityManager.getTransaction().commit();
        return school;
    }

    public School find(Long id) {
        return entityManager.find(School.class, id);
    }

    public School update(School school) {
        School schoolToUpdate = find(school.getId());
        entityManager.getTransaction().begin();
        schoolToUpdate.setCity(school.getCity());
        schoolToUpdate.setName(school.getName());
        entityManager.getTransaction().commit();
        return schoolToUpdate;
    }

    public void delete(School school) {
        entityManager.getTransaction().begin();
        entityManager.remove(school);
        entityManager.getTransaction().commit();
    }

    public void addStudent(Long id, Student student){
        entityManager.getTransaction().begin();
        School school = find(id);
        if(school!=null){
            school.getStudents().add(student);
        }
        entityManager.persist(school);
        entityManager.getTransaction().commit();

    }

    public void removeStudent(Long id, Student student){
        entityManager.getTransaction().begin();
        School school = find(id);
        if(school!=null){
            school.getStudents().remove(student);
        }
        entityManager.persist(school);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
