<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/16/2020
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>khach hang</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
</head>
<body id="">
<h1 style="text-align: center">Customers</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<table class="table table-striped" id="tableCustomer">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">name</th>
        <th scope="col">email</th>
        <th scope="col">address</th>
        <th scope="col">edit</th>
        <th scope="col">delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cus" items="${customers}">
    <tr>

        <td>
            <a href="/customers?action=view&id=${cus.getId()}">${cus.getId()}</a>
        </td>
        <td>${cus.getName()}</td>
        <td>${cus.getEmail()}</td>
        <td>${cus.getAddress()}</td>
        <td> <a href="/customers?action=edit&id=${cus.getId()}" class="btn btn-primary">Edit</a></td>
<%--        <td> <a href="/customers?action=delete&id=${cus.getId()}" class="btn btn-danger">Delete</a></td>--%>
        <td>
            <button type="button" class="btn btn-danger" onclick="getIdCustomer(${cus.getId()})"
                    data-toggle="modal" data-target="#modelCustomer"> delete</button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>



<!-- Modal -->
<div class="modal fade" id="modelCustomer" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">delete Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/customers">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" id="idCustomer" value="">
            <div class="modal-body">
                are you sure ?
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
