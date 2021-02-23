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
    <form class="form-row" action="addCharacter" method="post">
        <div class="col">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" aria-placeholder="Frodo Baggins">
        </div>
        <div class="col">
            <label for="level">Level</label>
            <select class="form-control" id="level">
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
            <select class="form-select" id="char_class">
                <option selected>Choose...</option>
                <option value="1">Barbarian</option>
                <option value="2">Bard</option>
                <option value="3">Blood Hunter</option>
            </select>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="race">Race</label>
                <select class="form-select" id="race">
                    <option selected>Choose...</option>
                    <option value="1">Human</option>
                    <option value="2">Elf</option>
                    <option value="3">Dwarf</option>
                </select>
            </div>
            <div class="col">
                <label  for="hitPts">Hit Points</label>
                <input type="text" class="form-control" id="hitPts" aria-placeholder="45">
            </div>
            <div class="col">
                <label for="armorClass">Armor Class</label>
                <input type="text" class="form-control" id="armorClass" aria-placeholder="15">
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="proficiency">Proficiency</label>
                <select class="form-select" id="proficiency">
                    <option selected>Choose...</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </div>
            <div class="col">
                <label for="initiative">Initiative</label>
                <select class="form-select" id="initiative">
                    <option selected>Choose...</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            </div>
            <div class="col">
                <label for="speed">Speed</label>
                <select class="form-select" id="speed">
                    <option selected>Choose...</option>
                    <option value="1">30</option>
                    <option value="2">35</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="strength" class="form-label">Strength</label>
            <input type="range" class="form-range" min="8" max="15" id="strength" oninput="this.nextElementSibling.value = this.value">
            <output>8</output>
            <br>
            <label for="dexterity" class="form-label">Dexterity</label>
            <input type="range" class="form-range" min="8" max="15" id="dexterity" oninput="this.nextElementSibling.value = this.value">
            <output>8</output>
            <br>
            <label for="constitution" class="form-label">Constitution</label>
            <input type="range" class="form-range" min="8" max="15" id="constitution" oninput="this.nextElementSibling.value = this.value">
            <output>8</output>
            <br>
            <label for="intelligence" class="form-label">Intelligence</label>
            <input type="range" class="form-range" min="8" max="15" id="intelligence" oninput="this.nextElementSibling.value = this.value">
            <output>8</output>
            <br>
            <label for="wisdom" class="form-label">Wisdom</label>
            <input type="range" class="form-range" min="8" max="15" id="wisdom" oninput="this.nextElementSibling.value = this.value">
            <output>8</output>
            <br>
            <label for="charisma" class="form-label">Charisma</label>
            <input type="range" class="form-range" min="8" max="15" id="charisma" oninput="this.nextElementSibling.value = this.value">
            <output>8</output>
        </div>
        <div class="mb-3">
            <label for="background" class="form-label">Background</label>
            <textarea class="form-control" id="background" rows="3"></textarea>
        </div>
        <div class="col-auto">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="npcCheck">
                <label class="form-check-label" for="npcCheck">
                    Non-playable character?
                </label>
            </div>
            <br>
        </div>
        <div class="col">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>


<%@include file="includes/footer.jsp"%>
</body>
</html>
