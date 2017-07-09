<html xmlns="http://www.w3.org/1999/xhtml" lang="en"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>充值续费</title>
    <link href="/css/user_center_style.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/layer.css" id="layui_layer_skinlayercss" style=""></head>
<body>
<div class="container">
    <div class="header">
        <div class="logo fl"></div>
        <div class="top-nav fr">
            <ul class="nav1 fl">
                <li><a href="http://green.jxbdzz.com/index.html" class="scroll">首页</a></li>
                <li><a href="http://green.jxbdzz.com/help.html" class="scroll">帮助中心</a></li>
                <li><a href="http://green.jxbdzz.com/contact.html" class="scroll">联系我们</a></li>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <div class="navleft fl">
        <ul class="navlist">
            <li class="isthis"><a href="http://green.jxbdzz.com/ucenter/index.html"><i class="icn1"></i>充值续费</a></li>
            <li><a href="http://green.jxbdzz.com/ucenter/rechargeLogs.html"><i class="icn2"></i>付费记录</a></li>
            <li><a href="http://green.jxbdzz.com/ucenter/changePwd.html"><i class="icn5"></i>修改密码</a></li>
            <li><a href="http://green.jxbdzz.com/logout.html"><i class="icn6"></i>退出登录</a></li>
        </ul>
    </div>
    <div class="right fl">
        <div class="righttop">
            <div class="fl w700">
                <div class="fl"><i><img src="/tpl/green/green.jxbdzz.com/static/ucenter/images/yh.png" class="vm" style="width:20px; margin-right:10px;"></i>用户名：<span class="userspan" id="userids">tutty427</span></div>
                <div class="fl timer"><i><img src="/tpl/green/green.jxbdzz.com/static/ucenter/images/time.png" class="vm" style="width: 20px; margin-right: 10px;"></i>剩余时间：<span class="userspan" id="usertime">00小时56分钟</span></div>
                <div class="fl timer"><i><img src="/tpl/green/green.jxbdzz.com/static/ucenter/images/time.png" class="vm" style="width: 20px; margin-right: 10px;"></i>剩余时间：<span class="userspan" id="usertime">00小时56分钟</span></div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="rightmain">
            <table>
                <tbody>
                <tr>
                    <th>套餐</th>
                    <th>支持网站</th>
                    <th>限制</th>
                    <th>购买</th>
                </tr>
                <tr>
                    <td rowspan="6" style="width: 150px;"> 1</td>
                    <td rowspan="6" style="width: 150px;"> www.taobao.com</td>
                    <td rowspan="6" style="width: 150px;"> 20000 time</td>
                    <td class="h100 bg"><div class="fl pic18"><span class="shiba" id="pricepack0">18</span><span class="shiba1">元/月</span></div>
                        <div class="fl mt13">
                            <div class="fl wx"> <a href="javascript:void(0)" id="paypackwx0" name="paybuttonwx" attrid="b8b54512cf804ef0b0c55925f52c4c65">微信购买</a> </div>
                            <div class="fl zfb"> <a href="javascript:void(0)" id="paypack0" name="paybutton" attrid="b8b54512cf804ef0b0c55925f52c4c65">支付宝购买</a> </div>
                        </div></td>
                </tr>

                </tbody></table>
        </div>
    </div>
    <div class="clear"></div>
</div>
<script src="/js/jquery-1.10.2.min.js"></script>
<script src="/js//layer.min.js"></script>
<script type="text/javascript" src="js/top.js"></script>

<script type="text/javascript">
    function showImg() {
        document.getElementById("tuichu").style.display = 'block';
    }
    function hideImg() {
        document.getElementById("tuichu").style.display = 'none';
    }
</script>
<script type="text/javascript">
    $(function () {
        $.post("http://green.jxbdzz.com/ucenter/price.html",{},function (data) {
            if (data != '' &amp;&amp; data != null) {
                data = JSON.parse(data);
                var settings = data.settings;
                for (var i = 0; i &lt; settings.length; i++) {
                    ///给支付宝和微信按钮的attrid赋值；
                    $("#paypack" + i).attr("attrid", settings[i].packpayid);
                    $("#paypackwx" + i).attr("attrid", settings[i].packpayid);
                    $("#pricepack" + i).text(settings[i].packmoney);
                }
            }
        });
        var fixPayUrl = function (pid,type) {
//            $.ajaxSetup({async : false });
            $.post("http://green.jxbdzz.com/checkLogin.html",{},function (data) {
                if (data != "" &amp;&amp; data != null) {
                    window.location.href ="http://green.jxbdzz.com/ucenter/recharge.html?packid=" + pid + "&amp;type="+type;
                } else {
                    window.location.reload(true);
                }
            });
        };
        $("[name='paybutton']").click(function () {
            var pid = $(this).attr("attrid");
            fixPayUrl(pid,1);
        });
        $("[name='paybuttonwx']").click(function () {
            var pid = $(this).attr("attrid");
            fixPayUrl(pid,2);
        });
    });

</script>
<script type="text/javascript">

</script>

</body></html>