<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Авторизация</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style type="text/css">
    <%@include file='style.css' %>
  </style>
  <script src=js_validators.js></script>
</head>

<div class="container">
  <form class="pure-form pure-form-aligned">
    <fieldset>

      <div class="pure-control-group">
        <label for="log">Login</label>
        <input id="log" name="log" type="text" value=""/>
      </div>

      <div class="pure-control-group">
        <label for="pass">Password</label>
        <input id="pass" name="pass" type="password" autocomplete="off" value=""/>
      </div>

      <div class="pure-controls">
        <a id="autor" href="/">
        <button type="submit" id="submit" class="pure-button pure-button-primary">Log in
        </button></a>
      </div>

    </fieldset>
  </form>

</div>
</body>
</html>
