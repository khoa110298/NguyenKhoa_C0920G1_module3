<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/6/2020
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>delete product</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/home">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>name product: </td>
                <td><c:out value="${product.nameProduct}"/></td>
            </tr>
            <tr>
                <td>price: </td>
                <td><c:out value="${product.price}"/></td>
            </tr>
            <tr>
                <td>describe: </td>
                <td><c:out value="${product.describe}"/></td>
            </tr>
            <tr>
                <td>producer: </td>
                <td><c:out value="${product.producer}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
