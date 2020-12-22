<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/5/2020
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
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
<h1>Delete User</h1>
<div class="card text-white bg-dark" style="max-width: 25rem">
    <div class="card-header text-center">${user.getId()}</div>
    <div class="card-body">
        <p class="h3">${user.getName()}</p>
        <p>Email: ${user.getEmail()}$</p>
        <p>Country: ${user.getCountry()}</p>
    </div>
</div>
<h3>You are Delete?</h3>
<form method="post">
    <input type="submit" class="btn btn-danger" value="Delete">
</form>
<a href="users" class="btn btn-primary">Back to menu</a>
</body>
</html>
