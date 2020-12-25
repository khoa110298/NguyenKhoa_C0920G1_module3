package service.repository;

import service.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String SELECT_ALL_DIVISION = "select * from service";
    private static final String INSERT_SERVICE = "insert into  service(service_id,service_name,sarvice_area," +
            "service_cost,service_max_people,rent_type_id,service_type_id,standard_room,pool_area,number_of_floors) " +
            "values(?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_SERVICE = "delete from service where service_id = ?";

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
    public List<Service> getAll() {
        List<Service> serviceList = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DIVISION)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id ="DV-" + resultSet.getString("service_id");
                String serviceName = resultSet.getString("service_name");
                String serviceAre = resultSet.getString("sarvice_area");
                String serviceCost = resultSet.getString("service_cost");
                String serviceMaxPeople = resultSet.getString("service_max_people");
                String rentTypeId = resultSet.getString("rent_type_id");
                String serviceTypeId = resultSet.getString("service_type_id");
                String standRoom = resultSet.getString("standard_room");
                String poolArea = resultSet.getString("pool_area");
                String numberFloor = resultSet.getString("number_of_floors");
                serviceList.add(new Service(id,serviceName,serviceAre,serviceCost,serviceMaxPeople,rentTypeId,serviceTypeId,standRoom,poolArea,numberFloor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void insertService(Service service) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SERVICE)) {
            statement.setString(1,service.getServiceId());
            statement.setString(2,service.getServiceName());
            statement.setString(3,service.getServiceAre());
            statement.setString(4,service.getServiceCost());
            statement.setString(5,service.getServiceMaxPeople());
            statement.setString(6,service.getRentTypeId());
            statement.setString(7,service.getServiceTypeId());
            statement.setString(8,service.getStandRoom());
            statement.setString(9,service.getPoolArea());
            statement.setString(10,service.getNumberFloor());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        boolean check;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE)) {
            statement.setString(1,id.substring(3));
            check = statement.executeUpdate() >0;
        }
        return check;
    }
}
