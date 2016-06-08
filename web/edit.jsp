<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css">
        <%@include file='style.css' %>
    </style>
    <script src=js_validators.js></script>
</head>
<body onload="check()">

<div class="container">
    <form action="" class="pure-form pure-form-aligned">
        <legend>Detailed info about user:</legend>
        <input type="hidden" name="id" id="id" type="text" value="<c:out value="${user.id}"></c:out>"/>
        <input type="hidden" name="action" id="action" value="saveUser"/>
        <fieldset>

            <div class="pure-control-group">
                <label for="name">First Name</label>
                <input id="name" name="name" type="text" value=""
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="surname">Last Name</label>
                <input id="surname" name="surname" type="text" value=""
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="email">Email Address</label>
                <input id="email" name="email" type="email" value=""
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="age">Age of user</label>
                <input id="age" name="age" type="text" value=""
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="series">Passport Series</label>
                <input id="series" name="series" type="text" value=""
                       onchange="check()">
            </div>

            <div class="pure-control-group">
                <label for="number">Passport Number</label>
                <input id="number" name="number" type="text" value=""
                       onchange="check()">
            </div>

            <div class="pure-controls">
                <button type="submit" id="submit" disabled class="pure-button pure-button-primary">Submit
                </button>
            </div>

        </fieldset>
    </form>

</div>

</body>
</html>
