<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Register</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">

        <!-- Link to our CSS page -->
        <link href="assets/css/screenCSS.css" rel="stylesheet">

        <!-- Google fonts link -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Fondamento&family=Merienda:wght@700&display=swap" rel="stylesheet">
        <%@include file="includes/registerValidate.jsp"%>

        <link href="signin.css" rel="stylesheet">
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    </head>
    <body>
        <form class="form-signin" method="post" action="register">
            <label for="firstName">First Name:</label>
            <input class="form-control" id="firstName" name="firstName">
            <br><br>
            <label for="lastName">Last Name:</label>
            <input class="form-control" id="lastName" name="lastName">
            <br><br>
            <label for="email">Email:</label>
            <input class="form-control" id="email" name="email">
            <br><br>
            <label for="password">Password:</label>
            <input class="form-control" type="password" id="password" name="password">
            <button class="btn btn-lg btn-primary btn-block btn btn-dark" type="submit">Register</button>
        </form>
    </body>
</html>