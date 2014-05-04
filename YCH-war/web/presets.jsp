<%-- 
    Document   : presets
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
			
        <title>Matrix Control</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="presetNew.js"></script>
    </head>
     <body>
        <%@include file="navbar.jsp" %>
        
        <p class="text-warning" align="center">This page provides controls for manipulating the Matrices.<br />
        Please select a button to view default designs:</p>
        
       
            <form align="center">
                <input id="diamonds" name="animation" type="radio"> Diamonds
                <input id="fireworks" name="animation" type="radio"> Fireworks
                <input id="diagonals" name="animation" type="radio"> Diagonals
                <input id="twinkles" name="animation" type="radio"> Twinkling Stars
            </form>
            
        <br />
        <form align="center">
        <p id="diamond" align="center">
            <embed id="D" class="desc" src="diamond72.swf" height="160px" width="320px">
        </p>
        <p id="firework" align="center">
            <embed id="F" class="desc" src="firework16.swf" height="160px" width="320px">
        </p>
        <p id="diagonal" align="center">
            <embed id="Di" class="desc" src="diagonalsT1.swf" height="160px" width="320px">
        </p>
        <p id="twinkle" align="center">
            <embed id="T" class="desc" src="twinkle.swf" height="160px" width="320px">
        </p>
        <a class="btn btn-primary" href="">Send to Matrix</a>
        </form>
        <script>
            document.getElementById("diamond").hidden = true;
            document.getElementById("firework").hidden = true;
            document.getElementById("diagonal").hidden = true;
            document.getElementById("twinkle").hidden = true;
        </script>
        
        <%@include file="footer.jsp" %>
        
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
