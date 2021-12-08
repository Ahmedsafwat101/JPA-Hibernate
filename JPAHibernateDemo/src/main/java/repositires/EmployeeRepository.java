package repositires;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeRepository {
    private EntityManager entityManager;
    private EntityManagerFactory emf;


    /*public EmployeeRepository() {
        this.emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        this.entityManager = this.emf.createEntityManager();
    }

    public Employee add(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    public Employee find(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee updateNameById(String name, Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Update Employee set emp_name = '"+ name + "' where id = " + id );
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.clear();
        return findById(id);
    }


    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from Employee where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public Employee update(Employee student) {
        Employee studentToUpdate = find(student.getId());
        entityManager.getTransaction().begin();
        studentToUpdate.setName(student.getName());
        entityManager.getTransaction().commit();
        return studentToUpdate;
    }*/

}

