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

    request.setAttribute("dist", new Dao().getDistances());

    request.setAttribute("comp", new Dao().getCompetition());
%>

<div class="container">

    <h2 align="center">Table of users</h2>

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

            </tr>
        </c:forEach>
        </tbody>
    </table>

<a id="editUser" href="/?action=showUser">
    <button class="pure-button pure-button-primary"> Edit
    </button>
</a>
<br>
<br>
<table id="data_dist" class="pure-table pure-table-bordered">
    <thead>
    <tr>
        <th>Дистанция</th>
        <th>Длина воды</th>
        <th>Стиль</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dist}" var="Dist">
        <tr>
            <td><c:out value="${Dist.distance}"/></td>
            <td><c:out value="${Dist.distwater}"/></td>
            <td><c:out value="${Dist.style}"/></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a id="editDist" href="/?action=showDist">
    <button class="pure-button pure-button-primary"> Edit
    </button>
</a>

<br>
<br>
<table id="data_comp" class="pure-table pure-table-bordered">
    <thead>
    <tr>
        <th>Название соревнования</th>
        <th>Город</th>
        <th>Главный судья</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${comp}" var="Comp">
        <tr>
            <td><c:out value="${Comp.name}"/></td>
            <td><c:out value="${Comp.city}"/></td>
            <td><c:out value="${Comp.ref}"/></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a id="editComp" href="/?action=showComp">
    <button class="pure-button pure-button-primary"> Edit
    </button>
</a>

</body>
</html>