package repositires;

import entities.Employee;
import org.junit.jupiter.api.*;

import java.util.List;

class EmployeeRepositoryTest  {
    private static EmployeeRepositoryImp repository;


    @BeforeEach
    void setUp() {
        repository = new EmployeeRepositoryImp();
    }

    @AfterEach
    void tearDown() {
        repository.tearDownEntityManagerFactory();
    }


    @Test
    void addEmployeeReturnTrue() {
        Employee addedEmployee = new Employee("Ahmed","Ahmed@gmail.com","123456",20d);
        Employee newEmployee = repository.addEmployee(addedEmployee);
        System.out.println(newEmployee.toString());
        Assertions.assertNotNull(newEmployee);
    }

    @Test
    void removeEmployeeReturnTrue() {
        Employee addedEmployee = new Employee("Ahmed","Ahmed@gmail.com","123456",20d);
        repository.addEmployee(addedEmployee);

        List<Employee> employees = repository.getAllEmployees();

        boolean result =  repository.deleteEmployee(employees.get(0).getId());
        Assertions.assertTrue(result);
    }


    @Test
    void updateEmployeeNameEqualsNewName() {
        Employee addedEmployee = new Employee("Ahmed","Ahmed@gmail.com","123456",20d);
        Employee newEmployee = repository.addEmployee(addedEmployee);

        repository.updateEmployeeName("Abbas",newEmployee.getId());

        Employee employeeAfterUpdate  = repository.getEmployee(newEmployee.getId());

        Assertions.assertEquals("Abbas",employeeAfterUpdate.getName());
    }


}