package customer.repository;

import customer.model.CustomerType;
import customer.repository.CustomerTypeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    private static final String SELECT_ALL_CUSTOMERTYPE = "select * from customer_type";

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
    public List<CustomerType> getAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERTYPE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }
}
