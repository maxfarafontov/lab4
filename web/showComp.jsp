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
  request.setAttribute("comp", new Dao().getCompetition());
%>
<div class="container">

  <h2 align="center">Table of competition</h2>


  <a href="/?action=addComp">
    <button class="pure-button pure-button-primary">Add row</button>
  </a>

  <a id="deleteURL" href="/?action=deleteComp&id=">
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
    <th>Название соревнования</th>
    <th>Город</th>
    <th>Главный судья</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${comp}" var="Comp">
    <tr>
      <td><INPUT type="checkbox" onchange="test(this)" name="chk"/>
        <input type="text" hidden disabled value=<c:out value="${Comp.id}"/>>
      <td><c:out value="${Comp.name}"/></td>
      <td><c:out value="${Comp.city}"/></td>
      <td><c:out value="${Comp.ref}"/></td>
      <td><a href="/?action=editComp&id=<c:out value="${Comp.id}"></c:out>">
        <button class="pure-button pure-button-primary">Edit</button>
      </a>
    </tr>
  </c:forEach>
  </tbody>
</table>


</body>
</html>