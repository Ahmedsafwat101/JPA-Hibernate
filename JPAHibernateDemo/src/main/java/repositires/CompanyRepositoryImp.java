package repositires;

import entities.Company;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CompanyRepositoryImp {
    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public CompanyRepositoryImp() {
        this.emf = Persistence.createEntityManagerFactory("JPAHibernateDemo");
        this.entityManager = this.emf.createEntityManager();
    }

    public Company addCompany(Company company) {
        entityManager.getTransaction().begin();
        entityManager.persist(company);
        entityManager.getTransaction().commit();
        return company;
    }


    public Company updateCompany(Long id, Company company) {
        Company companyToUpdate = findById(id);
        entityManager.getTransaction().begin();

        companyToUpdate.setName(company.getName());
        companyToUpdate.setCity(company.getCity());

        entityManager.getTransaction().commit();
        return companyToUpdate;
    }

    public boolean deleteCompany(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from Company where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        return true;
    }

    public Company findById(Long id) {
        return entityManager.find(Company.class, id);
    }

    public void tearDownEntityManagerFactory() {
        emf.close();

    }
}
