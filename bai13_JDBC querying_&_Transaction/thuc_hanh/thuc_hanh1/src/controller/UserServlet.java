package controller;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userService.updateUser(new User(id,name,email,country));
        response.sendRedirect("/users");
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name1 = request.getParameter("name");
        String email1 = request.getParameter("email");
        String country1 = request.getParameter("country");
//        userService.insertUser(new User(name1, email1, country1));
        userService.insertUserStore(new User(name1,email1,country1));
        response.sendRedirect("/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showCreateUser(request, response);
                    break;
                case "edit":
                    showEditUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "search":
                    findByName(request,response);
                    break;
                case "permision":
                    addUserPermision(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":
                    testUseTran(request, response);
                    break;

                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateUseTransaction();
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        userService.insertUpdateWithoutTransaction();
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("kien", "kienhoang@gmail.com", "vn");

        int[] permision = {1, 2, 4};

        userService.addUserTransaction(user, permision);
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<User> userList = userService.findUserByName(name);
        request.setAttribute("userList",userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khoa/search.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        User user = userService.selectUser(id);
        User user = userService.getUserById(id);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khoa/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        response.sendRedirect("/users");
    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("khoa/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userService.selectAllUsers();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khoa/list.jsp");
        dispatcher.forward(request, response);
    }
}
