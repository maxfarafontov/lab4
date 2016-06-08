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
    <legend>Detailed info about distance:</legend>
    <input type="hidden" name="id" id="id" type="text" value="<c:out value="${dist.id}"></c:out>"/>
    <input type="hidden" name="action" id="action" value="saveDist"/>
    <fieldset>

      <div class="pure-control-group">
        <label for="style">Style</label>
        <input id="style" name="style" type="text" value=""
               onchange="check()">
      </div>


      <div class="pure-control-group">
        <label for="dist">Distance</label>
        <input id="dist" name="dist" type="text" value=""
               onchange="check()">
      </div>

      <div class="pure-control-group">
        <label for="distwater">Water Distance</label>
        <input id="distwater" name="distwater" type="text" value=""
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
