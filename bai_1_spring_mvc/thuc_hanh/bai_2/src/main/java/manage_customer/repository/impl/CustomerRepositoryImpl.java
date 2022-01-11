package manage_customer.repository.impl;

import manage_customer.model.Customer;
import manage_customer.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1,"Hung", "hung123@gmail.com", "Quang Binh"));
        customerList.add(new Customer(2,"Hoang", "hoang123@gmail.com", "Quang Nam"));
        customerList.add(new Customer(3,"Hien", "hien123@gmail.com", "Quang Ngai"));
        customerList.add(new Customer(4,"Ha", "ha123@gmail.com", "Quang Tri"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public List<Customer> findOne(int id) {
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerList) {
            if (id == customer.getId()){
                customers.add(customer);
            }
        }
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        for (Customer customer1: customerList ) {
            if (customer1.getId() == customer.getId()){
                customer1.setId(customer.getId());
                customer1.setName(customer.getName());
                customer1.setEmail(customer.getEmail());
                customer1.setAddress(customer.getAddress());
            }
        }
    }
}
