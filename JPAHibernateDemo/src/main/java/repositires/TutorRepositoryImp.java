package repositires;

import entities.Student;
import entities.Tutor;
import javax.persistence.*;
import java.util.List;

public class TutorRepositoryImp {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public TutorRepositoryImp() {
        this.emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        this.entityManager = this.emf.createEntityManager();
    }

    public Tutor addTutor(Tutor tutor) {
        entityManager.getTransaction().begin();
        System.out.println(tutor);
        entityManager.persist(tutor);
        entityManager.getTransaction().commit();
        return tutor;
    }


   /* public void addStudent(Long id, Student student){
        entityManager.getTransaction().begin();
        Tutor tutor = findById(id);
        if(tutor!=null){
            tutor.setStudent(student);
        }
        entityManager.persist(tutor);
        entityManager.getTransaction().commit();
    }*/


    public boolean deleteTutor(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from Tutor where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }



    public Tutor updateTutorName(String fName,String lName, Long id) {
        Tutor tutorToUpdate = findById(id);
        entityManager.getTransaction().begin();

        tutorToUpdate.setFirstName(fName);
        tutorToUpdate.setLastName(lName);

        entityManager.getTransaction().commit();
        entityManager.clear();
        return findById(id);
    }

    public Tutor getTutor(Long id){
        return findById(id);
    }


    public List<Tutor> getAllTutors(){
        String strQuery = "SELECT tut FROM Tutor tut WHERE tut.id IS NOT NULL";
        TypedQuery<Tutor> tq = entityManager.createQuery(strQuery, Tutor.class);
        return tq.getResultList();
    }

    public Tutor findById(Long id) {
        return entityManager.find(Tutor.class, id);
    }

    public void tearDownEntityManagerFactory() {
        emf.close();

    }
}
