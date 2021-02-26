<%--
  Created by IntelliJ IDEA.
  User: tyler
  Date: 2/17/2021
  Time: 2:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- CDN for hosting and using jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link href="assets/css/screenCSS.css" rel="stylesheet">

    <title>Player Character's Screen</title>
</head>

<body>

<!--Place navbar-->
<%@include file="includes/navbar.jsp"%>

<!-- Page Headline -->
<div class="container text-center">
    <div class="jumbotron">
        <h1 class="display-4" id="headline">Player Character Campaign Information</h1>
    </div>
</div>

<!-- Container holding "rows" in webpage for other PC's and table data for spells and items-->
<div class="container">
    <div class="row">
        <div class="col-md-2" id="leftColumn">
            <!-- List for Player Characters -->
            <h2>Player Characters</h2>
            <div class="list-group">
            <c:choose>

                <c:when test="${empty pcList}">
                    <h5>No current Player Characters</h5>
                </c:when>

                <c:otherwise>

                    <c:forEach var="pcList" items="${pcList}">


                            <!-- TODO: Create link to database for character -->
                            <a href="#" class="list-group-item list-group-item-action listOnClickPC">${pcList.name}</a>


                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </div>
        </div>

        <!--Main content of page-->
        <div class="col-md-6 border border-top-0 border-bottom-0">
            <!-- Container to hold and display all Player Character stats (only PC's since it is not the DM's screen) -->
            <div class="dashboardView" id="playerCharacter">
                <div class="row">
                    <div>
                        <table class="table table-bordered">
                            <thead id="pcStatHead">
                            <tr class="table-dark">
                                <th scope="col" colspan="2" id="nameCell">CHARACTER NAME HERE</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">Class:</th>
                                <td id="classCell">Class Here</td>
                            </tr>
                            <tr>
                                <th scope="row">Level:</th>
                                <td id="levelCell">LEVEL HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Race:</th>
                                <td id="raceCell">RACE HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Hit Points:</th>
                                <td id="hpCell">HP HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Armor Class:</th>
                                <td id="armorCell">AC HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Proficiency:</th>
                                <td id="proficiencyCell">PROFICIENCY HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Initiative:</th>
                                <td id="initiativeCell">INITIATIVE HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Speed:</th>
                                <td id="speedCell">SPEED HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Strength:</th>
                                <td id="strengthCell">STR HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Dexterity:</th>
                                <td id="dexterityCell">DEX HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Constitution:</th>
                                <td id="constitutionCell">CON HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Intelligence:</th>
                                <td id="intelligenceCell">INT HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Wisdom:</th>
                                <td id="wisdomCell">WIS HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Charisma:</th>
                                <td id="charismaCell">CHA HERE</td>
                            </tr>
                            <tr>
                                <th scope="row">Background:</th>
                                <td id="backgroundCell">BACKGROUND HERE</td>
                            </tr>
                            </tbody>
                        </table>

                    </div>

                </div>

            </div>



            <!-- When doc is ready, run function-->
            <script>
                $( document ).ready(function() {
                    <!-- When object is clicked run function -->
                    $(".listOnClickPC").click(function() {
                        <!-- Store text of name from clicked object in variable $name -->
                        var $name = $(this).text();
                        <!-- (Ajax runs code in background) Direct Ajax to correct file "ViewPCServlet -->
                        $.ajax('ViewPCServlet',
                            {
                                dataType: 'json',
                                type: 'get',
                                <!-- Data to be sent to servlet to match with the specific character -->
                                data: {name: $name, type: 'PC'},
                                timeout: 500,
                                success: function(data) {
                                    $("#nameCell").text(data.name);
                                    $("#classCell").text(data.char_class);
                                    $("#levelCell").text(data.level);
                                    $("#raceCell").text(data.race);
                                    $("#hpCell").text(data.hitpts);
                                    $("#armorCell").text(data.armor);
                                    $("#proficiencyCell").text(data.proficiency);
                                    $("#initiativeCell").text(data.initiative);
                                    $("#speedCell").text(data.speed);
                                    $("#strengthCell").text(data.strength);
                                    $("#dexterityCell").text(data.dexterity);
                                    $("#constitutionCell").text(data.constitution);
                                    $("#intelligenceCell").text(data.intelligence);
                                    $("#wisdomCell").text(data.wisdom);
                                    $("#charismaCell").text(data.charisma);
                                    $("#backgroundCell").text(data.background);

                                    $("#playerCharacter").show();
                                    <!-- console log for testing -->
                                    console.log(data);
                                }
                            })
                    });
                });
            </script>

        </div>

        <!--Tables to display tools and spells-->
        <div class="col-md-4" id="rightColumn">
            <!-- TODO: Create and display tables with tools or spells from database-->
            <h2>*Insert real database tables here*</h2>

            <!-- Currently has demo tables placed with fake data -->
            <h3>Items Table</h3>
            <table class="table table-sm table-bordered table-striped table-dark">
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
            <table class="table table-sm table-bordered table-striped table-dark">
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
