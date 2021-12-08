import entities.Employee;

import javax.persistence.*;
import java.util.List;

public class App {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("JPAHibernateDemo");

    public static void main(String[] args) {

        addEmployee("Sue", "Sue@gmail.com","1234568",2500d);
        addEmployee("Ahmed", "Ahmed@gmail.com","1234568",2500d);
        addEmployee("Ali", "Ali@gmail.com","1234568",2500d);
        addEmployee("Zizo", "Zizo@gmail.com","1234568",2500d);
        getEmployees();
        deleteEmployee(3L);
        getEmployee(1L);
        updateEmployeeName(2L,"Abbas");

        ENTITY_MANAGER_FACTORY.close();
    }

    public static void addEmployee(String emp_name, String emp_email,String emp_phone,Double emp_salary) {
        // The EntityManager class allows operations such as create, read, update, delete
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        // Used to issue transactions on the EntityManager
        EntityTransaction et = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Create and set values for new customer
            Employee emp = new Employee();
            emp.setName(emp_name);
            emp.setEmail(emp_email);
            emp.setSalary(emp_salary);
            emp.setPhone(emp_phone);
            // Save the customer object
            em.persist(emp);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

    public static void getEmployee(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        // the lowercase c refers to the object
        String query = "SELECT emp FROM Employee emp WHERE emp.id = :emp_id";

        // Issue the query and get a matching Customer
        TypedQuery<Employee> tq = em.createQuery(query, Employee.class);
        tq.setParameter("emp_id", id);

        Employee emp = null;
        try {
            // Get matching customer object and output
            emp = tq.getSingleResult();
            System.out.println(emp.toString());
        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void getEmployees() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        // the lowercase c refers to the object
        String strQuery = "SELECT emp FROM Employee emp WHERE emp.id IS NOT NULL";

        // Issue the query and get a matching Customer
        TypedQuery<Employee> tq = em.createQuery(strQuery, Employee.class);
        List<Employee> emps;
        try {
            // Get matching customer object and output
            emps = tq.getResultList();
            emps.forEach(it -> System.out.println(it.toString()));

        } catch (NoResultException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void updateEmployeeName(Long id, String name) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        Employee emp = null;

        try {
            // Get transaction and start
            et = em.getTransaction();
            et.begin();

            // Find customer and make changes
            emp = em.find(Employee.class, id);
            emp.setName(name);

            // Save the customer object
            em.persist(emp);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

    public static void deleteEmployee(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Employee emp = null;

        try {
            et = em.getTransaction();
            et.begin();
            emp = em.find(Employee.class, id);
            em.remove(emp);
            et.commit();
        } catch (Exception ex) {
            // If there is an exception rollback changes
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }
}
