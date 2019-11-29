<div id="Login" style="display: none;">
    <form class="layui-form layui-form-pane">
        <div class="layui-form-item" style="margin: 2% 0 0 5%;">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" id="tourist_userName" lay-verify="required" placeholder="请输入用户名"
                       autocomplete="on" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="margin: 2% 0 0 5%;">
            <label class="layui-form-label">密 码</label>
            <div class="layui-input-inline">
                <input type="password" id="tourist_userPwd" lay-verify="required" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <input lay-submit type="button" style="margin: 2% 0 0 5%;" class="layui-btn" value="登陆" id="login_btn">
    </form>
</div>

<script>
    //游客登录点击事件
    $(".tourist_login").click(function () {
        //自定页
        layer.open({
            title: '登录',
            type: 1,
            skin: 'layui-layer-demo', //样式类名
            anim: 2,
            shade: false,
            area: ['420px', '250px'], //宽高
            content: $('#Login'),
        });
    });

    //登录按钮点击事件
    $("#login_btn").click(function () {
        var userName = $("#tourist_userName").val();
        var pwd = $("#tourist_userPwd").val();
        if (userName === '') {
            layer.msg("用户名不能为空");
            return;
        }
        if (pwd === '') {
            layer.msg("密码不能为空");
            return;
        }
        $.ajax({
            method: 'POST',
            url: '../../user/tourist_login',
            dataType: 'JSON',
            data: {userName: userName, userPwd: pwd},
            async: false,
            cache: false,
            success: function (data) {
                if (data.msg === '验证通过') {
                    layer.msg("登陆成功", {icon: 6});
                    setTimeout(function () {  //使用  setTimeout（）方法设定定时2000毫秒
                        window.location.reload();//页面刷新
                    }, 2000);
                }
                if (data.msg === '未找到该用户') {
                    layer.msg("未找到该用户，请核对", {anim: 6, icon: 5, time: 3000});
                }
                if (data.msg === '密码错误') {
                    layer.msg("密码错误，请重新输入", {anim: 6, icon: 5, time: 3000});
                }
            },
            error: function (data) {
                layer.msg("登陆失败，请查看输入是否有误,若无误请联系管理员！");
            }
        });
    });

</script>