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
  request.setAttribute("users", new Dao().getUsers());
%>
<div class="container">

  <h2 align="center">Table of users</h2>


    <a href="/?action=addUser">
      <button class="pure-button pure-button-primary">Add row</button>
    </a>

    <a id="deleteURL" href="/?action=delete&id=">
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
      <th>FirstName</th>
      <th>LastName</th>
      <th>Email</th>
      <th>Age</th>
      <th>Passport Series</th>
      <th>Passport Number</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="User">
      <tr>
        <td><INPUT type="checkbox" onchange="test(this)" name="chk"/>
          <input type="text" hidden disabled value=<c:out value="${User.id}"/>>
        <td><c:out value="${User.name}"/></td>
        <td><c:out value="${User.surname}"/></td>
        <td><c:out value="${User.email}"/></td>
        <td><c:out value="${User.age}"/></td>
        <td><c:out value="${User.getpassSeries()}"/></td>
        <td><c:out value="${User.getpassNumb()}"/></td>
        <td><a href="/?action=edit&id=<c:out value="${User.id}"></c:out>">
          <button class="pure-button pure-button-primary">Edit</button>
        </a>
      </tr>
    </c:forEach>
    </tbody>
  </table>


</body>
</html>