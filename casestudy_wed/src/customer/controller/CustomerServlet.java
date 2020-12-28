package customer.controller;

import common.*;
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
    Validate validate = new Validate();
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
                case "search":
                    break;
                case "edit":
                    editCustomer(request,response);
                    break;
                case "delete":
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        boolean check = true;
        String messageId = null;
        String messageIdCard = null;
        String messagePhone= null;
        String messageBirthDay = null;
        String messageEmail = null;
        String birthDay = null;
        String phone = null;
        String email = null;
        String customerId = null;
        String idCard = null;


            customerId = request.getParameter("customerId");

        String typeId = request.getParameter("typeId");
        String name = request.getParameter("customerName");
        try {
            birthDay = request.getParameter("birthday");
            validate.regexDate(birthDay);
        } catch (BirthdayException e) {
            messageBirthDay = e.getMessage();
            check = false;
        }
        String gender = request.getParameter("gender");
        try {
            idCard = request.getParameter("idCard");
            validate.regexIdCard(idCard);
        } catch (ValidateException e) {
            messageIdCard = e.getMessage();
            check = false;
        }
        try {
            phone = request.getParameter("phone");
            validate.regexPhone(phone);
        } catch (PhoneException e) {
            messagePhone = e.getMessage();
            check = false;
        }
        try {
            email = request.getParameter("email");
            validate.regexEmail(email);
        } catch (EmailException e) {
            messageEmail = e.getMessage();
            check = false;
        }
        String address = request.getParameter("address");
        if (!check){
            request.setAttribute("customerId", customerId);
            request.setAttribute("typeId", typeId);
            request.setAttribute("name", name);
            request.setAttribute("birthday",birthDay);
            request.setAttribute("gender",gender);
            request.setAttribute("idCard",idCard);
            request.setAttribute("phone",phone);
            request.setAttribute("email",email);
            request.setAttribute("address",address);


            request.setAttribute("messageIdCard",messageIdCard);
            request.setAttribute("messageBirthDay",messageBirthDay);
            request.setAttribute("messagePhone",messagePhone);
            request.setAttribute("messageEmail",messageEmail);


            Customer customer = new Customer(customerId, typeId, name, birthDay, gender, idCard, phone, email, address);
            List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
            request.setAttribute("customer",customer);
            request.setAttribute("customerType",customerTypeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
            dispatcher.forward(request,response);
        }else {
            customerService.updateCustomer(new Customer(customerId, typeId, name, birthDay, gender, idCard, phone, email, address));
            request.setAttribute("messageConfig", "đã sửa thành công");
//        response.sendRedirect("/customers");
            listCustomer(request, response);
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        boolean check = true;
        String messageId = null;
        String messageIdCard = null;
        String messagePhone= null;
        String messageBirthDay = null;
        String messageEmail = null;
        String birthDay = null;
        String phone = null;
        String email = null;
        String customerId = null;
        String idCard = null;

        try {
            customerId = request.getParameter("customerId");
            validate.regexIdCustomer(customerId);
        } catch (ValidateException e) {
            messageId = e.getMessage();
            check = false;
        }

        String typeId = request.getParameter("typeId");
        String name = request.getParameter("name");
        try {
            birthDay = request.getParameter("birthday");
            validate.regexDate(birthDay);
        } catch (BirthdayException e) {
            messageBirthDay = e.getMessage();
            check = false;
        }

        String gender = request.getParameter("gender");

        try {
            idCard = request.getParameter("idCard");
            validate.regexIdCard(idCard);
        }catch (ValidateException e){
            messageIdCard = e.getMessage();
            check = false;
        }

        try {
            phone = request.getParameter("phone");
            validate.regexPhone(phone);
        } catch (PhoneException e) {
            messagePhone = e.getMessage();
            check = false;
        }
        try {
            email = request.getParameter("email");
            validate.regexEmail(email);
        } catch (EmailException e) {
            messageEmail = e.getMessage();
            check = false;
        }
        String address = request.getParameter("address");

        if (!check){
            request.setAttribute("customerId", customerId);
            request.setAttribute("typeId", typeId);
            request.setAttribute("name", name);
            request.setAttribute("birthday",birthDay);
            request.setAttribute("gender",gender);
            request.setAttribute("idCard",idCard);
            request.setAttribute("phone",phone);
            request.setAttribute("email",email);
            request.setAttribute("address",address);


            request.setAttribute("messageId",messageId);
            request.setAttribute("messageIdCard",messageIdCard);
            request.setAttribute("messageBirthDay",messageBirthDay);
            request.setAttribute("messagePhone",messagePhone);
            request.setAttribute("messageEmail",messageEmail);
            
            showCreateCustomer(request,response);
        }else {
            customerService.insertCustomer(new Customer(customerId,typeId,name,birthDay,gender,idCard,phone,email,address));
            request.setAttribute("messageConfig","đã thêm thành công");
//        response.sendRedirect("/customers");
            listCustomer(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = " ";
        }
        try {
            switch (action) {
                case "create":
                    showCreateCustomer(request,response);
                    break;
                case "search":
                    findCustomerByname(request,response);
                    break;
                case "edit":
                    showEditCustomer(request,response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void findCustomerByname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("customerName");
        List<Customer> customerList = customerService.searchByName(name);
        request.setAttribute("customerList" ,customerList);
//        request.setAttribute("name" ,name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/search.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("id");
        Customer customer = customerService.selectCustomer(customerId);
        List<CustomerType> customerTypeList = customerTypeService.getAllCustomerType();
        request.setAttribute("customer",customer);
        request.setAttribute("customerType",customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String id = request.getParameter("customerId");
        customerService.deleteCustomer(id);
        request.setAttribute("messageConfig","đã xóa thành công");
//        response.sendRedirect("/customers");
        listCustomer(request,response);
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
