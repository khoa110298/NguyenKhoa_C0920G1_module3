<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/5/2020
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@    taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>


</head>
<body>

<div class="container">
    <h1 class="text-center">List User</h1>
<div class="row form-group">
    <a href="users?action=create" class="btn btn-success ml-3">Create new User</a>

        <form method="get" class="ml-auto row">
    <input type="submit" class="btn btn-info" value="Find" name="action">
    <input type="text" class="form-control col-6" name="country">
        </form>
</div>
<table class="table table-dark">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td><a href="users?action=see&id=${user.getId()}">${user.getName()}</a></td>
            <td>${user.getEmail()}</td>
            <td>${user.getCountry()}</td>
            <td><a href="users?action=update&id=${user.getId()}" class="btn btn-primary">Update</a></td>
            <td><a href="users?action=delete&id=${user.getId()}" class="btn btn-danger">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <a href="users?action=sort" class="btn btn-primary">Sort</a>
</div>
</body>
</html>
