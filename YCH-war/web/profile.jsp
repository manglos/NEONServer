<%-- 
    Document   : profile
    Created on : Mar 7, 2013, 12:23:08 PM
    Author     : Christopher Manglos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="banner.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
			<!-- Bootstrap -->
			<link href="css/cyborg.css" rel="stylesheet">

			<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
			<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
			<!--[if lt IE 9]>
				<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
				<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
			<![endif]-->
        
        <%! String username=null; %>
        <%! youcanthide.Player me=null; %>
        <%! boolean isUser=false; %>
        
        
        <% username = request.getParameter("un"); %>
        <% isUser = (Boolean)request.getAttribute("isuser"); 
            me = (youcanthide.Player)youcanthide.Database.getPlayerByUsername((String)request.getAttribute("user"));
            System.out.println(username + " " + isUser + " " + me);%>      
        
        <title><%= username %>'s Profile Page</title>
        
        
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <% if(isUser)username="Your"; else username+="'s"; %>
        
        
        <h1><%= username %> Profile!</h1>
       
        Username: <%= me.getUsername() %> <% if(isUser){ %><a href="EditControl?un=<%= me.getUsername() %>">edit</a><% } %><br>
        First Name: <%= me.getFirstName() %> <% if(isUser){ %><a href="EditControl?un=<%= me.getUsername() %>">edit</a><% } %><br>
        Last Name: <%= me.getLastName() %> <% if(isUser){ %><a href="EditControl?un=<%= me.getUsername() %>">edit</a><% } %><br>
        
        
        <% if(isUser){ %>
        <br>
        <%= username %> meshes = <%= me.getMeshCount() %>
        <br>
        <br>
        
        
        Logged in <%= me.getLoginCount() %> times. <br>
        
        <a href="LogOut">Log Out</a><% } %>
        
        
        
        <%@include file="footer.jsp" %>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
