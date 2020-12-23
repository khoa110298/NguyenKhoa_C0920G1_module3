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
    <title>create employee</title>
</head>
<body>
<center>
    <h2>
        Add New Employee
    </h2>
</center>
<div align="center">
    <form method="post" action="/employees?action=create">
<%--        <input type="hidden" name="employeeId">--%>
        <table border="1" cellpadding="5">
            <tr>
                <th>Name:</th>
                <td>
                    <input value="${name}" type="text" name="name" id="name" size="45" required/>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>typeId:</th>--%>
<%--                <td>--%>
<%--                    <select name="typeId">--%>
<%--                        <c:forEach items="${customerTypeList}" var="customerType">--%>
<%--                            <option value="${customerType.id}" ${typeId == customerType.id ? "selected" : ""}>${customerType.name}</option>--%>
<%--                        </c:forEach>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input value="${birthday}" type="date" name="birthday" id="birthday" size="45" required/>
                    <p style="color: red">${messageBirthDay} </p>
                </td>

            </tr>
            <tr>
                <th>IdCard:</th>
                <td>
                    <input value="${idCard}" type="text" name="idCard" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Salary:</th>
                <td>
                    <input value="${salary}" type="text" name="salary" id="salary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input value="${phone}" type="text" name="phone" id="phone" size="45"/>
                    <p style="color: red ">${messagePhone}</p>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input value="${email}" type="text" name="email" id="email" size="45"/>
                    <p style="color: red">${messageEmail}</p>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input value="${address}" type="text" name="address" id="adress" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Position Id:</th>
                <td>
                    <select name="positionId">
                        <c:forEach items="${positionList}" var="customerType">
                            <option value="${customerType.id}" >${customerType.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>education degree id:</th>
                <td>
                    <select name="educationId">
                        <c:forEach items="${educationDegreeList}" var="customerType">
                            <option value="${customerType.id}" >${customerType.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Division Id:</th>
                <td>
                    <select name="divisionId">
                        <c:forEach items="${divisionList}" var="customerType">
                            <option value="${customerType.id}" >${customerType.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>user name:</th>
                <td>
                    <select name="userName">
                        <c:forEach items="${userList}" var="customerType">
                            <option value="${customerType.name}" >${customerType.name}</option>
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
    <h2><a href="/customers">
        back to list customer
    </a></h2>
</div>

</body>
</html>
