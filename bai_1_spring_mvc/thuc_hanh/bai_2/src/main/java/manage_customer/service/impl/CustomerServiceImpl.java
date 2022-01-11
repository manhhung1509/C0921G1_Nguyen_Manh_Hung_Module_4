package manage_customer.service.impl;

import manage_customer.model.Customer;
import manage_customer.repository.CustomerRepository;
import manage_customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findOne(int id) {
        List<Customer> customers = customerRepository.findOne(id);
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }
}
