package customer.service;

import customer.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService  {
    List<Customer> getAllCustomers();
    void insertCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer selectCustomer(String id);
    List<Customer> searchByName(String name);
}
