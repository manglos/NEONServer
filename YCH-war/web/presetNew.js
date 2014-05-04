$(document).ready(function() {
	$("#diamonds").click(function() {
		$("#firework").hide();
		$("#diagonal").hide();
		$("#twinkle").hide();
		$("#diamond").show();
		});
		
	$("#fireworks").click(function() {
		$("#diamond").hide();
		$("#diagonal").hide();
		$("#twinkle").hide();
		$("#firework").show();
		});
	
	$("#diagonals").click(function() {
		$("#diamond").hide();
		$("#firework").hide();
		$("#twinkle").hide();
		$("#diagonal").show();
		});	
		
	$("#twinkles").click(function() {
		$("#diamond").hide();
		$("#firework").hide();
		$("#diagonal").hide();
		$("#twinkle").show();
		});
});