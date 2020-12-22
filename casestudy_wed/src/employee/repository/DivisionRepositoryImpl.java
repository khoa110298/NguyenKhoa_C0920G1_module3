package employee.repository;

import customer.model.CustomerType;
import employee.model.Division;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements DivisionRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String SELECT_ALL_DIVISION = "select * from division";


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
    public List<Division> getAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DIVISION)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("division_id");
                String name = resultSet.getString("division_name");
                divisionList.add(new Division(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;

    }
}
