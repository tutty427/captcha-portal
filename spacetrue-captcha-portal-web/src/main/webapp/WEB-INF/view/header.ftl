<header id="fh5co-header-section" role="header" class="" >
    <div class="container">

        <!-- <div id="fh5co-menu-logo"> -->
        <!-- START #fh5co-logo -->
        <h1 id="fh5co-logo" class="pull-left"><a href="#"><img src="/images/logo_st.png" alt="SpaceTrue"></a></h1>

        <!-- START #fh5co-menu-wrap -->
        <nav id="fh5co-menu-wrap" role="navigation">
            <ul class="sf-menu" id="fh5co-primary-menu">
                <li class="active">
                    <a href="#">Home</a>
                </li>

                <#--<li>-->
                    <#--<a href="#" class="fh5co-sub-ddown">Dropdown</a>-->
                    <#--<ul class="fh5co-sub-menu">-->
                        <#--<li><a href="left-sidebar.html">Left Sidebar</a></li>-->
                        <#--<li><a href="right-sidebar.html">Right Sidebar</a></li>-->
                        <#--<li>-->
                            <#--<a href="#" class="fh5co-sub-ddown">Free HTML5</a>-->
                            <#--<ul class="fh5co-sub-menu">-->
                                <#--<li><a href="#" target="_blank">Build</a></li>-->
                            <#--</ul>-->
                        <#--</li>-->
                        <#--<li><a href="#">CSS3</a></li>-->
                    <#--</ul>-->
                <#--</li>-->
                <#--<li><a href="elements.html">Elements</a></li>-->
                <li><a href="#">Contact</a></li>
                <#if Session.UserName ? exists >
                    <li><a href="#"></a></li>
                <#else>
                    <li><a href="/captcha/toLogin">Sign In</a></li>
                </#if>
            </ul>
        </nav>
        <!-- </div> -->

    </div>
</header>
