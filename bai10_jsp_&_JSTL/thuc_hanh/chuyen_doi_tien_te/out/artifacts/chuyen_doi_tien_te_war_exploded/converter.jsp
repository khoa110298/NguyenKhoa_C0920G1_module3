<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/15/2020
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>convert</title>
</head>
<body>
<%
    float rate = Float.parseFloat(request.getParameter("rate"));
    float usd = Float.parseFloat(request.getParameter("usd"));
    float vnd = rate * usd;
    out.println(vnd);
%>
<%--<h1>Rate: <%=rate%></h1>--%>
<%--<h1>USD: <%=usd%></h1>--%>
<%--<h1>VND: <%=vnd%></h1>--%>
</body>
</html>
