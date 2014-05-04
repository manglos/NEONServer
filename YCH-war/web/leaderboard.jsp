<%-- 
    Document   : leaderboard
    Created on : Mar 7, 2013, 6:40:24 AM
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
        
        <title>GMP - Accounts</title>
        <jsp:useBean id="leader_board" scope="application" class="youcanthide.LeaderBoard" />
        <jsp:setProperty name="leader_board" property="*" />

    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <h1>Current Users</h1>
        
        <table class="table table-striped table-hover " border="0" width="80%">
            <thead>
                <tr>
                    <th><a href="LeaderBoardControl?sortby=username">Username</a></th>
                    <th><a href="LeaderBoardControl?sortby=firstName">First Name</a></th>
                    <th><a href="LeaderBoardControl?sortby=lastName">Last Name</a></th>
                </tr>
            </thead>
            <tbody>
            <% for(youcanthide.Player p : leader_board.getList()){ %>
            <tr><th><a href="ProfileControl?un=<%= p.getUsername() %>"><font color="<%= p.getColor() %>"><%= p.getUsername() %></font></a></th>
                <th><%= p.getFirstName() %></th>
                <th><%= p.getLastName() %></th>
            </tr><% } %>
			</tbody>
            <br>
        </table>
        
        
        <%@include file="footer.jsp" %>
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
