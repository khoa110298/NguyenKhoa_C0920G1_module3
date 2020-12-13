package customer.repository;

import customer.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomers();
    void insertCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(int id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer selectCustomer(int id);
    List<Customer> searchByName(String name);
}
