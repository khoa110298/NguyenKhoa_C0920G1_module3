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
        Add New Service
    </h2>
</center>
<div align="center">
    <form method="post" action="/services">
        <input type="hidden" name="action"  value="create">
        <table border="1" cellpadding="5">
            <tr>
                <th>ID:</th>
                <td>
                    <input value="${customerId}" type="text" name="serviceId" id="customerId" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input value="${customerId}" type="text" name="nameService" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>Service area:</th>
                <td>
                    <input value="${customerId}" type="text" name="area" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>Service cost:</th>
                <td>
                    <input value="${customerId}" type="text" name="cost" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>Service max people:</th>
                <td>
                    <input value="${customerId}" type="text" name="maxPeople" size="45" required/>
                    <p style="color: red">${messagecustomerId} </p>
                </td>
            </tr>
            <tr>
                <th>rent type id:</th>
                <td>
                    <select name="rentType">
                        <c:forEach items="${rentTypeList}" var="customerType">
                            <option value="${customerType.id}" }>${customerType.name}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Service type id:</th>
                <td>
                    <select name="serviceType">
                        <c:forEach items="${serviceTypeList}" var="customerType">
                            <option value="${customerType.id}" }>${customerType.name}</option>
                        </c:forEach>
                    </select>

                </td>
            </tr>
            <tr>
                <th>Standard room:</th>
                <td>
                    <input value="${birthday}" type="text" name="standard" id="birthday" size="45" required/>
                    <p style="color: red">${messageBirthDay} </p>
                </td>

            </tr>

            <tr>
                <th>pool area:</th>
                <td>
                    <input value="${idCard}" type="text" name="poolArea" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Number of floors:</th>
                <td>
                    <input value="${phone}" type="text" name="numberFloor" id="phone" size="45"/>
                    <p style="color: red ">${messagePhone}</p>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="action" value="create"/>
                </td>
            </tr>
        </table>
    </form>
    <h2><a href="/services">
        back to list service
    </a></h2>
</div>

</body>
</html>
