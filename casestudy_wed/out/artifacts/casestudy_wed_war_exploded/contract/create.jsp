<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/12/2020
  Time: 12:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>create service</title>
</head>
<body>
<center>
    <h2>
        Add New Contract
    </h2>
</center>
<div align="center">
    <form method="post" action="/contracts">
        <input type="hidden" name="action"  value="create">
        <table border="1" cellpadding="5">
            <tr>
                <th>Start Date:</th>
                <td>
                    <input value="${customerId}" type="date" name="startDate" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>End Date:</th>
                <td>
                    <input value="${customerId}" type="date" name="endDate" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>Deposit:</th>
                <td>
                    <input value="${customerId}" type="text" name="deposit" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>Total Money:</th>
                <td>
                    <input value="${customerId}" type="text" name="totalMoney" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>Employee id:</th>
                <td>
                    <select name="employeeId">
                        <c:forEach items="${employeeList}" var="customerType">
                            <option value="${customerType.employeeId}" }>${customerType.employeeName}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Customer id:</th>
                <td>
                    <select name="customerId">
                        <c:forEach items="${customerList}" var="customerType">
                            <option value="${customerType.customerId}" }>${customerType.customerName}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Service id:</th>
                <td>
                    <select name="serviceId">
                        <c:forEach items="${serviceList}" var="customerType">
                            <option value="${customerType.serviceId}" }>${customerType.serviceName}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>


            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="action" value="create"/>
                </td>
            </tr>
        </table>
    </form>
    <h2><a href="/contracts">
        back to list service
    </a></h2>
</div>

</body>
</html>

