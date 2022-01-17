package manager_customer.service;

import manager_customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer finById(Long id);

    void save(Customer customer);

    void remove(Long id);

    public List<Customer> searchByName(String name);
}
