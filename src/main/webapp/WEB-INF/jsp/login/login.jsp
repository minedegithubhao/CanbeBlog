<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="zh-CN">
<head>
    <%@include file="../common/EasyUiHeader.jsp" %>
    <title>登陆页</title>
    <link rel="stylesheet/less" type="text/css" href="login.less">
</head>
<body>
<div class="container">
    <div id="login_panel" class="easyui-panel">
        <div style="margin-bottom:20px">
            <input id="username" name="username" class="easyui-textbox" prompt="用户名" iconWidth="28" value="admin" style="width:100%;height:34px;padding:10px;">
        </div>
        <div style="margin-bottom:20px">
            <input id="password" name="password" class="easyui-passwordbox" prompt="密码" iconWidth="28" value="123456"
                   style="width:100%;height:34px;padding:10px">
        </div>
        <div class="login-div">
            <button onclick="submit()">登陆</button>
        </div>
    </div>
</div>
<div id="viewer"></div>
<script type="text/javascript">
    function submit(){
        $.ajax({
            url:"${pageContext.request.contextPath}/system/login/Api",
            //调用servlet方法
            // data:"action=jQueryAjax",
            data:{username:"username",password:"password"},
            type:"POST",
            success:function (data) {
                alert("服务器返回的数据是：" + data);
                var jsonObj = JSON.parse(data);
                alert(jsonObj);
            },
            //返回数据的格式
            dataType : "json"
        });
    }
</script>
<style>
    body{
        width: 100%;
        height: 100%;
        background-image: url("${pageContext.request.contextPath}/static/image/background.jpg");
        background-size: cover;
        background-repeat: no-repeat;
    }
    .container{
        height: 100%;
        display: -webkit-flex;
        display: flex;
        justify-content:center;
        align-items:center;
    }
    #login_panel {
        width:400px;padding:50px 60px
    }
    .login-div{
        display: flex;
        justify-content: center;
    }
</style>
</body>
</html>