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
    <title>Delete Character</title>
    <p>
        Enter in the name of a character you would like to delete.
    </p>
</head>
<body>
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
