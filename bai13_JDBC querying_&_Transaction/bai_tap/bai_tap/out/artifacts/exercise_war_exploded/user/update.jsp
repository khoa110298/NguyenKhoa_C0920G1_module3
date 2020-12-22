<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/5/2020
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<h1>Update User</h1>
<div class="form-group">
    <form method="post">
        <input type="hidden" name="id" value="${user.getId()}">
        <div class="row">
        <label class="col-form-label col-2">Name User</label>
        <input class="form-control col-8" type="text" name="name" value="${user.getName()}">
        </div>
        <div class="row">
        <label class="col-form-label col-2">Email</label>
        <input class="form-control col-8" type="text" name="email" value="${user.getEmail()}">
        </div>
        <div class="row">
        <label class="col-form-label col-2">Country</label>
        <input class="form-control col-8" type="text" name="country" value="${user.getCountry()}">
        </div>
        <input class="btn btn-success" type="submit" name="action" value="Update">
    </form>
</div>
</body>
</html>
