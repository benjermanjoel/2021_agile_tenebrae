<%--
  Created by IntelliJ IDEA.
  User: wudim
  Date: 2/22/2021
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Tenebrae</title>
  <script
    src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
    crossorigin="anonymous">
  </script>
  <script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js">
  </script>
</head>
<body background="assets/img/background.jpg">
  <div style="text-align: center">
    <h1>Login</h1>
    <form action="login" method="post">
      <label for="email">Email:</label>
      <input id="email" name="email" size=""30/>
      <br><br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" size="30" />
      <br>${message}
      <br><br>
      <button type="submit">Login</button>
    </form>
  </div>
</body>
<%@include file="includes/validate.jsp"%>
</html>
