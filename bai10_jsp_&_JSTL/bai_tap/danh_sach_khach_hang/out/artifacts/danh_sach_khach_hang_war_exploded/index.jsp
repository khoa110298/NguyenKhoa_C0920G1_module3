<%@ page import="dao.CustomerDao" %>
<%@ page import="model.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/15/2020
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
  </head>
  <body>
  <%
  request.setAttribute("cus",CustomerDao.listCustomer());
  %>
  <h1 style="text-align: center;color: red">Danh sách khách hàng</h1>
  <table class="table table-striped">
    <thead>
    <tr>
      <th scope="col">tên</th>
      <th scope="col">ngày sinh</th>
      <th scope="col">địa chỉ</th>
      <th scope="col">ảnh</th>
    </tr>
    </thead>
      <tbody>
      <c:forEach items="${cus}" var="customer">
      <tr>
        <td><c:out value="${customer.ten}"/></td>
        <td><c:out value="${customer.ngaySinh}"/></td>
        <td><c:out value="${customer.diaChi}"/></td>
        <td>
          <img src="<c:out value="${customer.img}"/>" style="height: 100px" width="100px">
        </td>
      </tr>
      </c:forEach>
      </tbody>

  </table>




  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
          integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
          integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
  </body>
</html>
