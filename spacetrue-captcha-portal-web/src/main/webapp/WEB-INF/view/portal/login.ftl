<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/css/boostrap.min.css">
    <link rel="stylesheet" href="/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/form-elements.css">
    <link rel="stylesheet" href="/css/login_style.css">



</head>

<body>
<video class="bg-vido" autoplay="" loop="" style="background-image:url(>)"><source src="/images/bg.mp4" type="video/mp4"></video>
<!-- Top content -->
<div class="top-content" >
    <div class="inner-bg" >
        <div class="container">
            <#--<div class="row">-->
                <#--<div class="col-sm-8 col-sm-offset-2 text">-->
                    <#--<h1><strong>Bootstrap</strong> Login Form</h1>-->
                    <#--<div class="description">-->
                        <#--<p>-->
                            <#--This is a free responsive login form made with Bootstrap.-->
                            <#--Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!-->
                        <#--</p>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to our site</h3>
                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/captcha/toCenter" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="form-username" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="form-password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">Sign in!</button>
                        </form>
                    </div>
                </div>
            </div>
            <#--<div class="row">-->
                <#--<div class="col-sm-6 col-sm-offset-3 social-login">-->
                    <#--<h3>...or login with:</h3>-->
                    <#--<div class="social-login-buttons">-->
                        <#--<a class="btn btn-link-1 btn-link-1-facebook" href="#">-->
                            <#--<i class="fa fa-facebook"></i> Facebook-->
                        <#--</a>-->
                        <#--<a class="btn btn-link-1 btn-link-1-twitter" href="#">-->
                            <#--<i class="fa fa-twitter"></i> Twitter-->
                        <#--</a>-->
                        <#--<a class="btn btn-link-1 btn-link-1-google-plus" href="#">-->
                            <#--<i class="fa fa-google-plus"></i> Google Plus-->
                        <#--</a>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        </div>
    </div>

</div>


<!-- Javascript -->
<script src="/js/jquery-1.10.2.min.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/jquery.backstretch.js"></script>
<script src="/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="/js/placeholder.js"></script>
<![endif]-->

</body>

</html>