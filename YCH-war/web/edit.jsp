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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
			<!-- Bootstrap -->
			<link href="css/cyborg.css" rel="stylesheet">

			<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
			<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
			<!--[if lt IE 9]>
				<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
				<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
			<![endif]-->
        
        <%! String debug="<br>"; %>
        <% youcanthide.Player me = (youcanthide.Player)youcanthide.Database.getPlayerByUsername((String)request.getSession().getAttribute("user"));
        System.out.println("edit control: " + me);%>
        <% if(request.getParameter("debug")!=null)
            debug = request.getParameter("debug")+"<br>"; %>
            
            <title>GMP - Edit <%= me.getUsername() %></title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <center>
            <h1>Edit <%= me.getUsername() %>'s Info</h1>
            <%= debug %>
            <br>
            <form action="EditControl" method="POST">
                First Name:<br>
                <INPUT TYPE="TEXT" NAME="firstName" VALUE=<%= me.getFirstName() %>><BR>
                Last Name:<br>
                <INPUT TYPE="TEXT" NAME="lastName" VALUE=<%= me.getLastName() %>><BR>
                Choose Username:<br>
                <INPUT TYPE="TEXT" NAME="userName" VALUE=<%= me.getUsername() %>><BR>
                Choose Password:<br>
                <INPUT TYPE="PASSWORD" NAME="password" VALUE=<%= me.getPassword() %>><BR>
                Re-type Password:<br>
                <INPUT TYPE="PASSWORD" NAME="password-confirm" VALUE=<%= me.getPassword() %>><BR>
                <INPUT TYPE="SUBMIT"><BR>
            </form>
            <br>
            
        </center>
        
        <%@include file="footer.jsp" %>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>

