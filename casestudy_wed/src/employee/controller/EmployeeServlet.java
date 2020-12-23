package employee.controller;

import employee.model.*;
import employee.repository.EmployeeRepository;
import employee.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();
    PositionService positionService = new PositionServiceImpl();
    EducationService educationService = new EducationServiceImpl();
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        try {
            switch (action) {
                case "create":
                    createEmployee(request, response);
                    break;
                case "search":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(employeeService.getAllEmployees().get(employeeService.getAllEmployees().size() - 1).getEmployeeId()) + 1;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String positionId = request.getParameter("positionId");
        String education = request.getParameter("educationId");
        String division = request.getParameter("divisionId");
        String userName = request.getParameter("userName");
        employeeService.insertEmployee(new Employee(String.valueOf(id), name, birthday, idCard, salary, phone,
                email, address, positionId, education, division, userName));
        listEmployee(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
//        try {
        switch (action) {
            case "create":
                showCreateEmployee(request, response);
                break;
            case "search":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listEmployee(request, response);
                break;
        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.getAllPosition();
        List<EducationDegree> educationDegreeList = educationService.getAllEducation();
        List<Division> divisionList = divisionService.getAllDivision();
        List<User> userList = userService.getAllUser();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.getAllEmployees();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
