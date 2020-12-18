<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/6/2020
  Time: 1:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <a href="/home">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="nameProduct" id="name" ><c:out value="${product.nameProduct}"/></td>
            </tr>
            <tr>
                <td>price: </td>
                <td><input type="text" name="price" id="price" ><c:out value="${product.price}"/></td>
            </tr>
            <tr>
                <td>describe: </td>
                <td><input type="text" name="describe" id="describe" ><c:out value="${product.describe}"/></td>
            </tr>
            <tr>
                <td>producer: </td>
                <td><input type="text" name="producer" id="producer" ><c:out value="${product.producer}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
