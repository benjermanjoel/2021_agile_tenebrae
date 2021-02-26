<%--
  Created by IntelliJ IDEA.
  User: ben.julian
  Date: 2/21/21
  Time: 9:40 PM
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
    <%--Javascript--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <title>Dungeon Masters' Uber cool stat tracker!</title>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Add a new PC</h1>
        <p class = "lead">Enter in all the required fields below to add a new playable or non-playable character!</p>
    </div>
</div>

<%-- Form for adding a new character.--%>
<div class="container">
    <form action="addCharacter" method="post">
        <div class="col">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" aria-placeholder="Frodo Baggins" required>
        </div>
        <div class="col">
            <label for="level">Level</label>
            <select class="form-control" id="level" name="level" required>
                <option selected>Choose...</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15"></option>
                <option value="16"></option>
                <option value="17"></option>
                <option value="18"></option>
                <option value="19"></option>
                <option value="20"></option>
            </select>
        </div>
        <div class="col">
            <label for="char_class">Class</label>
            <select class="form-select" id="char_class" name="class" required>
                <option selected>Choose...</option>
                <option value="1">Barbarian</option>
                <option value="2">Bard</option>
                <option value="3">Blood Hunter</option>
            </select>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="race">Race</label>
                <select class="form-select" id="race" name="race" required>
                    <option selected>Choose...</option>
                    <option value="1">Human</option>
                    <option value="2">Elf</option>
                    <option value="3">Dwarf</option>
                </select>
            </div>
            <div class="col">
                <label  for="hitPts">Hit Points</label>
                <input type="text" class="form-control" id="hitPts" name="hitPts" aria-placeholder="45">
            </div>
            <div class="col">
                <label for="armorClass">Armor Class</label>
                <input type="text" class="form-control" id="armorClass" name="armorClass" aria-placeholder="15">
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="proficiency">Proficiency</label>
                <select class="form-select" id="proficiency" name="proficiency">
                    <option selected>Choose...</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </div>
            <div class="col">
                <label for="initiative">Initiative</label>
                <select class="form-select" id="initiative" name="initiative">
                    <option selected>Choose...</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </div>
            <div class="col">
                <label for="speed">Speed</label>
                <select class="form-select" id="speed" name="speed">
                    <option selected>Choose...</option>
                    <option value="30">30</option>
                    <option value="35">35</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="strength" class="form-label">Strength</label>
            <input type="range" class="form-range" min="8" max="15" id="strength" name="strength" oninput="this.nextElementSibling.value = this.value">
            <output>12</output>
            <br>
            <label for="dexterity" class="form-label">Dexterity</label>
            <input type="range" class="form-range" min="8" max="15" id="dexterity" name="dexterity" oninput="this.nextElementSibling.value = this.value">
            <output>12</output>
            <br>
            <label for="constitution" class="form-label">Constitution</label>
            <input type="range" class="form-range" min="8" max="15" id="constitution" name="constitution" oninput="this.nextElementSibling.value = this.value">
            <output>12</output>
            <br>
            <label for="intelligence" class="form-label">Intelligence</label>
            <input type="range" class="form-range" min="8" max="15" id="intelligence" name="intelligence" oninput="this.nextElementSibling.value = this.value">
            <output>12</output>
            <br>
            <label for="wisdom" class="form-label">Wisdom</label>
            <input type="range" class="form-range" min="8" max="15" id="wisdom" name="wisdom" oninput="this.nextElementSibling.value = this.value">
            <output>12</output>
            <br>
            <label for="charisma" class="form-label">Charisma</label>
            <input type="range" class="form-range" min="8" max="15" id="charisma" name="charisma" oninput="this.nextElementSibling.value = this.value">
            <output>12</output>
        </div>
        <div class="mb-3">
            <label for="background" class="form-label">Background</label>
            <textarea class="form-control" id="background" name="background" rows="3"></textarea>
        </div>
        <div class="col-auto">
            <p>
                <button class="btn btn-secondary btn-sm" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                    Non-playable Character?
                </button>
            </p>
            <div class="collapse" id="collapseExample">
                <label for="type">Type</label>
                <div>
                    <select class="form-select" id="type" name="type">
                        <option selected>Choose...</option>
                        <option value="1">Non-combat NPC</option>
                        <option value="2">Enemy</option>
                    </select>
                </div>
                <div class="form-floating">
                    <textarea class="form-control" placeholder="Enter traits here" id="traits" name="traits"></textarea>
                    <label for="traits">Traits</label>
                </div>
                <div class="mb-3">
                    <label for="backgroundNPC" class="form-label">Background</label>
                    <textarea class="form-control" id="backgroundNPC" name="backgroundNPC" rows="3"></textarea>
                </div>
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Create Character</button>
    </form>
    <h3 style="color: #2373c8">${message}</h3>
</div>


<%@include file="includes/footer.jsp"%>
</body>
</html>
