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
                String id = "KH-" + resultSet.getString("customer_id");
                String typeId = resultSet.getString("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                String gender = resultSet.getString("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customerList.add(new Customer(id,typeId,name,birthday,gender,idCard,phone,email,address));
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
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            statement.setInt(1,Integer.parseInt(customer.getCustomerId().substring(3)));
            statement.setInt(2,Integer.parseInt(customer.getCustomerTypeId()));
            statement.setString(3,customer.getCustomerName());
            statement.setString(4,customer.getCustomerBirthday());
            statement.setInt(5,Integer.parseInt(customer.getCustomerGender()));
            statement.setString(6,customer.getCustomerIdCard());
            statement.setString(7,customer.getCustomerPhone());
            statement.setString(8,customer.getCustomerEmail());
            statement.setString(9,customer.getCustomerAddress());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        boolean check;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL)) {
            statement.setInt(1,Integer.parseInt(id));
            check = statement.executeUpdate() > 0;
        }finally {
            getConnection().close();
        }
        return check;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean check;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            statement.setInt(1,Integer.parseInt(customer.getCustomerTypeId()));
            statement.setString(2,customer.getCustomerName());
            statement.setString(3,customer.getCustomerBirthday());
            statement.setInt(4,Integer.parseInt(customer.getCustomerGender()));
            statement.setString(5,customer.getCustomerIdCard());
            statement.setString(6,customer.getCustomerPhone());
            statement.setString(7,customer.getCustomerEmail());
            statement.setString(8,customer.getCustomerAddress());
            statement.setInt(9,Integer.parseInt(customer.getCustomerId().substring(3)));
            check = statement.executeUpdate() > 0;
        }
        return check;
    }

    @Override
    public Customer selectCustomer(String id) {
        Customer customer = null;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER)) {
            statement.setInt(1,Integer.parseInt(id.substring(3)));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String typeID = resultSet.getString("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_bi)rthday");
                String gender = resultSet.getString("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id,typeID,name,birthday,gender,idCard,phone,email,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
       try (Connection connection = getConnection();
       PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME)){
           statement.setString(1,"%"+name+"%");
           ResultSet resultSet = statement.executeQuery();
           while (resultSet.next()){
               String id = "KH-" + resultSet.getString("customer_id");
               String typeId = resultSet.getString("customer_type_id");
               String name1 = resultSet.getString("customer_name");
               String birthday = resultSet.getString("customer_birthday");
               String gender = resultSet.getString("customer_gender");
               String idCard = resultSet.getString("customer_id_card");
               String phone = resultSet.getString("customer_phone");
               String email = resultSet.getString("customer_email");
               String address = resultSet.getString("customer_address");
               customerList.add(new Customer(id,typeId,name1,birthday,gender,idCard,phone,email,address));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return customerList;
    }
}
