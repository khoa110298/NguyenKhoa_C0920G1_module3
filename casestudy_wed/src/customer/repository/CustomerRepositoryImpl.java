package customer.repository;

import customer.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO " +
            "customer(customer_id,customer_type_id, customer_name, customer_birthday,customer_gender," +
            "customer_id_card,customer_phone,customer_email,customer_address) " +
            "VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?,customer_name= ?, customer_birthday = ?," +
            "customer_gender = ?,customer_id_card = ?,customer_phone= ?, customer_email = ?,customer_address = ? where customer_id = ?";
    private static final String SELECT_CUSTOMER = "select * from customer where  customer_id = ?";


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
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                int type_id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                String gender = resultSet.getString("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id,type_id,name,birthday,gender,idCard,phone,email,address));
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
        return customerList;
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
