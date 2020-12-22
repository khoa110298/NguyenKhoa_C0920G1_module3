package employee.service;

import employee.model.Employee;
import employee.repository.EmployeeRepository;
import employee.repository.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public Employee selectEmployee(String id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName(name);
    }
}
