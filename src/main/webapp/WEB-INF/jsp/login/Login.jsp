<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css">
    <script src="lib/jquery.min.js"></script>
    <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/Login.js"></script>

</head>
<body>
<div class="bg-img">
    <div class="content">
        <header>登入會員</header>
        <form>
            <div class="field">
                <span class="fa fa-user"></span>
                <input type="text" id="account" required placeholder="Username">
            </div>
            <div class="field space">
                <span class="fa fa-lock"></span>
                <input type="password" id="password" class="pass-key" required placeholder="Password">
            </div>
            <br>
            <div style="text-align:center;">
                <button type="button" style="padding: 15px 50px;background-color: #008CBA;" onclick="login()" value="LOGIN" >登入</button>
            </div>
            <div style="text-align:center;">
                <a href="Register">立即註冊</a>
            </div>
        </form>

    </div>
</div>


</body>
</html>



