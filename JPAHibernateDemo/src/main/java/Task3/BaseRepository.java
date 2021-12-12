package Task3;

import Task3.ParentRepository;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BaseRepository extends ParentRepository<Employee,Long> {

    protected BaseRepository(EntityManager entityManager, EntityManagerFactory emf, Class<Employee> genericClass) {
        super(entityManager, emf, genericClass);
    }

    @Override
    public Employee addEntity(Employee object) {
        return super.addEntity(object);
    }

    @Override
    public void removeEntity(Employee object) {
        super.removeEntity(object);
    }

    @Override
    public void updateEntity(Employee object) {
        super.updateEntity(object);
    }

    @Override
    public Employee findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Class<Employee> getGenericClass() {
        return super.getGenericClass();
    }
}
