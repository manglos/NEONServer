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
        <title>You Can Login</title>
        <%! String debug="<br>"; %>
        <% if(request.getParameter("debug")!=null)
            debug = request.getParameter("debug")+"<br>"; %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <h1>Welcome back! Here's to your successful Log-in, good sir or madam!</h1>
            <p class="text-danger"><%= debug %></p>
			<br>
            <form class="form-inline" role="form" action="LogIn" method="POST">
			  <div class="form-group">
				<label class="sr-only" for="exampleInputEmail2">Username</label>
				<input type="text" name="username" class="form-control" id="exampleInputEmail2" placeholder="Enter username">
			  </div>
			  <div class="form-group">
				<label class="sr-only" for="exampleInputPassword2">Password</label>
				<input type="password" name="password" class="form-control" id="exampleInputPassword2" placeholder="Password">
			  </div>
			  <button type="submit" class="btn btn-default">Sign in</button>
			</form>

            
        <%@include file="footer.jsp" %>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
