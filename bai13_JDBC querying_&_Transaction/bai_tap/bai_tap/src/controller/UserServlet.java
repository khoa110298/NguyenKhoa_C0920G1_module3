package controller;

import model.User;
import repository.UserRepository;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    UserRepository userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createNewUser(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createJSP(request, response);
                break;
            case "update":
                updateJSP(request, response);
                break;
            case "delete":
                deleteJSP(request, response);
                break;
            case "see":
                seeJSP(request, response);
                break;
            case "Find":
                findJSP(request, response);
                break;
            case "sort":
                sortJSP(request, response);
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
                printListUser(request, response);
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


    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        userService.deleteUserStore(id);

        printListUser(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id, name, email, country);

        userService.updateUserStore(user);

        printListUser(request, response);
    }


    private void sortJSP(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.sortListUserByName();

        request.setAttribute("userList", userList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/find.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findJSP(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");

        List<User> userList = userService.findUserByCountry(country);
        request.setAttribute("userList", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/find.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seeJSP(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        User user = userService.findUserById(id);
        System.out.println(user);
        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/see.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteJSP(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findUserById(id);
        request.setAttribute("user", user);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/delete.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateJSP(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findUserById(id);

        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/update.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewUser(HttpServletRequest request, HttpServletResponse response) {
//        int id;
//        List<User> userList = userService.printListUser();
//        id = (userList.size() == 0 ? 1 : userList.size() +1 );

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name, email, country);

        userService.createNewUser(user);

        printListUser(request, response);
    }

    private void createJSP(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void printListUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.selectAllUserStore();
        request.setAttribute("userList", userList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
