package Task3;

import entities.Employee;

import javax.persistence.*;

public abstract class ParentRepository<E,P> {
    private EntityManager entityManager;
    private EntityManagerFactory emf;
    protected Class<E> genericClass;

    protected ParentRepository(EntityManager entityManager, EntityManagerFactory emf, Class<E> genericClass) {
        this.emf = emf;
        this.entityManager = entityManager;
        this.genericClass = genericClass;
    }

    public E addEntity(E object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        return object;
    }

    public void removeEntity(E object) {
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }


    public void updateEntity(E object){
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    public E findById(P PrimaryKey) {
        return entityManager.find(this.getGenericClass() , PrimaryKey);
    }

    public Class<E> getGenericClass()
    {
        return genericClass;
    }



}


