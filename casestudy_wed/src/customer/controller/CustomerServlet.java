package customer.controller;

import customer.model.Customer;
import customer.model.CustomerType;
import customer.service.CustomerService;
import customer.service.CustomerServiceImpl;
import customer.service.CustomerTypeService;
import customer.service.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
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
                    createCustomer(request,response);
                    break;
                case "search": {
                    break;
                }
                case "edit":
                    break;
                case "delete":
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String customerId = request.getParameter("customerId");
        String typeID = request.getParameter("typeId");
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        customerService.insertCustomer(new Customer(customerId,typeID,name,birthDay,gender,idCard,phone,email,address));
        response.sendRedirect("/customers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "create":
                showCreateCustomer(request,response);
                break;
            case "search": {
                break;
            }
            case "edit":
                break;
            case "delete":
                break;
            default:
                listCustomer(request, response);
                break;
        }

    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("customerTypeList",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.getAllCustomers();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request,response);
    }
}
