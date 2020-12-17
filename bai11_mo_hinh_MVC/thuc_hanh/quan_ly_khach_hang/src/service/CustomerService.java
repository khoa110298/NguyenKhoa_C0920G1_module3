package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    void createCustomer(Customer customer);
    Customer findById(int id);
    void update(int id,Customer customer);
    void delete(int id);
}
