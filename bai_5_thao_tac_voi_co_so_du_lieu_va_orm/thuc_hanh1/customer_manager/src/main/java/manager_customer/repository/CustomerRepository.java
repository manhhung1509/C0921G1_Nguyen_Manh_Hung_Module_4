package manager_customer.repository;

import manager_customer.model.Customer;
import java.util.List;

public interface CustomerRepository extends Repository <Customer> {
    public List<Customer> searchByName(String name);

}
