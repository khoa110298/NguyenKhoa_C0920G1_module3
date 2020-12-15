<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/15/2020
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Dictionary</title>
    <style>
      input[type=text] {
        width: 300px;
        font-size: 16px;
        border: 2px solid #ccc;
        border-radius: 4px;
        padding: 12px 10px 12px 10px;
      }
      #submit {
        border-radius: 2px;
        padding: 10px 32px;
        font-size: 16px;
      }
    </style>
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form method="post" action="dictionary.jsp">
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search"/>
  </form>
  </body>
</html>
