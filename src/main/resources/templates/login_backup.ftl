<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>社区系统主页</title>
    <#include "css.ftl" />
    <link rel="stylesheet" href="../static/css/login.css">
</head>

<body style="overflow:hidden;">
    <div class="index_footer">
            <div class="container">
                <h1>轻大校园BBS</h1>
                <p>
                    <p>这是一个集轻大学子学习，招募，交流，分享的社区系统，在这里你可以分享自己生活的点滴，也可以分享学习中的乐趣，</p>
                    <p>也可以查看院系的近期重大事项，也可以在这里发布出售或者购买的帖子...欢迎加入轻大BBS这个大家庭</p>                             
                </p>
                <p class="form_info">
                        <form class="layui-form" action="user/login" method="post">
                                <div class="layui-form-item">
                                        <div class="layui-input-inline">
                                          <input type="text" name="userName" lay-verify="required" placeholder="用户名/username" autocomplete="on" class="layui-input" style="border-radius: 5px;">
                                        </div>

                                        <div class="layui-input-inline">
                                            <input type="password" name="userPwd"  lay-verify="required" placeholder="密码/password" autocomplete="on" class="layui-input" style="border-radius: 5px;">
                                        </div>

                                        <input type="checkbox" name="is_aotulogin" title="下次自动登陆" lay-skin="primary">
                                        <button lay-submit lay-filter="user_login" id="user_login" class="" style="border-radius: 5px;">登录</button>
                                        <button id="user_register" class="" style="border-radius: 5px;" type="button" onclick="register()">注册</button>
                                        <div class="help_info">
                                            <a href="/user/tourist" id="tourist" style="text-decoration:none">游客</a>
                                            <a href="#" id="forget_password"  style="text-decoration:none">忘记密码</a>
                                        </div>
                                </div>                                      
                        </form>
                </p>
            </div>
    </div>
</body>

<#include "js.ftl" />
<script src="../static/layui/layui.js"></script>
<script type="text/javascript">
	function register(){
		window.location.href="/user/toRegister";
	}
</script>


<script type="text/javascript">
    //相当于java的main是layui的入口，使用哪个模块就在下面layui.use方框里写
    layui.use(['layer', 'form', 'jquery'], function () {
        var layer = layui.layer;
        var form = layui.form;
        var $ = layui.jquery;
    });
</script>
</html>