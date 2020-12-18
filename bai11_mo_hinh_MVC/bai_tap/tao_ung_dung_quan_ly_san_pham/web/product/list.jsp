<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/5/2020
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list Product</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<h1>List Product</h1>
<div>
    <a href="/home?action=create" class="btn btn-success ml-3">Create new product</a>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">nameProduct</th>
        <th scope="col">price</th>
        <th scope="col">describe</th>
        <th scope="col">producer</th>
        <th scope="col">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
        <tr>
            <th scope="row"><c:out value="${product.id}"/></th>
            <td><c:out value="${product.nameProduct}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.describe}"/></td>
            <td><c:out value="${product.producer}"/></td>
            <td>
                <a href="/home?action=edit&id=${product.id}" class="btn btn-warning">Edit</a>
                <a href="/home?action=delete&id=${product.id}" class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
