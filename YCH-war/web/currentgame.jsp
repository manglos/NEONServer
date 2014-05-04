<%-- 
    Document   : currentgame
    Created on : Mar 14, 2013, 11:56:13 AM
    Author     : montynewman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <table class="game">
            <th width="30%" class="game" valign="top">
            <h2>Currently Players</h2><hr>
                <% for(youcanthide.Player p : youcanthide.CurrentlyPlaying.getList()){ %>
                <p class="game"><a href="ProfileControl?un=<%= p.getUsername() %>"><font color="<%= p.getColor() %>"><%= p.getUsername() %></font></a> : <%= p.getExperience() %>xp<br>
                    <i><%= p.getFirstName() %> <%= p.getLastName() %></i>
                </p><% } %>
            </th>
            <th class="game-alt">
                <center>
                    <h2>Game Zone</h2>
                    <%= new java.util.Date() %><br>
                    <iframe width="500" height="400" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/?ie=UTF8&amp;ll=43.454422,-76.538723&amp;spn=0.006861,0.016512&amp;t=m&amp;z=17&amp;output=embed"></iframe><br /><small></small>
                </center>
            </th>
                
        </table>   
        
    </body>
</html>
