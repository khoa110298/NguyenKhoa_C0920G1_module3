<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/13/2020
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit customer</title>
</head>
<body>
<center>
    <h2>
        <a href="/customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form method="post" action="/customers">
        <input type="hidden" name="action" value="edit">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>

            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="customerId" size="45"
                           value="<c:out value='${customer.customerId}' />" readonly/>
                </td>
            </tr>
            <tr>
                <th>TypeId:</th>
                <td>
                    <select name="typeId">
                        <c:forEach items="${customerType}" var="type">
                            <%--                            <c:if test="${type.id == customer.customerTypeId}">--%>
                            <%--                                <option value="${type.id}" selected>${type.name}</option>--%>
                            <option value="${type.id}" ${type.id == customer.customerTypeId ? "selected" : ""}>${type.name}</option>
                            <%--                            </c:if>--%>
                            <%--                            <c:if test="${type.id != customer.customerTypeId}">--%>
                            <%--                                <option value="${type.id}">${type.name}</option>--%>
                            <%--                            </c:if>--%>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="customerName" size="45"
                           value="<c:out value='${customer.customerName}'/>"/>
                </td>
            </tr>
            <tr>
                <th>birthday:</th>
                <td>
                    <%--                    <c:if test="${customer.customerBirthday != birthday}">--%>
                    <%--                        <input type="date" name="birthday" size="45"--%>
                    <%--                               value="<c:out value='${birthday}' />"/>--%>
                    <%--                    </c:if>--%>
                    <input type="date" name="birthday" size="45"
                           value="<c:out value='${customer.customerBirthday}' />"/>
                    <p style="color: red">${messageBirthDay}</p>
                </td>
            </tr>
            <tr>
                <th>gender:</th>
                <td>
                    <%--                    <input type="text" name="gender" size="45"--%>
                    <%--                           value="<c:out value='${customer.customerGender}' />"/>--%>
                    <select name="gender">
                        <%--                        <option value="1" >nam</option>--%>
                        <%--                        <option value="0" >nu</option>--%>
                        <option value="0" ${customer.customerGender == 0 ? 'selected':''}>nu</option>
                        <option value="1" ${customer.customerGender == 1 ? 'selected':''}>nam</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>IdCard:</th>
                <td>
                    <%--                    <c:if test="${customer.customerIdCard != idCard}">--%>
                    <%--                        <input type="text" name="idCard" size="45"--%>
                    <%--                               value="<c:out value='${idCard}' />"/>--%>
                    <%--                    </c:if>--%>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${customer.customerIdCard}' />"/>
                        <p style="color: red">${messageIdCard}</p>
                </td>
            </tr>
            <tr>
                <th>phone:</th>
                <td>
                    <%--                    <c:if test="${customer.customerPhone != phone}">--%>
                    <%--                        <input type="text" name="phone" size="45"--%>
                    <%--                               value="<c:out value='${phone}' />"/>--%>
                    <%--                    </c:if>--%>
                    <input type="text" name="phone" size="45"
                           value="<c:out value='${customer.customerPhone}' />"/>
                        <p style="color: red">${messagePhone}</p>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <%--                    <c:if test="${customer.customerEmail != email}">--%>
                    <%--                        <input type="text" name="email" size="45"--%>
                    <%--                               value="<c:out value='${email}' />"/>--%>
                    <%--                    </c:if>--%>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${customer.customerEmail}' />"/>
                        <p style="color: red">${messageEmail}</p>
                </td>
            </tr>
            <tr>
                <th>address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${customer.customerAddress}' />"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
