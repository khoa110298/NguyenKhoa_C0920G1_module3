<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/5/2020
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <style>
        .row {
            margin-top: 5px;
        }
    </style>
</head>
<body>
<h1>Create new User</h1>
<hr width="90%">
<div class="col-8 form-group">
    <form method="post">
        <div class="row">
            <label class="col-2">Name</label>
            <input type="text" name="name" placeholder="Name" class="form-control col-8">
        </div>
        <div class="row">
            <label class="col-2">Email</label>
            <input type="text" name="email" placeholder="Email" class="form-control col-8">
        </div>
        <div class="row">
            <label class="col-2">Country</label>
            <input type="text" name="country" placeholder="Country" class="form-control col-8">
        </div>
        <input type="submit" class="btn btn-success mt-4" name="create">
        <br>
        <a href="users" class="btn btn-primary mt-3">Back to menu</a>
    </form>
</div>
</body>
</html>
