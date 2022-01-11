package manage_customer.repository;

import manage_customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> findAll();
    public List<Customer> findOne(int id);
    public void updateCustomer(Customer customer);
}
