$(document).ready(function () {
    $("#username").focus(function () {
        $("#username").css("background", "#fff");
        $("#username").css("border", "red 1px solid");
        if ($("#username").val() == "") {
            $("#usernamehint").slideDown("fast");
            $("#username").css("margin", "0 0 0 10px");
        }
    });
    $("#username").blur(function () {
        $("#username").css("background", "rgb(231, 252, 252)");
        $("#username").css("border", "rgb(106, 179, 240) 1px solid");
        if ($("#username").val() != "") {
            $("#usernamehint").slideUp("fast");
            setTimeout("$('#username').css('margin','0 0 20px 10px')", 200);
        } else {
            $("#usernamehint").html("请输入有效的用户名！");
            $("#usernamehint").slideDown("fast");
            $("#username").css("margin", "0 0 0 10px");
        }
    });
    $("#password").focus(function () {
        $("#password").css("background", "#fff");
        $("#password").css("border", "red 1px solid");
        if ($("#password").val() == "") {
            $("#passwordhint").slideDown("fast");
            $("#password").css("margin", "0 0 0 10px");
        }
    });
    $("#password").blur(function () {
        $("#password").css("background", "rgb(231, 252, 252)");
        $("#password").css("border", "rgb(106, 179, 240) 1px solid");
        if ($("#password").val() != "") {
            $("#passwordhint").slideUp("fast");
            setTimeout("$('#password').css('margin','0 0 20px 10px')", 200);
        } else {
            $("#passwordhint").html("密码不能为空！");
            $("#passwordhint").slideDown("fast");
            $("#password").css("margin", "0 0 0 10px");
        }
    });
    $("#checkpassword").focus(function () {
        $("#checkpassword").css("background", "#fff");
        $("#checkpassword").css("border", "red 1px solid");
        $("#checkpasswordhint").slideUp("fast");
        setTimeout("$('#checkpassword').css('margin','0 0 20px 10px')", 200);

    });
    $("#checkpassword").blur(function () {
        $("#checkpassword").css("background", "rgb(231, 252, 252)");
        $("#checkpassword").css("border", "rgb(106, 179, 240) 1px solid");
        if ($("#checkpassword").val() != $("#password").val()) {
            $("#checkpasswordhint").html("两次密码不一致！");
            $("#checkpasswordhint").slideDown("fast");
            $("#checkpassword").css("margin", "0 0 0 10px");
            $("#checkpasswordhint").css("margin", "0 0 0 200px");
        } else {
            $("#checkpasswordhint").html("success！");
            $("#checkpasswordhint").slideUp("fast");
            setTimeout("$('#checkpassword').css('margin','0 0 20px 10px')", 200);
        }
    });
    $(".submitBtn").mouseover(function () {
        $(".submitBtn").css("border", "red 1px solid");
        $(".submitBtn").css("background", "white");
    });
    $(".submitBtn").mouseout(function () {
        $(".submitBtn").css("border", "rgb(106, 179, 240) 1px solid");
        $(".submitBtn").css("background", "rgb(231, 252, 252)");
    });
});