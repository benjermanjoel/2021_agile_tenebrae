<%--
  Created by IntelliJ IDEA.
  User: ben.julian
  Date: 2/10/21
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <%-- Link to home page --%>
        <a class="navbar-brand" href="main.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%-- Link to DM Screen --%>
                <li class="nav-item">
                <a class="nav-link" href="LoadDMServlet">DM-Dashboard</a>
                </li>
                <%-- Link to PC Screen --%>
                <li class="nav-item">
                <a class="nav-link" href="LoadPCServlet">PC-Dashboard</a>
                </li>
                <%-- Links to Character options --%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Character Options
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <%-- Link to add character page --%>
                        <li><a class="dropdown-item" href="addCharacter.jsp">Add Character</a></li>
                                <%-- Link to modify a character page --%>
                        <li><a class="dropdown-item" href="modifyCharacter.jsp">Modify Character</a></li>
                            <%-- Link to delete a character page --%>
                        <li><a class="dropdown-item" href="deleteCharacter.jsp">Delete Character</a></li>
                  </ul>
              </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
