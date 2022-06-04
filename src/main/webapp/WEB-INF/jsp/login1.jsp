<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- 引入JQuery -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.10.4/jquery.min.js"></script>
	<!-- 引入EasyUI -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.10.4/jquery.easyui.min.js"></script>
	<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-easyui-1.10.4/locale/easyui-lang-zh_CN.js"></script>
	<!-- 引入EasyUI的样式文件-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.10.4/themes/default/easyui.css" type="text/css"/>
	<!-- 引入EasyUI的图标样式文件-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/jquery-easyui-1.10.4/themes/icon.css" type="text/css"/>
    <title>登陆页</title>
</head>
<body>
<div class="main">
    <div class="header hide"> 管理系统</div>
    <div class="content">
        <div class="title hide">管理系统登录</div>
        <form name="login" action="#" method="post">
            <fieldset>
                <!--USERNAME -->
                <div>
                    <div class="input">
                        <input class="input_all name" name="name" id="username" placeholder="用户名" type="text"
                               onFocus="this.className='input_all name_now';"
                               onBlur="this.className='input_all name'" maxLength="24"/>
                    </div>
                    <div id="username_span" style="display:none;padding-bottom:7px;">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="userspan"></span>
                    </div>
                </div>
                <!-- PASSWORD -->
                <div>
                    <div class="input">
                        <input class="input_all password" name="password" id="password" type="password"
                               placeholder="密码" onFocus="this.className='input_all password_now';"
                               onBlur="this.className='input_all password'" maxLength="24"/>
                    </div>

                    <div id="password_span" style="display:none;margin:0 0 0 0;padding:0 0 0 0;">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="passwordspan"></span>
                    </div>
                </div>
                <!-- REMEMBERME -->
                <div class="checkbox">
                    <input type="checkbox" name="remember" id="remember" checked="checked"/>
                    <label for="remember">
                        <span>记住密码</span>
                    </label>
                    <span id="errorspan" style="margin-left:88px;"></span>
                </div>
                <div>
                    <a href="#" id="login" class="button hide">登录</a>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/login/placeholder.js"></script>
</body>
</html>