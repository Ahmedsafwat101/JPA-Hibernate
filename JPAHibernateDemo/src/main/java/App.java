import entities.Employee;
import repositires.EmployeeRepositoryImp;

public class App {
    // private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("JPAHibernateDemo");

    public static void main(String[] args) {

        EmployeeRepositoryImp employeeRepository =  new EmployeeRepositoryImp();

        employeeRepository.addEmployee(new Employee("Sue", "Sue@gmail.com","1234568",2500d));
        employeeRepository.addEmployee(new Employee("Ahmed", "Ahmed@gmail.com","1234568",2500d));
        employeeRepository.addEmployee(new Employee("Ali", "Ali@gmail.com","1234568",2500d));
        employeeRepository.addEmployee(new Employee("Zizo", "Zizo@gmail.com","1234568",2500d));

        employeeRepository.getAllEmployees().forEach(it-> System.out.println(it.toString()));

        System.out.println(employeeRepository.getEmployee(1L));

        employeeRepository.deleteEmployee(1L);
        employeeRepository.getAllEmployees().forEach(it-> System.out.println(it.toString()));

        employeeRepository.updateEmployeeName("Abbas",2L);
        System.out.println(employeeRepository.getEmployee(2L));


        employeeRepository.updateEmployee(3L,new Employee("Maged","Maged@gmail.com","1234578",2000d));
        System.out.println(employeeRepository.getEmployee(3L));


        employeeRepository.tearDownEntityManagerFactory();



    }
}
