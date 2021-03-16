<%--
  Created by IntelliJ IDEA.
  User: ben.julian
  Date: 3/1/21
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <%--Javascript--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <!-- Link to our CSS page -->
    <link href="assets/css/screenCSS.css" rel="stylesheet">

    <!-- Google fonts link -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Fondamento&family=Merienda:wght@700&display=swap" rel="stylesheet">


    <title>Delete Character</title>

</head>
<body>
<%@include file="includes/navbar.jsp"%>
<p>
    Enter in the name of a character you would like to delete.
</p>
<div class="container">
    <form action="DeleteCharacter" method="post">
        <div class="col">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <button type="submit" class="btn btn-primary">Delete Character</button>
    </form>
    <h3 style="color: #2373c8">${message}</h3>
</div>
</body>
</html>
