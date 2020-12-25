<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/10/2020
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee</title>
    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"--%>
    <%--          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
    <style>
        #head {
            width: 100%;
            height: 160px;
            background-color: #555555;
            position: fixed;
            z-index: 9;
        }

        #head_top {
            width: 100%;
            height: 100px;
            background-color: #CDCDCD;
            position: absolute;
        }

        #head_top a {
            margin-top: 20px;
            float: left;
        }

        #head_top p {
            color: red;
            margin-top: 30px;
            float: right;
            margin-right: 30px;
        }

        #headbottom {
            width: 100%;
            position: absolute;
            top: 100px;
        }

        #content {
            position: relative;
            top: 160px;
        }

        #footer {
            text-align: center;
            padding-top: 40px;
            background-color: burlywood;
            width: 100%;
            height: 100px;
            position: relative;
            top: 160px;
        }

        #footer label {
            color: blue;
        }
    </style>
</head>
<body>
<div id="head">
    <div id="head_top">
        <a href="#">
            <img src="anh/logo.png" height="50px" width="200px">
        </a>
        <p>NGUYỄN KHOA-C092G1</p>
    </div>
    <div id="headbottom">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"><h4 style="color: red">Home</h4></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul id="abc" class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/employees">Employee <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/customers">Customer <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/services">Service <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/contracts">Contract <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" method="get" action="/customers">
                    <input type="hidden" name="action" value="search">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                           name="employeeName">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</div>
<div id="content">
    <center>
        <h1>Employee Name ${name}</h1>
        <h2>
                        <a href="/employees">Back To List Employee</a>
<%--            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modelCreate">Add New--%>
<%--                Employee--%>
<%--            </button>--%>
        </h2>
    </center>
    <table class="table table-striped" id="tableEmployee">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th scope="col">BIRTHDAY</th>
            <th scope="col">ID CARD</th>
            <th scope="col">SALARY</th>
            <th scope="col">PHONE</th>
            <th scope="col">EMAIL</th>
            <th scope="col">ADDRESS</th>
            <th scope="col">POSITION ID</th>
            <th scope="col">EDUCATION DEGREE ID</th>
            <th scope="col">DIVISION ID</th>
            <th scope="col">USER NAME</th>
            <th scope="col">EDIT</th>
            <th scope="col">DELETE</th>

        </thead>
        <tbody>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td><c:out value="${employee.employeeId}"/></td>
                <td><c:out value="${employee.employeeName}"/></td>
                <td><c:out value="${employee.employeeBirthday}"/></td>
                <td><c:out value="${employee.employeeIdCard}"/></td>
                <td><c:out value="${employee.employeeSalary}"/></td>
                <td><c:out value="${employee.employeePhone}"/></td>
                <td><c:out value="${employee.employeeEmail}"/></td>
                <td><c:out value="${employee.employeeAddress}"/></td>
                <td><c:out value="${employee.positionId}"/></td>
                <td><c:out value="${employee.educationDegreeId}"/></td>
                <td><c:out value="${employee.divisionId}"/></td>
                <td><c:out value="${employee.userName}"/></td>
                <td>
                        <%--                    <a href="/customers?action=edit&id=${employee.employeeId}" class="btn btn-primary">Edit</a>--%>
                    <button type="button" class="btn btn-primary" onclick="editEmployee('${employee.employeeId}','${employee.employeeName}','${employee.employeeBirthday}',
                            '${employee.employeeIdCard}','${employee.employeeSalary}','${employee.employeePhone}','${employee.employeeEmail}','${employee.employeeAddress}',
                            '${employee.positionId}','${employee.educationDegreeId}','${employee.divisionId}','${employee.userName}')"
                            data-toggle="modal" data-target="#modelEdit" >Edit</button>
                </td>
                <td>
                        <%--                                            <a href="/customers?action=delete&id=${cus.customerId}" class="btn btn-danger">Delete</a>--%>
                    <button type="button" class="btn btn-danger" onclick="getIdEmployee('${employee.employeeId}')"
                            data-toggle="modal" data-target="#modelDelete">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2 style="text-align: center;color: red"> ${message}</h2>
</div>


<!-- Modal Create -->
<div class="modal fade" id="modelCreate" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">create employee title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/employees">
                <input type="hidden" name="action" value="create">
                <div class="modal-body">
                    <label>name</label>
                    <input type="text" name="nameEmployee"><br>
                    <label>birthday</label>
                    <input type="date" name="birthday"><br>
                    <label>Id Card</label>
                    <input type="text" name="idCard"><br>
                    <label>salary</label>
                    <input type="text" name="salary"><br>
                    <label>phone</label>
                    <input type="text" name="phone"><br>
                    <label>email</label>
                    <input type="text" name="email"><br>
                    <label>address</label>
                    <input type="text" name="address"><br>
                    <label>positionId</label>
                    <select name="positionId">
                        <c:forEach items="${positionList}" var="customerType">
                            <option value="${customerType.id}">${customerType.name}</option>
                        </c:forEach>
                    </select><br>
                    <label>educationDegreeId</label>
                    <select name="educationId">
                        <c:forEach items="${educationDegreeList}" var="customerType">
                            <option value="${customerType.id}" >${customerType.name}</option>
                        </c:forEach>
                    </select><br>
                    <label>divisionId</label>
                    <select name="divisionId">
                        <c:forEach items="${divisionList}" var="customerType">
                            <option value="${customerType.id}" >${customerType.name}</option>
                        </c:forEach>
                    </select><br>
                    <label>userName</label>
                    <select name="userName">
                        <c:forEach items="${userList}" var="customerType">
                            <option value="${customerType.name}" >${customerType.name}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">cancle</button>
                    <button type="submit" class="btn btn-primary">ok</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Modal delete-->
<div class="modal fade" id="modelDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Delete Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/employees">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="employeeId" id="idEmployee">
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



<!-- Modal edit-->
<div class="modal fade" id="modelEdit" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="/employees">
                <input type="hidden" name="action" value="edit">
                <div class="modal-body">
                    <label>id</label>
                    <input type="text" name="idEmployee" readonly id="id"><br>
                    <label>name</label>
                    <input type="text" name="nameEmployee" id="name"><br>
                    <label>birthday</label>
                    <input type="date" name="birthday" id="birthday"><br>
                    <label>Id Card</label>
                    <input type="text" name="idCard" id="idCard"><br>
                    <label>salary</label>
                    <input type="text" name="salary" id="salary"><br>
                    <label>phone</label>
                    <input type="text" name="phone" id="phone"><br>
                    <label>email</label>
                    <input type="text" name="email" id="email"><br>
                    <label>address</label>
                    <input type="text" name="address" id="address"><br>
                    <label>positionId</label>
                    <select name="positionId" id="positionId">
                        <c:forEach items="${positionList}" var="customerType">
                            <option value="${customerType.id}">${customerType.name}</option>
                        </c:forEach>
                    </select><br>
                    <label>educationDegreeId</label>
                    <select name="educationId" id="educationId">
                        <c:forEach items="${educationDegreeList}" var="customerType">
                            <option value="${customerType.id}" >${customerType.name}</option>
                        </c:forEach>
                    </select><br>
                    <label>divisionId</label>
                    <select name="divisionId" id="divisionId">
                        <c:forEach items="${divisionList}" var="customerType">
                            <option value="${customerType.id}" >${customerType.name}</option>
                        </c:forEach>
                    </select><br>
                    <label>userName</label>
                    <select name="userName" id="userName">
                        <c:forEach items="${userList}" var="customerType">
                            <option value="${customerType.name}" >${customerType.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">cancle</button>
                    <button type="submit" class="btn btn-primary">ok</button>
                </div>
            </form>
        </div>
    </div>
</div>


<%--    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"--%>
<%--          integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
<%--  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"--%>
<%--          integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>--%>
<%--  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"--%>
<%--          integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="bootstrap413/js/bootstrap.js"></script>
<script src="jquery/popper.min.js"></script>
</body>
<script>
    function getIdEmployee(id) {
        $('#idEmployee').val(id);
    }

    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
    function editEmployee(id,name,birthday,idCard,salary,phone,email,address,positionId,educationId,divisionId,userName) {
        $('#id').val(id);
        $('#name').val(name);
        $('#birthday').val(birthday);
        $('#idCard').val(idCard);
        $('#salary').val(salary);
        $('#phone').val(phone);
        $('#email').val(email);
        $('#address').val(address);
        $('#positionId').val(positionId);
        $('#educationId').val(educationId);
        $('#divisionId').val(divisionId);
        $('#userName').val(userName);
    }
</script>
</html>
