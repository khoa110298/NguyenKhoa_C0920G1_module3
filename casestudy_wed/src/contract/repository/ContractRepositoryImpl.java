package contract.repository;

import contract.model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {

    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";




    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO " +
            "contract(contract_id,contract_start_date,contarct_end_date,contact_deposit,contract_total_money,employee_id," +
            "customer_id,service_id) " +
            "VALUES(?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_EMPLOYEE = "select * from contract";
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
    public List<Contract> getAll() {
        List<Contract> contractList = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("contract_id");
                String start_date = resultSet.getString("contract_start_date");
                String end_date = resultSet.getString("contarct_end_date");
                String deposit = resultSet.getString("contact_deposit");
                String total_money = resultSet.getString("contract_total_money");
                String employee_id = resultSet.getString("employee_id");
                String customer_id = resultSet.getString("customer_id");
                String service_id = resultSet.getString("service_id");
                contractList.add(new Contract(id,start_date,end_date,deposit,total_money,employee_id,customer_id,service_id));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contractList;
    }

    @Override
    public void insert(Contract contract) throws SQLException {
        try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)){
            statement.setString(1,contract.getId());
            statement.setString(2,contract.getStartDate());
            statement.setString(3,contract.getEndDate());
            statement.setString(4,contract.getDeposit());
            statement.setString(5,contract.getTotalMoney());
            statement.setString(6,contract.getEmployeeId());
            statement.setString(7,contract.getCustomerId());
            statement.setString(8,contract.getServiceId());
            statement.executeQuery();

        }finally {
            getConnection().close();
        }
    }
}
