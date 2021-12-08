package repositires;

import entities.Employee;

import javax.persistence.*;
import java.util.List;

public class  EmployeeRepositoryImp  {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public EmployeeRepositoryImp() {
        this.emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        this.entityManager = this.emf.createEntityManager();
    }

    public Employee addEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    public boolean deleteEmployee(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from Employee where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }

    public Employee updateEmployee(Long id, Employee emp) {
        Employee studentToUpdate = findById(id);
        entityManager.getTransaction().begin();

        studentToUpdate.setName(emp.getName());
        studentToUpdate.setPhone(emp.getName());
        studentToUpdate.setSalary(emp.getSalary());
        studentToUpdate.setEmail(emp.getEmail());

        entityManager.getTransaction().commit();
        return studentToUpdate;
    }

    public Employee updateEmployeeName(String name, Long id) {
        Employee studentToUpdate = findById(id);
        entityManager.getTransaction().begin();

        studentToUpdate.setName(name);

        entityManager.getTransaction().commit();
        entityManager.clear();
        return findById(id);
    }

    public Employee getEmployee(Long id){
        return findById(id);
    }


    public List<Employee> getAllEmployees(){

        String strQuery = "SELECT emp FROM Employee emp WHERE emp.id IS NOT NULL";
        TypedQuery<Employee> tq = entityManager.createQuery(strQuery, Employee.class);
        return tq.getResultList();
    }

     public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public void tearDownEntityManagerFactory() {
        emf.close();

    }
}

