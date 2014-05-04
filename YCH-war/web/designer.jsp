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
        <title>Animation Designer</title>
        
        <%! java.util.ArrayList<String[][]> frames = new java.util.ArrayList<String[][]>(); %>
        <%! int currentX = 1; %>
        <%! int currentY = 1; %>
        <%! String[][] currentFrame = new String[16][32]; %>
        <%! int cf = 0; %>
        <% frames.add(currentFrame); %>
        
        
        
        <link rel="stylesheet" href="style/farbtastic/farbtastic.css" type="text/css" />
        <script src="style/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="style/farbtastic/farbtastic.js"></script>
        <script type="text/javascript">
          $(document).ready(function() {
                $('#colorpicker').farbtastic('#color');
          });
        </script>
	
    
        <%! String username=null; %>
        
        <%! youcanthide.Player me=null; %>
        <%! boolean isUser=false; %>
        <%! String debug="<br>"; %>
        <% if(request.getParameter("debug")!=null)
            debug = request.getParameter("debug")+"<br>"; %>
        
        <% username = (String)request.getSession().getAttribute("user"); %>
        <%  me = (youcanthide.Player)youcanthide.Database.getPlayerByUsername(username);
            System.out.println(username + " : " + me);%>      
            
        
        <title><%= username %>'s Animation Designer</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-6">
                <h3>Animation Designer</h3>
                <p class="text-success">Design your own animation, frame by frame.<br>
                    
                <% if(me.getSequenceNames().size()>0){
                    %>Your Saved Animations:
                    <select>
                    <% for(String s : (java.util.ArrayList<String>)me.getSequenceNames()){
                        %><option value="<%= s %>"><%=s%></option>
                        
                    <%}%></select><%}%></p>
                
            </div>
            <div class="col-md-5"></div>
        </div>
        
        <div class="row">
            <div class="col-md-1"></div>
            <div id="main" class="col-md-6">
                 
                    <svg width="640" height="320" style="border:1px solid lightslategrey; color:sienna;">
                        <defs>
                            <pattern id="grid" width="20" height="20" patternUnits="userSpaceOnUse">
                                <path d="M 0 0 L 0 20 640 20" fill="none" stroke="gray" stroke-width="0.5"/>
                            </pattern>
                        </defs>
                        <rect width="640" height="320" fill="url(#grid)" />
			<% for(int i=0;i<32;i++){
                            String cx=""+(10+(20*i));
                            String rx=""+(20*i);
                            for(int j=0;j<16;j++){ 
                                String cy=""+(10+(20*j));
                                String ry=""+(20*j);
                                String idd = "("+(i+1)+","+(j+1)+")";%>
                                <circle id="<%= idd %>" cx="<%= cx %>" cy="<%= cy %>" r="8" stroke="lawngreen" stroke-width="1" fill="none" />
                                <rect x="<%= rx %>" y="<%= ry %>" style="fill-opacity:0.0;" width="20" height="20" onclick="setPointById(<%= (i+1) %>, <%= (j+1) %>, document.getElementById('color').value)" />
                        <%}}%>
                  </svg>
                <!--<div id="buttonholder1" style="margin-left:7%;">
                        <button class="btn-danger" onclick="setColor('red');">Red</button>
                        <button onclick="setColor('green');">Green</button>
                        <button onclick="setColor('blue');">Blue</button>
                </div>-->
                <div class="row">
                    <div class="col-md-3">
                        <button class="btn btn-primary" id="prev" onClick="prevFrame();"><<<</button>
                    </div>
                    <div class="col-md-3" align="center">
                        <h3 class="text-warning"><label id="frameNum">0</label></h3>
                    </div>
                    <div align="right" class="col-md-3">
                        <button class="btn btn-primary" id="next" onClick="nextFrame();">>>></button>
                    </div>
                </div>
                
                    <br>
                <br>
                <button class="btn btn-default" onclick="selectAll('transparent');">Clear</button>
                <!--<button onclick="setPoint(document.getElementById('xPos').value, document.getElementById('yPos').value, document.getElementById('color').value);">Set Point</button>-->
                <!--<form>
                    <input type="text" id="xPos" name="xPos" value="2" />
                    <input type="text" id="yPos" name="yPos" value="6" />
                </form>-->
                <button class="btn btn-default" onclick="selectAll(document.getElementById('color').value);">Set All</button>
                <!--<button onclick="blink();">Blink All LEDs (Using Colorwheel)</button>
                <button onclick="animate();">Basic Animation (Using Colorwheel)</button>-->
                <button class="btn btn-default" onclick="save();">Save</button>
                <br><br><br><br><br><br>
                <input type="hidden" id="hidden_array" name="hiddenArray" >
                <p class="text-success"><%= debug %></p>
                <br>
                <form id="messageform" class="form-horizontal" role="form" action="GetMessage" method="POST">
                    <div class="form-group">
                          <label for="message">Custom Message</label>
                          <div class="col-sm-8">
                            <input type="text" NAME="message" class="form-control" id="message" placeholder="Enter Custom Message">
                          </div>
                          <div class="col-sm-2">
                            <input type="text" NAME="time" class="form-control" id="time" placeholder="30">
                          </div>
                    </div>
                    <div class="form-group">
                          <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Send Message</button>
                          </div>
                    </div>
                  </form>
                </div>
                
         <div class="col-md-3">
                <form><input type="text" id="color" name="color" value="#ff0000" style="margin-left:20%;" /></form>
                <div id="colorpicker" class="col-md-4" style="margin-left:20%;"></div>
         </div>
	 <div class="col-md-2"></div>
         </div>
            
        <%@include file="footer.jsp" %>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- <script src="https://code.jquery.com/jquery.js"></script> -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    </body>
    <script>
            var iMax = 16;
            var jMax = 32;
            var cFrameStrings = new Array();
            var frames = new Array();
            var currentIndex=0;
            
            for(i=0;i<iMax;i++){
                cFrameStrings[i]=new Array();
                for(j=0;j<jMax;j++){
                    cFrameStrings[i][j]="#000000";
                }
            }
            
            frames[0] = cFrameStrings;
            
            
            
            function eraseFrame(){
                for(i=0;i<iMax;i++){
                    //frameStrings[i]=new Array();
                    for(j=0;j<jMax;j++){
                        cFrameStrings[i][j]="#000000";
                    }
                }
            }
            
            function paintCurrentFrame(){
                for(i=0;i<iMax;i++){
                    for(j=0;j<jMax;j++){
                        document.getElementById("("+(j+1)+","+ (i+1) +")").style.fill = cFrameStrings[i][j];
                    }
                }
            }
            
            function nextFrame(){
                //alert(frames.length + " : " + currentIndex);
                frames[currentIndex] = cFrameStrings;
                
                
                if(frames.length>currentIndex+1){
                    cFrameStrings = frames[currentIndex+1];
                }
                else{
                    cFrameStrings = new Array();
                    for(i=0;i<iMax;i++){
                        cFrameStrings[i]=new Array();
                        for(j=0;j<jMax;j++){
                            cFrameStrings[i][j]="#000000";
                        }
                    }
                }
                    
                currentIndex+=1;
                
                
                document.getElementById("frameNum").innerHTML = "" + currentIndex;
                paintCurrentFrame();
                    
            }
            
            
            function prevFrame(){
                
                //alert(frames.length + " : " + currentIndex);
                frames[currentIndex] = cFrameStrings;
                
                if(currentIndex>0){
                    cFrameStrings = frames[currentIndex-1];
                    currentIndex-=1;
                }
        
                document.getElementById("frameNum").innerHTML = "" + currentIndex;
                paintCurrentFrame();
                    
            }
            
            function blink(){
                x =1;
                setInterval(change, 1000);
            }
    	
            function blink1(){
                x =1;
                setInterval(change, 1000);
            }
		
            function change(){
                if (x === 1) {
                    color = selectAll(document.getElementById('color').value);
                    x = 2;
                } else {
                    color = "transparent";
                    x = 1;
                }
                selectAll(color);
            }

            function setPoint(x, y, color){
                document.getElementById("("+x+","+ y +")").style.fill = color;
            }
	
            function setColor(color){
                document.getElementById("(1,1)").style.fill = color;
                document.getElementById("(2,3)").style.fill = color;
                document.getElementById("(6,2)").style.fill = color;
                document.getElementById("(2,7)").style.fill = color;
                document.getElementById("(7,6)").style.fill = color;
                document.getElementById("(10,6)").style.fill = color;
            }
		
            function getColumn(x, color){

                for(var i=0;i<16;i++){
                    document.getElementById("("+x+","+(i+1)+")").style.fill = color;
                }
            }
		
            function selectAll(color){
                
                for(var j=0;j<32;j++){
                    for(var i=0;i<16;i++){
                        document.getElementById("("+(j+1)+","+(i+1)+")").style.fill = color;
                    }
                }
            }
            
            function setPointById(x, y, color){
                //alert(frames);
                //alert((x-1) + " " + (y-1));
                if(cFrameStrings[y-1][x-1]==color){
                    cFrameStrings[y-1][x-1]='#000000';
                    document.getElementById("("+x+","+ y +")").style.fill = '#000000';
                }
                else{
                    cFrameStrings[y-1][x-1]=color;
                    document.getElementById("("+x+","+ y +")").style.fill = color;
                }
            }
            
            function save(){
                var sequenceName = prompt("Enter a name for this Animation", "");
                var pw = prompt("Confirm Your Account Password", "");
                
                
                
                if(sequenceName!=null){
                    
                    $.ajax({
                        url:"MeshDesigner",
                        type:"POST",
                        dataType:'json',
                        data: {json : JSON.stringify(frames), name : sequenceName, password : pw},
                        success:function(data){
                            // codes....
                            alert('Success');
                        },
                              

                    });
                }
                else
                    alert("Must enter a name to save.");
            }
            
            

        </script>
</html>
