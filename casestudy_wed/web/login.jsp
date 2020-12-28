<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/25/2020
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>

<form  style="text-align: center;background-color: #5a6268;height: 750px">
    <div class="form-group">
        <label for="exampleInputEmail1">User Name</label><br>
        <input type="text" size="45" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="User Name" >

    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label><br>
        <input type="password" size="45" id="exampleInputPassword1" placeholder="Password" >
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Remember me</label>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="bootstrap413/js/bootstrap.js"></script>
<script src="jquery/popper.min.js"></script>
</body>
</html>
