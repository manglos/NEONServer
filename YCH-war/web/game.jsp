<%-- 
    Document   : needlogin
    Created on : Mar 9, 2013, 9:38:23 AM
    Author     : Christopher Manglos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="banner.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK href="main.css" rel="stylesheet" type="text/css">
        <script src="jquery.js" type="text/javascript"></script>
            
        <title>You Cant Win</title>
        
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <center>
            <h1>Current Game</h1>
        
        <script type="text/javascript">
            window.onload = startInterval;
            function startInterval()
            {
                startTime();
                setInterval("startTime();",3000);
            }

            function startTime()
            {
                $.post("CurrentGameControl",null, 
                function (){
                    $('#current-game').load('currentgame.jsp');
                });
            }
        </script>
    
        <div id="current-game"></div>
        </center>      
        <br>
        <%@include file="footer.jsp" %>
    </body>
</html>
