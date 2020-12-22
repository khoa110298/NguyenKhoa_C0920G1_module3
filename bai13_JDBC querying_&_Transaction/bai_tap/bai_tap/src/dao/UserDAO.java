package dao;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbc = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String user = "root";
    private String password = "0944524135a";

    private static final String INSERT_USER = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "SELECT * FROM users where id = ?;";
    private static final String SELECT_ALL_USER = "SELECT id,name,email,country FROM users;";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users where id = ?;";
    private static final String UPDATE_USER_BY_ID = "UPDATE users set name = ?, email = ?, country = ? where id = ?;";
    private static final String SELECT_USER_BY_COUNTRY = "SELECT * FROM users where country like ?";
    private static final String SORT_USER_BY_NAME = "SELECT * FROM users ORDER BY name;";

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbc, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }

    @Override
    public User selectUserById(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void updateUser(int id, User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY)) {
            preparedStatement.setString(1, "%" + country + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> sortListUserByName() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USER_BY_NAME)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = null;

        String query = "{CALL get_user_by_id(?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());

            callableStatement.executeUpdate();
        }
    }

    @Override

    public void addUserTransaction(User user, int[] permisions) {

        Connection conn = null;

        PreparedStatement pstmt = null;

        PreparedStatement pstmtAssignment = null;

        ResultSet rs = null;

        try {
            conn = getConnection();

            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();


            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);

            if (rowAffected == 1) {

                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();
                }
                conn.commit();
            } else {
                conn.rollback();
            }

        } catch (SQLException ex) {
            try {
                if (conn != null)
                    conn.rollback();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());
            }
        }
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    @Override

    public void insertUpdateWithoutTransaction() {

        try (Connection conn = getConnection();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {


            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);


            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psUpdate.setBigDecimal(2, new BigDecimal(999.99));


            psUpdate.setString(2, "Quynh");

            psUpdate.execute();


        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    @Override

    public void insertUpdateUseTransaction() {

        try (Connection conn = getConnection();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);

            // start transaction block

            conn.setAutoCommit(false); // default true

            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();


            // Run list of update commands


            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            try {
                psUpdate.setBigDecimal(2, new BigDecimal(999.99));


                // ???????????????????????
//                conn.rollback();


                //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

                psUpdate.setString(2, "Quynh");
            } catch (SQLException e) {
                conn.rollback();
            }


            psUpdate.execute();


            // end transaction block, commit changes

            conn.commit();

            // good practice to set it back to default true

            conn.setAutoCommit(true);


        } catch (Exception e) {

            System.out.println(e.getMessage());

            e.printStackTrace();

        }

    }

    @Override
    public List<User> selectAllUserStore() {
        String query = "{CALL select_user()}";
        List<User> userList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void updateUserStore(User user) {
        String query = "{CALL update_user(?,?,?,?)}";
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCountry());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUserStore(int id) {
        String query = "{CALL delete_user(?)}";

        try(Connection connection =getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
