package employee.controller;

import employee.model.Division;
import employee.model.EducationDegree;
import employee.model.Employee;
import employee.model.Position;
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

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();
    PositionService positionService = new PositionServiceImpl();
    EducationService educationService = new EducationServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
            switch (action) {
                case "create":
                    break;
                case "search":
                    break;
                case "edit":
                    break;
                case "delete":
                    break;
            }


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
                    showCreateEmployee(request,response);
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
        request.setAttribute("positionList",positionList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.getAllEmployees();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request,response);
    }
}
