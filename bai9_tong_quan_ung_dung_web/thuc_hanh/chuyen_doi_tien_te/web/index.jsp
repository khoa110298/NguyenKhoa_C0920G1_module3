<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/15/2020
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
  </head>
  <body>

  <h2>Currency Converter</h2>
  <form method="post" action="/convert">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
  </form>
    </tbody>
  </table>



  <script src="jquery/jquery-3.5.1.min.js"></script>
  <script src="datatables/js/jquery.dataTables.min.js"></script>
  <script src="datatables/js/dataTables.bootstrap4.min.js"></script>
  <script src="bootstrap413/js/bootstrap.js"></script>
  <script src="bootstrap413/js/bootstrap.bundle.js"></script>
  </body>
</html>
