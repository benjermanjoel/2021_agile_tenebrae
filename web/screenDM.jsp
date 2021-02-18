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

    <!-- Container holding "rows" in webpage for PC, NPC, and table data for spells and items-->
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <!-- List for Player Characters -->
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
                <div class="row">
                    <!-- List for Non-Player Characters -->
                    <h2>Non-Player Characters</h2>
                    <div class="list-group">

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

            <!--Main content of page-->
            <div class="col-md-6 border border-top-0 border-bottom-0">
                <h2>Main content here. My idea was to click on PC or NPC and have info about them appear here.</h2>

            </div>

            <!--Tables to display tools and spells-->
            <div class="col-md-4">
                <!-- TODO: Create and display tables with tools or spells from database-->
                <h2>Insert real database table(s) here</h2>

                <!-- Currently has demo tables placed with fake data -->
                <h3>Items Table</h3>
                <table class="table table-sm table-bordered table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Item</th>
                            <th scope="col">Type</th>
                            <th scope="col">Cost</th>
                            <th scope="col">Weight</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">Abacus</th>
                            <td>Adventuring Gear</td>
                            <td>2 gp</td>
                            <td>2 lb</td>
                        </tr>
                        <tr>
                            <th scope="row">Acid (vial)</th>
                            <td>Adventuring Gear</td>
                            <td>25 gp</td>
                            <td>1 lb</td>
                        </tr>
                        <tr>
                            <th scope="row">Alchemist's fire (flask)</th>
                            <td>Adventuring Gear</td>
                            <td>50 gp</td>
                            <td>1 lb</td>
                        </tr>
                        <tr>
                            <th scope="row">Arrows (20)</th>
                            <td>Ammunition</td>
                            <td>1 gp</td>
                            <td>1 lb</td>
                        </tr>
                        <tr>
                            <th scope="row">Blowgun Needles (20)</th>
                            <td>Ammunition</td>
                            <td>1 gp</td>
                            <td>1 lb</td>
                        </tr>
                    </tbody>
                </table>

                <h3>Spells Table</h3>
                <table class="table table-sm table-bordered table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Spell</th>
                        <th scope="col">Level</th>
                        <th scope="col">School</th>
                        <th scope="col">Casting</th>
                        <th scope="col">Ritual</th>
                        <th scope="col">Concentration</th>
                        <th scope="col">Classes</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Acid Splash</th>
                        <td>Cantrip</td>
                        <td>Conjuration</td>
                        <td>Action</td>
                        <td>No</td>
                        <td>No</td>
                        <td>Sorcerer, Wizard</td>
                    </tr>
                    <tr>
                        <th scope="row">Blade Ward</th>
                        <td>Cantrip</td>
                        <td>Abjuration</td>
                        <td>Action</td>
                        <td>No</td>
                        <td>No</td>
                        <td>Bard,Sorcerer, Warlock, Wizard</td>
                    </tr>
                    <tr>
                        <th scope="row">Chill Touch</th>
                        <td>Cantrip</td>
                        <td>Necromancy</td>
                        <td>Action</td>
                        <td>No</td>
                        <td>No</td>
                        <td>Sorcerer, Warlock, Wizard</td>
                    </tr>
                    <tr>
                        <th scope="row">Dancing Lights</th>
                        <td>Cantrip</td>
                        <td>Evocation</td>
                        <td>Action</td>
                        <td>No</td>
                        <td>Yes</td>
                        <td>Bard, Sorcerer, Wizard</td>
                    </tr>
                    <tr>
                        <th scope="row">Druidcraft</th>
                        <td>Cantrip</td>
                        <td>Transmutation</td>
                        <td>Action</td>
                        <td>No</td>
                        <td>No</td>
                        <td>Druid</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


<!-- Optional JavaScript; Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

<!--Place footer-->
<%@include file="includes/footer.jsp"%>
</body>
</html>
