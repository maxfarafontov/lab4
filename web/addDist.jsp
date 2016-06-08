<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Add</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
  <style type="text/css">
    <%@include file='style.css' %>
  </style>
  <script src=js_validators.js></script>
</head>
<body onload="check()">

<div class="container">
  <form action="" class="pure-form pure-form-aligned">
    <legend>Add</legend>
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
        <label for="distwater">Water distance</label>
        <input id="distwater" name="distwater" type="text" value=""
               onchange="check()">
      </div>

      <div class="pure-controls">
        <button type="submit" id="submit" class="pure-button pure-button-primary">Submit
        </button>
      </div>

    </fieldset>
  </form>

</div>

</body>
</html>
