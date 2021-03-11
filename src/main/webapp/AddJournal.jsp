<%--
  Created by IntelliJ IDEA.
  User: ben.julian
  Date: 3/10/21
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Journal Entry</title>
    <p>
        Add journal entry
    </p>
</head>
<body>
<div class="container">
    <form action="JournalServlet" method="post">
        <div class="col">
            <label for="contents">Journal Entry</label>
            <input type="text" class="form-control" id="contents" name="contents" required>
        </div>
        <button type="submit" class="btn btn-primary">Add Journal Entry</button>
    </form>
    <h3 style="color: #2373c8">${message}</h3>
</div>
</body>
</html>
