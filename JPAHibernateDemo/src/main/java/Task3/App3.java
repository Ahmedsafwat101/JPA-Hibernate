package Task3;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        EntityManager entityManager = emf.createEntityManager();
        BaseRepository baseRepository = new BaseRepository(entityManager, emf, Employee.class);

        //ADD
        Employee employee1 = baseRepository.addEntity(new Employee("Ahmed", "Ahmed@gmail.com", "123456789", 2500d));
        Employee employee2 = baseRepository.addEntity(new Employee("Abbas", "Abbas@gmail.com", "123456789", 2500d));
        Employee employee3 = baseRepository.addEntity(new Employee("zizo", "zizo@gmail.com", "123456789", 2500d));
        Employee employee4 = baseRepository.addEntity(new Employee("Aya", "Aya@gmail.com", "123456789", 2500d));

        //Remove
        baseRepository.removeEntity(employee1);

        //Get
        Employee employee = baseRepository.findById(2L);
        System.out.println(employee.toString());

        //Update
        employee3.setName("khaled");
        baseRepository.updateEntity(employee3);
    }
}
