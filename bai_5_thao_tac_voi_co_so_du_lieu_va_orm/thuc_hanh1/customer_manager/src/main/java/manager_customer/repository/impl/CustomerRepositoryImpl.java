package manager_customer.repository.impl;

import manager_customer.model.Customer;
import manager_customer.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c ", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer finById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
         Customer customer = finById(id);
         if (customer != null){
             entityManager.remove(customer);
         }
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList;
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.name LIKE CONCAT('%',:name,'%')", Customer.class);
        query.setParameter("name", name);
        try {
            customerList = query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
        return customerList;
    }
}
