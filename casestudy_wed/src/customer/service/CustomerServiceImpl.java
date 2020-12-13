package customer.service;

import customer.model.Customer;
import customer.repository.CustomerRepository;
import customer.repository.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {

    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }
}
