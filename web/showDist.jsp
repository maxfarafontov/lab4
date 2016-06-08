<%@ page import="DAO.Dao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>DataBase</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style type="text/css">
    <%@include file='style.css' %>
  </style>
  <script src=js_validators.js></script>
</head>
<body>
<%
  request.setAttribute("dist", new Dao().getDistances());
%>
<div class="container">

  <h2 align="center">Table of users</h2>


  <a href="/?action=addDist">
    <button class="pure-button pure-button-primary">Add row</button>
  </a>

  <a id="deleteURL" href="/?action=deleteDist&id=">
    <button class="pure-button pure-button-primary"
            onclick="deleteRow('dataTable')">Delete Row
    </button>
  </a>
</div>
<br>
<table id="dataTable" class="pure-table pure-table-bordered">
  <thead>
  <tr>
    <th></th>
    <th>Дистанция</th>
    <th>Длина воды</th>
    <th>Стиль</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${dist}" var="Dist">
    <tr>
      <td><INPUT type="checkbox" onchange="test(this)" name="chk"/>
        <input type="text" hidden disabled value=<c:out value="${Dist.id}"/>>
      <td><c:out value="${Dist.distance}"/></td>
      <td><c:out value="${Dist.distwater}"/></td>
      <td><c:out value="${Dist.style}"/></td>
      <td><a href="/?action=editDist&id=<c:out value="${Dist.id}"></c:out>">
        <button class="pure-button pure-button-primary">Edit</button>
      </a>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>