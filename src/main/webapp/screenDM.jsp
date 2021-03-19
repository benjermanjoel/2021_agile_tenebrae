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
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- CDN for hosting and using jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <!-- Link to our CSS page -->
    <link href="assets/css/screenCSS.css" rel="stylesheet">

    <!-- Google fonts link -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Fondamento&family=Merienda:wght@700&display=swap" rel="stylesheet">

    <title>Dungeon Master's Screen</title>

</head>

<body background="assets/img/background.jpg">

<!--Place navbar-->
<%@include file="includes/navbar.jsp"%>

    <!-- Page Headline -->
    <div class="container text-center">
        <div class="jumbotron">
            <h1 class="display-4" id="headline">DM Campaign Information</h1>
        </div>
    </div>

    <!---------------------------Left column of screen------------------------->

    <!-- Container holding "rows" in webpage for PC, NPC, and table data for spells and items-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2" id="leftColumn">
                <!-- List for Player Characters -->
                <h2 class="columnSpacing">Player Characters</h2>
                <div class="list-group">
                <c:choose>

                    <c:when test="${empty pcList}">
                        <h5>No current Player Characters</h5>
                    </c:when>

                    <c:otherwise>
                        <c:forEach var="pcList" items="${pcList}">

                                <!-- TODO: Create link to database for character -->
                                <a href="#" class="list-group-item list-group-item-action listOnClickPC smallFont">${pcList.name}</a>

                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </div>


                <div class="row">
                    <!-- List for Non-Player Characters -->
                    <h2 class="columnSpacing">Non-Player Characters</h2>
                    <div class="list-group">
                        <c:choose>

                            <c:when test="${empty npcList}">
                                <h5>No current Player Characters</h5>
                            </c:when>

                            <c:otherwise>

                                <c:forEach var="npcList" items="${npcList}">


                                        <!-- TODO: Create link to database for character -->
                                        <a href="#" class="list-group-item list-group-item-action listOnClickNPC">${npcList.name}</a>


                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>

                <div>
                    <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#journalModal">New Journal Entry</button>

                    <div id="journalModal" class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">New Journal Entry</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="form-group">
                                            <label for="contents" class="col-form-label">Entry</label>
                                            <textarea class="form-control" id="contents"></textarea>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-dark" onclick="entrySubmit()">Add Entry</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <button type="button" class="btn btn-dark" onclick="getJournal">View Journal</button>
                </div>

                <script>
                    function entrySubmit(){
                        $.ajax({
                            url : 'JournalServlet',
                            type: 'POST',
                            data: {
                                contents: $('#contents').val()
                            }
                        });
                        jQuery.noConflict();
                        $('#journalModal').modal('hide');
                    }
                </script>
            </div>

            <!---------------------------Main content of page------------------------->

            <div class="col-md-6 border border-top-0 border-bottom-0">
                <!-- Container to hold and display all Player Character stats (to be switched with nonPlayerCharacter on click) -->
                <div class="dashboardView" id="playerCharacter">
                    <div class="row">
                        <div>
                            <table style="width: 100%" class="table table-bordered smallFont">
                                <thead id="pcStatHead">
                                    <tr class="table-dark">
                                        <th style="text-align: center" scope="col" colspan="2" id="nameCell">CHARACTER NAME HERE</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="width: 17%" scope="row">Class:</th>
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

                <!-- Container to hold and display all Non-Player Character stats (to be switched with playerCharacter on click) -->
                <div class="dashboardView" id="nonPlayerCharacter">

                    <div class="row">
                        <div>
                            <table style="width: 100%" class="table table-bordered smallFont">
                                <thead id="npcStatHead">
                                <tr class="table-dark">
                                    <th style="text-align: center" scope="col" colspan="2" id="npcNameCell">CHARACTER NAME HERE</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th style="width: 17%" scope="row">Type:</th>
                                    <td id="npcTypeCell">TYPE HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Class:</th>
                                    <td id="npcClassCell">CLASS HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Level:</th>
                                    <td id="npcLevelCell">LEVEL HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Race:</th>
                                    <td id="npcRaceCell">RACE HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Hit Points:</th>
                                    <td id="npcHpCell">HP HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Armor Class:</th>
                                    <td id="npcArmorCell">AC HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Proficiency:</th>
                                    <td id="npcProficiencyCell">PROFICIENCY HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Initiative:</th>
                                    <td id="npcInitiativeCell">INITIATIVE HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Speed:</th>
                                    <td id="npcSpeedCell">SPEED HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Strength:</th>
                                    <td id="npcStrengthCell">STR HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Dexterity:</th>
                                    <td id="npcDexterityCell">DEX HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Constitution:</th>
                                    <td id="npcConstitutionCell">CON HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Intelligence:</th>
                                    <td id="npcIntelligenceCell">INT HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Wisdom:</th>
                                    <td id="npcWisdomCell">WIS HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Charisma:</th>
                                    <td id="npcCharismaCell">CHA HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Location:</th>
                                    <td id="npcLocationCell">LOCATION HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Traits:</th>
                                    <td id="npcTraitsCell">TRAITS HERE</td>
                                </tr>
                                <tr>
                                    <th scope="row">Background:</th>
                                    <td id="npcBackgroundCell">BACKGROUND HERE</td>
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
                                    timeout: 1000,
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
                                        $("#nonPlayerCharacter").hide();
                                        <!-- console log for testing -->
                                        console.log(data);
                                    }
                                })
                        });
                        <!-- When object is clicked run function -->
                        $(".listOnClickNPC").click(function() {
                            <!-- Store text of name from clicked object in variable $name -->
                            var $name = $(this).text();
                            <!-- (Ajax runs code in background) Direct Ajax to correct file "ViewNPCServlet -->
                            $.ajax('ViewPCServlet',
                                {
                                    dataType: 'json',
                                    type: 'get',
                                    <!-- Data to be sent to servlet to match with the specific character -->
                                    data: {name: $name, type: 'NPC'},
                                    timeout: 1000,
                                    success: function(data) {
                                        $("#npcNameCell").text(data.name);
                                        $("#npcTypeCell").text(data.type);
                                        $("#npcClassCell").text(data.char_class);
                                        $("#npcLevelCell").text(data.level);
                                        $("#npcRaceCell").text(data.race);
                                        $("#npcHpCell").text(data.hitpts);
                                        $("#npcArmorCell").text(data.armor);
                                        $("#npcProficiencyCell").text(data.proficiency);
                                        $("#npcInitiativeCell").text(data.initiative);
                                        $("#npcSpeedCell").text(data.speed);
                                        $("#npcStrengthCell").text(data.strength);
                                        $("#npcDexterityCell").text(data.dexterity);
                                        $("#npcConstitutionCell").text(data.constitution);
                                        $("#npcIntelligenceCell").text(data.intelligence);
                                        $("#npcWisdomCell").text(data.wisdom);
                                        $("#npcCharismaCell").text(data.charisma);
                                        $("#npcLocationCell").text(data.location);
                                        $("#npcTraitsCell").text(data.traits);
                                        $("#npcBackgroundCell").text(data.background);

                                        $("#playerCharacter").hide();
                                        $("#nonPlayerCharacter").show();
                                        <!-- console log for testing -->
                                        console.log(data);
                                    }
                                })
                        });
                     });
                </script>

            </div>

            <!---------------------------Right column of screen------------------------->

            <div class="col-md-4" id="rightColumn">

                <!--Table to display weapons-->
                <h2 class="columnSpacing">Weapons Table</h2>
                <div class="list-group" id="weaponTable">
                    <c:choose>
                        <c:when test="${empty weaponList}">
                            <h5>Weapon table is currently empty.</h5>
                        </c:when>
                        <c:otherwise>
                            <table class="table table-sm table-bordered table-striped table-dark table-hover smallFont">
                                <thead>
                                <tr>
                                    <th scope="col">Name</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Cost</th>
                                    <th scope="col">Damage</th>
                                    <th scope="col">Weight</th>
                                    <th scope="col">Properties</th>
                                </tr>
                                </thead>
                                <c:forEach var="weaponList" items="${weaponList}">
                                    <tbody>
                                    <tr>
                                        <th scope="row">${weaponList.name}</th>
                                        <td>${weaponList.type}</td>
                                        <td>${weaponList.cost}</td>
                                        <td>${weaponList.damage}</td>
                                        <td>${weaponList.weight}</td>
                                        <td>${weaponList.properties}</td>
                                    </tr>
                                    </tbody>
                                </c:forEach>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </div>

                <!--Table to display spells-->
                <h2 class="columnSpacing">Spells Table</h2>
                <div class="list-group" id="spellTable">
                    <c:choose>
                        <c:when test="${empty spellList}">
                            <h5>Spell table is currently empty.</h5>
                        </c:when>
                        <c:otherwise>
                            <table class="table table-sm table-bordered table-striped table-dark table-hover smallFont">
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
                                <c:forEach var="spellList" items="${spellList}">
                                    <tbody>
                                    <tr>
                                        <th scope="row">${spellList.name}</th>
                                        <td>${spellList.level}</td>
                                        <td>${spellList.school}</td>
                                        <td>${spellList.casting}</td>
                                        <td>${spellList.ritual}</td>
                                        <td>${spellList.concentration}</td>
                                        <td>${spellList.classes}</td>
                                    </tr>
                                    </tbody>
                                </c:forEach>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </div>

                <!--Table to display tools-->
                <h2 class="columnSpacing">Items Table</h2>
                <div class="list-group" id="itemTable">
                    <c:choose>
                        <c:when test="${empty itemList}">
                            <h5>Item table is currently empty.</h5>
                        </c:when>
                        <c:otherwise>
                            <table class="table table-sm table-bordered table-striped table-dark table-hover smallFont">
                                <thead>
                                <tr>
                                    <th scope="col">Item</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Cost</th>
                                    <th scope="col">Weight</th>
                                </tr>
                                </thead>
                                <c:forEach var="itemList" items="${itemList}">
                                    <tbody>
                                    <tr>
                                        <th scope="row">${itemList.name}</th>
                                        <td>${itemList.type}</td>
                                        <td>${itemList.cost}</td>
                                        <td>${itemList.weight}</td>
                                    </tr>
                                    </tbody>
                                </c:forEach>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>


<!--Place footer-->
<%@include file="includes/footer.jsp"%>
</body>
</html>
