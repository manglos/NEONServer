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
        <title>You Don't Exist</title>
        <%! String debug="<br>"; %>
        <% if(request.getParameter("debug")!=null)
            debug = request.getParameter("debug")+"<br>"; %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <h1>New User Sign-In</h1>
            
        <div class="row">
			<div class="col-md-8">
			<p class="text-danger"><%= debug %></p>
			<br>
            <form class="form-horizontal" role="form" action="NewPlayer" method="POST">
			  <div class="form-group">
				<label for="firstName" class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-10">
				  <input type="text" NAME="firstName" class="form-control" id="firstName" placeholder="First name">
				</div>
			  </div>
			  <div class="form-group">
				<label for="lastName" class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-10">
				  <input type="text" NAME="lastName" class="form-control" id="lastName" placeholder="Last name">
				</div>
			  </div>
			  <div class="form-group">
				<label for="userName" class="col-sm-2 control-label">Pick a username</label>
				<div class="col-sm-10">
				  <input type="text" NAME="userName" class="form-control" id="userName" placeholder="Username">
				</div>
			  </div>
			  <div class="form-group">
				<label for="password" class="col-sm-2 control-label">Choose a password</label>
				<div class="col-sm-10">
				  <input type="password" NAME="password" class="form-control" id="password" placeholder="Password">
				</div>
			  </div>
			  <div class="form-group">
				<label for="password-confirm" class="col-sm-2 control-label">Confirm Password</label>
				<div class="col-sm-10">
				  <input type="password" NAME="password-confirm" class="form-control" id="password-confirm" placeholder="Re-type Password">
				</div>
			  </div>
			  <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				  <button type="submit" class="btn btn-default">Sign in</button>
				</div>
			  </div>
			</form>
			</div></div>
			
        
        <%@include file="footer.jsp" %>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
