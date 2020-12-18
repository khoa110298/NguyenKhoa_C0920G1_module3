<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/17/2020
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list User</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
</head>
<body style="background-color: lemonchiffon">
<div style="margin-top: 10px;float: right;margin-right: 10px">
    <form class="form-inline my-2 my-lg-0" method="get" action="/users">
        <input type="hidden" name="action" value="search">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>
<div style="clear: both">
    <center>
        <h1>User Management</h1>
        <h2>
            <a href="/users?action=create">Add New User</a>
        </h2>
    </center>
</div>



<table class="table table-striped" id="tableCustomer">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Country</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
    <tr>

        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
        <td> <a href="/users?action=edit&id=${user.getId()}" class="btn btn-primary">Edit</a></td>
<%--        <td> <a href="/customers?action=delete&id=${user.getId()}" class="btn btn-danger">Delete</a></td>--%>
        <td>
            <button type="button" class="btn btn-danger" onclick="getIdCustomer(${user.id})"
                    data-toggle="modal" data-target="#modelId"> delete</button>
        </td>

    </tr>
    </c:forEach>
    </tbody>
</table>


<!-- Modal -->
<div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">delete Users</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/users">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" id="idCustomer" value="">
            <div class="modal-body">
                Are You Sure
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">cancle</button>
                <button type="submit" class="btn btn-primary">ok</button>
            </div>
            </form>
        </div>
    </div>
</div>


<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="bootstrap413/js/bootstrap.js"></script>
<script src="bootstrap413/js/bootstrap.bundle.js"></script>
</body>
<script>
    function getIdCustomer(id) {
        $('#idCustomer').val(id);
    }

    $(document).ready(function() {
        $('#tableCustomer').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        } );
    } );

</script>
</html>
