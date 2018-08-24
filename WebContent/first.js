$(document).ready(function() {
	$("#name").focus(function() {
		$("#name").css("background", "#fff");
		$("#name").css("border", "red 1px solid");
	});
	$("#name").blur(function() {
		$("#name").css("background", "rgb(231, 252, 252)");
		$("#name").css("border", "rgb(106, 179, 240) 1px solid");
	});
	$("#password").focus(function() {
		$("#password").css("background", "#fff");
		$("#password").css("border", "red 1px solid");
	});
	$("#password").blur(function() {
		$("#password").css("background", "rgb(231, 252, 252)");
		$("#password").css("border", "rgb(106, 179, 240) 1px solid");
	});

	$(".submitBtn").mouseover(function() {
		$(".submitBtn").css("border", "red 1px solid");
		$(".submitBtn").css("background", "white");
	});
	$(".submitBtn").mouseout(function() {
		$(".submitBtn").css("border", "rgb(106, 179, 240) 1px solid");
		$(".submitBtn").css("background", "rgb(231, 252, 252)");
	});
});