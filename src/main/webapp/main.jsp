<%--
  Created by IntelliJ IDEA.
  User: ben.julian
  Date: 2/10/21
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

  <!-- Link to our CSS page -->
  <link href="assets/css/screenCSS.css" rel="stylesheet">

  <!-- Google fonts link -->
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Fondamento&family=Merienda:wght@700&display=swap" rel="stylesheet">


  <title>Dungeon Masters' Uber cool stat tracker!</title>
</head>
<body background="assets/img/background.jpg">
<%@include file="includes/navbar.jsp"%>

  <div class="container">
    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
      <h1 class="display-4" id="headline">Welcome to Tenebrae!</h1>
      <p class="lead">${user.firstName} (${user.email})</p>
      <p>
        Our name "Tenebrae" comes from the latin root for 'darkness' and 'dungeon', a perfect namesake for what
        we as the creators wanted to accomplish. That being, an all-in-one site for tabletop RPG's, specifically focusing on Dungeons & Dragons.
        <br>
        Our vision was summed up in our original mission statement to have a "tool that allows DMs to easily track player stats, quests, and allow for quick rolling of enemies.
        Unlike paper and pencil our product will allow you stay more focused on the game and less on the stats."
        <br><br>
        The links below will help you to get started on using our character creation and viewing your campaign. We hope you enjoy our site!
      </p>
      <br>
    </div>

    <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
      <div class="col">
        <div class="card mb-4 shadow-sm">
          <div class="card-header otherTitleBackground">
            <h4 class="my-0 fw-normal">DM Campaign Screen</h4>
          </div>
          <div class="card-body otherBackground">
            <h1 class="card-title pricing-card-title">View your current DM campaign</h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>If you are a DM, click below to be redirected</li>
              <li>to your current Dungeon Master page,</li>
              <li>to view all the characters that were</li>
              <li>added previously and continue your adventure!</li>
            </ul>
            <a href="./LoadDMServlet"><button type="button" class="w-100 btn btn-lg btn-primary btn-custom">View DM Dashboard</button></a>
          </div>
        </div>
      </div>

      <div class="col">
        <div class="card mb-4 shadow-sm">
          <div class="card-header otherTitleBackground">
            <h4 class="my-0 fw-normal">Get Started</h4>
          </div>
          <div class="card-body otherBackground">
            <h1 class="card-title pricing-card-title">Create a new character</h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>Click below to be linked to</li>
              <li>our character creation page, in</li>
              <li>order to get started on your</li>
              <li>very own campaign today!</li>
            </ul>
            <a href="./addCharacter.jsp"><button type="button" class="w-100 btn btn-lg btn-outline-primary btn-outline-custom">Create your new character</button></a>
          </div>
        </div>
      </div>

      <div class="col">
        <div class="card mb-4 shadow-sm">
          <div class="card-header otherTitleBackground">
            <h4 class="my-0 fw-normal">PC Campaign Screen</h4>
          </div>
          <div class="card-body otherBackground">
            <h1 class="card-title pricing-card-title">View your current PC campaign</h1>
            <ul class="list-unstyled mt-3 mb-4">
              <li>If you are a player, click below to be re-</li>
              <li>directed to your current Player Character</li>
              <li>page, to view your own playable character</li>
              <li>added previously and continue your adventure!</li>
            </ul>
            <a href="./LoadPCServlet"><button type="button" class="w-100 btn btn-lg btn-primary btn-custom">View PC Dashboard</button></a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <p>
    <br><br>
    Official information for Dungeons & Dragons can be found at the <a href="https://dnd.wizards.com/">D&D Homepage</a>.
    <br>
    Additional info can be found at the <a href="https://www.dndbeyond.com/">D&D Beyond Homepage</a>, and also at the
    <a href="https://en.wikipedia.org/wiki/Dungeons_%26_Dragons">Dungeons & Dragons Wikipedia</a>.
  </p>

<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
-->

<div>
  <%@include file="includes/footer.jsp"%>
</div>
</body>
</html>