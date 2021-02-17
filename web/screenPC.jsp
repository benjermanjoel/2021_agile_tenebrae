<%--
  Created by IntelliJ IDEA.
  User: tyler
  Date: 2/17/2021
  Time: 2:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>Dungeon Master's Screen</title>
</head>

<body>
<!--Place navbar-->
<%@include file="includes/navbar.jsp"%>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">DM Campaign Information</h1>
    </div>
</div>

<div class="container">
    <!-- TODO: Display current player stats -->

</div>

<div class="container">
    <div class="col-md-4">
        <!-- TODO: Create and display tables with tools or spells -->

    </div>


</div>

<!-- Optional JavaScript; Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<!--Place footer-->
<%@include file="includes/footer.jsp"%>
</body>
</html>
