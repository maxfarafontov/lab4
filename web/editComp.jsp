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
    <legend>Detailed info about competition:</legend>
    <input type="hidden" name="id" id="id" type="text" value="<c:out value="${dist.id}"></c:out>"/>
    <input type="hidden" name="action" id="action" value="saveComp"/>
    <fieldset>

      <div class="pure-control-group">
        <label for="name">Name</label>
        <input id="name" name="name" type="text" value=""
               onchange="check()">
      </div>

      <div class="pure-control-group">
        <label for="city">City</label>
        <input id="city" name="city" type="text" value=""
               onchange="check()">
      </div>

      <div class="pure-control-group">
        <label for="ref">Referi</label>
        <input id="ref" name="ref" type="text" value=""
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
