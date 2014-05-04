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
        <title>You Can't Find</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <h1>Search for a Player</h1>
        <form name="input" action="ProfileControl?mode=full" method="get">
            Username: <input type="TEXT" name="un">
            <input type="SUBMIT" value="Submit"></form>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>