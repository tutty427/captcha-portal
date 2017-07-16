<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Center</title>
    <link href="/css/user_center_style.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/layer.css" id="layui_layer_skinlayercss" style="">
    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="/js//layer.min.js"></script>
    <script type="text/javascript" src="/js/top.js"></script>
</head>


<div class="container">
    <div class="header">
        <div class="logo fl"><img src="/images/logo_st.png" alt="SpaceTrue" style="width:50px; margin-left:20px;"></div>
        <div class="top-nav fr">
            <ul class="nav1 fl">
                <li><a href="/captcha/index" class="scroll">Home</a></li>
                <li><a href="#" class="scroll">Help</a></li>
                <li><a href="#" class="scroll">Contact us</a></li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <@tiles.insertAttribute name="leftslide" />
    <div class="right fl">
    <@tiles.insertAttribute name="bodytop" />
    <@tiles.insertAttribute name="body" />


    </div>
    <div class="clear"></div>
</div>


</body>
</html>