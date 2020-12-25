package service.controller;

import service.model.RentType;
import service.model.Service;
import service.model.ServiceType;
import service.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    ServiceSe serviceSe = new ServiceImpl();
    RentTypeService rentTypeService = new RentTypeServiceImpl();
    ServiceTypeSe serviceTypeSe = new ServiceTypeSeImpl();
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
                    CreateService(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void CreateService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("serviceId");
        String name = request.getParameter("nameService");
        String serviceAre = request.getParameter("area");
        String serviceCost = request.getParameter("cost");
        String serviceMaxPeople = request.getParameter("maxPeople");
        String rentTypeId = request.getParameter("rentType");
        String serviceTypeId = request.getParameter("serviceType");
        String standRoom = request.getParameter("standard");
        String poolArea = request.getParameter("poolArea");
        String numberFloor = request.getParameter("numberFloor");
        serviceSe.insertService(new Service(id,name,serviceAre,serviceCost,serviceMaxPeople,rentTypeId,serviceTypeId,standRoom,poolArea,numberFloor));
        response.sendRedirect("/services");
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
                    showCreateEmployee(request, response);
                    break;
                case "delete":
                    deleteService(request,response);
                    break;
                default:
                    listService(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id = request.getParameter("idService");
        serviceSe.deleteEmployee(id);
        response.sendRedirect("/services");
    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeService.getAll();
        List<ServiceType> serviceTypeList = serviceTypeSe.getAll();
        request.setAttribute("rentTypeList",rentTypeList);
        request.setAttribute("serviceTypeList",serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        dispatcher.forward(request,response);
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceSe.getAll();
        request.setAttribute("serviceList",serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request,response);
    }
}
