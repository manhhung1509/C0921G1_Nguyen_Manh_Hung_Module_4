package manage_customer.service;

import manage_customer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public List<Customer> findOne(int id);
    public void updateCustomer(Customer customer);
}
