<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Aurora>用户注册</title>
<#include "../css.ftl" />
    <link rel="stylesheet" href="../../static/css/register.css">
</head>
<body>
<div class="form_header">
    <ul class="nav nav-tabs nav-justified navigation">
        <li role="presentation" class="active" id="student"><a href="#">学生</a></li>
        <li role="presentation" id="teacher"><a href="#">教师</a></li>
    </ul>
    <a id="role_detail" data-method="notice">不同角色权限查看</a>
</div>

<div class="form_main">
    <form class="layui-form register_form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label" id="roles_number">学 号</label>
            <div class="layui-input-inline">
                <input type="text" name="userId" required lay-verify="required|userId" placeholder="请输入学号" class="layui-input" id="roles_input"/>
            </div>
        </div>
        <p
                style="color: red; position: fixed; margin-left: 21%; margin-top: -50px;">*注册后不可修改</p>

        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="userName" required lay-verify="required"
                       placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <p
                style="color: red; position: fixed; margin-left: 21%; margin-top: -50px;">*注册后不可修改</p>

        <div class="layui-form-item">
            <label class="layui-form-label">密 码</label>
            <div class="layui-input-inline">
                <input type="password" name="userPwd" required lay-verify="required" placeholder="请输入密码"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="userPhone" required lay-verify="required|userPhone" placeholder="请输入手机号" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">学院</label>
            <div class="layui-input-inline">
                <select name="userCollege" lay-verify="required" required>
                    <option value="">请选择</option>
                    <option value="软件学院">软件学院</option>
                    <option value="政法学院">政法学院</option>
                    <option value="体育学院">体育学院</option>
                    <option value="外国语学院">外国语学院</option>
                    <option value="艺术设计学院">艺术设计学院</option>
                    <option value="机电工程学院">机电工程学院</option>
                    <option value="国际教育学院">国际教育学院</option>
                    <option value="继续教育学院">继续教育学院</option>
                    <option value="马克思主义学院">马克思主义学院</option>
                    <option value="经济与管理学院">经济与管理学院</option>
                    <option value="电子信息工程学院">电子信息工程学院</option>
                    <option value="电气信息工程学院">电气信息工程学院</option>
                    <option value="建筑环境工程学院">建筑环境工程学院</option>
                    <option value="数学与信息科学学院">数学与信息科学学院</option>
                    <option value="能源与动力工程学院">能源与动力工程学院</option>
                    <option value="食品与生物工程学院">食品与生物工程学院</option>
                    <option value="烟草科学与工程学院">烟草科学与工程学院</option>
                    <option value="材料与化学工程学院">材料与化学工程学院</option>
                    <option value="物理与电子工程学院">物理与电子工程学院</option>
                    <option value="计算机与通信工程学院">计算机与通信工程学院</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="position: relative; right: 6%;">
            <label for="problemId" class="layui-form-label" style="width: 120px;">找回密码问题</label>
            <div class="layui-input-inline">
                <select name="problemId" lay-verify="required" required>
                    <option value="">请选择</option>
                    <optgroup label="学生时代" >
                        <option value="1">初中学校的名字</option>
                        <option value="2">高中学校的名字</option>
                        <option value="3">高中班主任名字</option>
                        <option value="4">高中班主任名字</option>
                        <option value="5">印象最深刻的同桌</option>
                    </optgroup>
                    <optgroup label="情感岁月">
                        <option value="6">母亲的姓名</option>
                        <option value="7">父亲的姓名</option>
                        <option value="8">情侣的名字</option>
                        <option value="9">最难忘的日期</option>
                    </optgroup>
                </select>
            </div>
        </div>

        <div class="layui-form-item" style="position: relative; right: 6%;">
            <label class="layui-form-label" style="width: 120px;">问题答案</label>
            <div class="layui-input-inline">
                <input type="text" name="problemAnswer" required
                       lay-verify="required" placeholder="请输入答案" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline"
                 style="position: relative; left: 5%;">
                <input type="radio" name="userSex" value="男" title="男" checked>
                <input type="radio" name="userSex" value="女" title="女">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" style="position: relative; right: 10%;"
                        lay-submit lay-filter="user_register">立即提交
                </button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<#include "../js.ftl" />
<script type="text/javascript">
    $(document).ready(function () {
        $("#teacher").click(function () {
            $(this).addClass("active");
            $("#student").removeClass("active");
            $("#roles_number").text("工 号");
            $("#roles_input").attr("placeholder", "请输入工号");
        });

        $("#student").click(function () {
            $(this).addClass("active");
            $("#teacher").removeClass("active");
            $("#roles_number").text("学 号");
            $("#roles_input").attr("placeholder", "请输入学号");
        });
    });
</script>

<script type="text/javascript">
    //相当于java的main是layui的入口，使用哪个模块就在下面layui.use方框里写
    layui.use(['layer', 'form', 'jquery'], function () {
        var layer = layui.layer;
        var form = layui.form;
        var $ = layui.jquery;
        //弹出层触发
        var active = {
            notice: function () {
                //示范一个公告层
                layer.open({
                    type: 1
                    ,
                    title: false //不显示标题栏
                    ,
                    closeBtn: false
                    ,
                    area: '300px;'
                    ,
                    shade: 0.8
                    ,
                    id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,
                    btn: ['知道了']
                    ,
                    btnAlign: 'c'
                    ,
                    moveType: 1 //拖拽模式，0或者1
                    ,
                    content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"> ①角色有学生和教师两种选择<br>②拥有不同的权限<br>③教师角色需要管理员进行审核<hr>学生:<br>拥有正常的权限，主要包括发帖，删除回复，关注，收藏，查看未读信息等等</br><span style="color:yellow;">不能在学院事务区发帖</span><br>教师:<br>拥有学生的功能之外</br><span style="color:yellow;">可以在学院事务区发帖</span><br></div>'
                    ,
                    success: function (layero) {
                    }
                });
            }
        }
        $('#role_detail').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });

        //表单校验
        form.verify({
            userId: [
                /^[\d]{12}$/
                , '学号长度必须为12位数字'
            ],
            userPhone:[
                /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/
                    ,'请输入正确格式的手机号'
            ],
        });
        //监听提交
        form.on('submit(user_register)', function (data) {
            var confirm_identity = $("#roles_input").attr("placeholder");  //用户判断用户角色是学生还是教师
            var filed = data.field;
            if (confirm_identity === "请输入学号") {
                //如果角色是学生，则传递权限这个属性的值为0，否则值为1
                data.field.permission = 0;
            } else {
                data.field.permission = 1;
            }
            $.ajax({
                method: "POST",
                url: "/user/register",
                data: filed,
                dataType: "JSON",
                cache:false,
                async:false,
                success: function (res) {
                    if ('success'===res) {
                        layer.alert("注册成功",{icon:1});
                        setTimeout(function () {
                            window.location.href="/user/toLogin";
                        },2000);
                        return ;
                    }
                    if('hasUid'===res){
                        if (confirm_identity === "请输入学号") {
                            //如果角色是学生，则传递权限这个属性的值为0，否则值为1
                            layer.alert('学号已存在，请核对学号或者通过点击主页  "忘记密码" 选项进行密码重置',{icon:5});

                        } else {
                            layer.alert('工号已存在，请核对工号或者通过点击主页  "忘记密码" 选项进行密码重置',{icon:5});

                        }
                        return ;
                    }
                    if('hasUname'===res){
                        layer.alert("用户名已存在",{icon:5});
                        return ;
                    }
                    else {
                        layer.alert("添加用户失败，请重试或联系管理员!",{icon:5});
                        return ;
                    }
                },
                error:function () {
                    layer.alert("连接服务器失败，请联系管理员!",{icon:5});
                    return ;
                }

            });
            return false;
        });

    });
</script>
</html>