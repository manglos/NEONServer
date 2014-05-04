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
        <title>You Didn't Login?</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <h1><%= request.getParameter("un") %> does not exist!</h1>
        Unfortunately, there exists no user in our database under that username.
        <%@include file="footer.jsp" %>
    </body>
</html>
