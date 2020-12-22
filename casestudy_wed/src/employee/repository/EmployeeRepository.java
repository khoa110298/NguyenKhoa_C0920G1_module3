package employee.repository;

import customer.model.Customer;
import employee.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    void insertEmployee(Employee employee) throws SQLException;
    boolean deleteEmployee(String id) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    Employee selectEmployee(String id);
    List<Employee> searchByName(String name);
}
