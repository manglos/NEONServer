<%-- 
    Document   : gameslist
    Created on : Mar 7, 2013, 6:40:24 AM
    Author     : Christopher Manglos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="banner.jsp" %>
<%@page import= "ws.*" %>
<%@page import= "Utilities.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK href="main.css" rel="stylesheet" type="text/css">
        
        <title>You Cant Game</title>
        
        <script src="jquery.js" type="text/javascript"></script>
    <script src="custom.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <h1>Current Leader Board!</h1>
        
        <table class="Database" border="0" width="80%">
            <thead>
                <tr class="Database"">
                    <th><a class="Database" href="GameControl?sortby=id">ID</a></th>
                    <th><a class="Database" href="GameControl?sortby=location">Location</a></th>
                    <th><a class="Database" href="GameControl?sortby=size">Size</a></th>
                    <th><a class="Database" href="GameControl?sortby=numit">Number of IT</a></th>
                    <th><a class="Database" href="GameControl?sortby=time">Game Time Left</a></th>
                </tr>
            </thead>
            <% for(Game g : Utils.getGamesList()){ %>
            <tr class="Database-alt"><th><a class="Database-alt" href="CurrentGameControl?game=<%= g.getId() %>">Game #<%= g.getId() %></a></th>
                <th><%= g.getLocation() %></th>
                <th><%= g.getSize()%></th>
                <th><%= g.getNumIt() %></th>
                <th><%= g.getTimeLimit() %></th>
            </tr><% } %>
        
            <br>
        </table>
        
        
        <%@include file="footer.jsp" %>
    </body>
</html>

