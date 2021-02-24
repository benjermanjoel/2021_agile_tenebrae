<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
  <meta name="generator" content="Jekyll v4.1.1">
  <title>Tenebrae | Login</title>

  <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">

  <!-- Bootstrap core CSS -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>
  <!-- Custom styles for this template -->
  <link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">
<!--
<form class="form-signin" method="post" action="login">
  <img class="mb-4" src="assets/img/dd_ampersand.png" alt="" width="300" height="300">
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

  <label for="email" class="sr-only">Email address</label>
  <input type="email" id="email" class="form-control" placeholder="Email address" required autofocus>

  <label for="password" class="sr-only">Password</label>
  <input type="password" id="password" class="form-control" placeholder="Password" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
</form> -->
  <form class="form-signin" action="login" method="post">
    <img class="mb-4" src="assets/img/dd_ampersand.png" alt="" width="300" height="300">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <label for="email">Email:</label>
    <input class="form-control" id="email" name="email" size=""30/>
    <br><br>
    <label for="password">Password:</label>
    <input class="form-control" type="password" id="password" name="password" size="30" />
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <br>${message}
    <br><br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
  </form>
</body>
</html>
