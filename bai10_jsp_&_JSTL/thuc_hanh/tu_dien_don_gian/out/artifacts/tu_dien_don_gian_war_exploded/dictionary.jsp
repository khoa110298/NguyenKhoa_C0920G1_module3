<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/15/2020
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<%!
    Map<String, String> dic = new HashMap<>();
%>

<%
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");
    dic.put("one","số 1");
    dic.put("two","số 2");
    dic.put("three","số 3");
    dic.put("four","số 4");
    dic.put("five","số 5");
    dic.put("six","số 6");
    dic.put("seven","số 7");
    dic.put("ten","số 10");
    String search = request.getParameter("search");
    String result = dic.get(search);
    if (result != null) {
        out.println("Word: " + search);
        out.println("Result: " + result);
    } else {
        out.println("Not found");
    }
%>
</body>
</html>
