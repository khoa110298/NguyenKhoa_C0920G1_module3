package employee.repository;

import employee.model.Division;
import employee.model.EducationDegree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements EducationDegreeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String SELECT_ALL_EDUCATION= "select * from education_degree";


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
    public List<EducationDegree> getAllEducation() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EDUCATION)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegreeList;
    }
}
