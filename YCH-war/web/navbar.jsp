<%-- 
    Document   : navbar
    Created on : Mar 9, 2013, 9:30:04 AM
    Author     : Christopher Manglos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
	<span class="sr-only">Toggle navigation</span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="#">NeoN</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
	<ul class="nav navbar-nav">
	<li class="active"><a href="index.jsp">Home</a></li>
	<li><a href="ProfileControl?un=default&amp;mode=full">My Profile</a></li>
	<li><a href="MeshControl">My Meshes</a></li>
        <li><a href="MeshDesigner">Animations</a></li>
        <li><a href="presets.jsp">Presets</a></li>
        <li><a href="PlaylistControl">Playlists</a></li>
	<li><a href="LeaderBoardControl">Accounts</a></li>
        
	</ul>
	</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
	</nav>
    </body>
</html>
