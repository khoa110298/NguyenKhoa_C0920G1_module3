package employee.repository;

import customer.model.Customer;
import employee.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO " +
            "employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone," +
            "employee_email,employee_address,position_id,education_degree_id,division_id,user_name) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String SELECT_EMPLOYEE_BY_NAME = "select * from employee where employee_name like ?";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name = ?,employee_birthday= ?, employee_id_card = ?," +
            "employee_salary = ?,employee_phone = ?,employee_email= ?, employee_address = ?,position_id = ?, " +
            "education_degree_id = ?,division_id= ?, user_name = ? where employee_id = ?";
    private static final String SELECT_EMPLOYEE = "select * from employee where  employee_id = ?";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }





    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String employeeId = resultSet.getString("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                String employeeSalary = resultSet.getString("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_phone");
                String employeeAddress = resultSet.getString("employee_address");
                String positionId = resultSet.getString("position_id");
                String educationDegreeId = resultSet.getString("education_degree_id");
                String divisionId = resultSet.getString("division_id");
                String userName = resultSet.getString("user_name");
                employeeList.add(new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,
                        employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            statement.setString(1,employee.getEmployeeId());
            statement.setString(2,employee.getEmployeeName());
            statement.setString(3,employee.getEmployeeBirthday());
            statement.setString(4,employee.getEmployeeIdCard());
            statement.setString(5,employee.getEmployeeSalary());
            statement.setString(6,employee.getEmployeePhone());
            statement.setString(7,employee.getEmployeeEmail());
            statement.setString(8,employee.getEmployeeAddress());
            statement.setString(9,employee.getPositionId());
            statement.setString(10,employee.getEducationDegreeId());
            statement.setString(11,employee.getDivisionId());
            statement.setString(12,employee.getUserName());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        boolean check;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            statement.setString(1,id);
            check = statement.executeUpdate() > 0;
        }finally {
            getConnection().close();
        }
        return check;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean check;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            statement.setString(12,employee.getEmployeeId());
            statement.setString(1,employee.getEmployeeName());
            statement.setString(2,employee.getEmployeeBirthday());
            statement.setString(3,employee.getEmployeeIdCard());
            statement.setString(4,employee.getEmployeeSalary());
            statement.setString(5,employee.getEmployeePhone());
            statement.setString(6,employee.getEmployeeEmail());
            statement.setString(7,employee.getEmployeeAddress());
            statement.setString(8,employee.getPositionId());
            statement.setString(9,employee.getEducationDegreeId());
            statement.setString(10,employee.getDivisionId());
            statement.setString(11,employee.getUserName());
            check = statement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public Employee selectEmployee(String id) {
        Employee employee = null;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE)) {
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                String employeeSalary = resultSet.getString("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_phone");
                String employeeAddress = resultSet.getString("employee_address");
                String positionId = resultSet.getString("position_id");
                String educationDegreeId = resultSet.getString("education_degree_id");
                String divisionId = resultSet.getString("division_id");
                String userName = resultSet.getString("user_name");
                employee = new Employee(id,employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,
                        employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME)){
            statement.setString(1,"%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String employeeId = resultSet.getString("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                String employeeSalary = resultSet.getString("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_phone");
                String employeeAddress = resultSet.getString("employee_address");
                String positionId = resultSet.getString("position_id");
                String educationDegreeId = resultSet.getString("education_degree_id");
                String divisionId = resultSet.getString("division_id");
                String userName = resultSet.getString("user_name");
                employeeList.add(new Employee(employeeId,employeeName,employeeBirthday,employeeIdCard,employeeSalary,employeePhone,
                        employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
