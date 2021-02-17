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

    <!-- Page Headline -->
    <div class="container text-center">
        <div class="jumbotron">
            <h1 class="display-4">DM Campaign Information</h1>
        </div>
    </div>

    <!-- Container holding "rows" in webpage for PC and various Table data -->
    <div class="container">
        <div class="row">
            <!-- List for Player Characters -->
            <div class="col-md-3">
                <h2>Player Characters</h2>
                <div class="list-group">
                    <!-- TODO: input links to PC data for each character -->

                    <!-- Have blank links to player information currently-->
                    <a href="#" class="list-group-item list-group-item-action active">
                        Benja Minn
                    </a>
                    <a href="#" class="list-group-item list-group-item-action">Maat Chu</a>
                    <a href="#" class="list-group-item list-group-item-action">Tie'l Urr</a>

                </div>
            </div>

            <!--Main content of page-->
            <div class="col-md-6">
                <h2>Main content here. My idea was to click on PC or NPC and have info appear here.</h2>

            </div>

            <!--Tables to display tools and spells-->
            <div class="col-md-3">
                <!-- TODO: Create and display tables with tools or spells -->
                <h2>Insert tables</h2>
            </div>
        </div>
        <!-- New row to place NPC data below PC data on webpage -->
        <div class="row">
            <!-- List for Non-Player Characters -->
            <div class="col-md-3">
                <h2>Non-Player Characters</h2>
                <!--TODO: input links to NPC data for each character -->

                <!-- Have blank links to NPC information currently-->
                <a href="#" class="list-group-item list-group-item-action">
                    Jimmy
                </a>
                <a href="#" class="list-group-item list-group-item-action">Bobbert</a>
                <a href="#" class="list-group-item list-group-item-action">Serena</a>

            </div>
        </div>
    </div>


<!-- Optional JavaScript; Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<!--Place footer-->
<%@include file="includes/footer.jsp"%>
</body>
</html>
