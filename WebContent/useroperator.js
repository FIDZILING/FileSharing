$(document).ready(function() {
	$("#changePass").click(function() {
		$("#section-2").slideToggle("slow");
	});
	$("#oldpass").focus(function() {
		$("#oldpass").css("background", "#fff");
		$("#oldpass").css("border", "red 1px solid");
	});
	$("#oldpass").blur(function() {
		$("#oldpass").css("background", "rgb(231, 252, 252)");
		$("#oldpass").css("border", "rgb(106, 179, 240) 1px solid");
	});
	$("#newpass").focus(function() {
		$("#newpass").css("background", "#fff");
		$("#newpass").css("border", "red 1px solid");
	});
	$("#newpass").blur(function() {
		$("#newpass").css("background", "rgb(231, 252, 252)");
		$("#newpass").css("border", "rgb(106, 179, 240) 1px solid");
		if ($("#newpass").val() == "") {
			$("#showpassnull").show();
		} else {
			$("#showpassnull").hide();
		}
	});
	$("#fileid").focus(function() {
		$("#fileid").css("background", "#fff");
		$("#fileid").css("border", "red 1px solid");
	});
	$("#fileid").blur(function() {
		$("#fileid").css("background", "rgb(231, 252, 252)");
		$("#fileid").css("border", "rgb(106, 179, 240) 1px solid");
	});
	$("#fileid-up").focus(function() {
		$("#fileid-up").css("background", "#fff");
		$("#fileid-up").css("border", "red 1px solid");
	});
	$("#fileid-up").blur(function() {
		$("#fileid-up").css("background", "rgb(231, 252, 252)");
		$("#fileid-up").css("border", "rgb(106, 179, 240) 1px solid");
	});
	$("#fileDes").focus(function() {
		$("#fileDes").css("background", "#fff");
		$("#fileDes").css("border", "red 1px solid");
	});
	$("#fileDes").blur(function() {
		$("#fileDes").css("background", "rgb(231, 252, 252)");
		$("#fileDes").css("border", "rgb(106, 179, 240) 1px solid");
	});
	$("#filePath").focus(function() {
		$("#filePath").css("background", "#fff");
		$("#filePath").css("border", "red 1px solid");
	});
	$("#filePath").blur(function() {
		$("#filePath").css("background", "rgb(231, 252, 252)");
		$("#filePath").css("border", "rgb(106, 179, 240) 1px solid");
	});
	$("#submitBtn-1").mouseover(function() {
		$("#submitBtn-1").css("border", "red 1px solid");
		$("#submitBtn-1").css("background", "white");
	});
	$("#submitBtn-1").mouseout(function() {
		$("#submitBtn-1").css("border", "rgb(106, 179, 240) 1px solid");
		$("#submitBtn-1").css("background", "rgb(231, 252, 252)");
	});
	$("#submitBtn-2").mouseover(function() {
		$("#submitBtn-2").css("border", "red 1px solid");
		$("#submitBtn-2").css("background", "white");
	});
	$("#submitBtn-2").mouseout(function() {
		$("#submitBtn-2").css("border", "rgb(106, 179, 240) 1px solid");
		$("#submitBtn-2").css("background", "rgb(231, 252, 252)");
	});
	$("#submitBtn-3").mouseover(function() {
		$("#submitBtn-3").css("border", "red 1px solid");
		$("#submitBtn-3").css("background", "white");
	});
	$("#submitBtn-3").mouseout(function() {
		$("#submitBtn-3").css("border", "rgb(106, 179, 240) 1px solid");
		$("#submitBtn-3").css("background", "rgb(231, 252, 252)");
	});
	$("#submitBtn-4").mouseover(function() {
		$("#submitBtn-4").css("border", "red 1px solid");
		$("#submitBtn-4").css("background", "white");
	});
	$("#submitBtn-4").mouseout(function() {
		$("#submitBtn-4").css("border", "rgb(106, 179, 240) 1px solid");
		$("#submitBtn-4").css("background", "rgb(231, 252, 252)");
	});
});