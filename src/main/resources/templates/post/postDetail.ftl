<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/postDetail.css">
<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../static/layui/layui.js"></script>
<body style="background-color: whitesmoke;">
<div id="index_header">
    <div id="header_logo"></div>
    <div class="col-lg-3" id="header_searchBar">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search for...">
            <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
    <div id="header_option">
        <a href="/user/toIndex">首页</a>
            <#if user??>
                 <a href="#">${user.userName}</a>
            <#else>
                 <a href="/user/toLogin">请登录</a>
            </#if>
        <a href="#">时间轴</a>
        <a href="#">设置</a>
        <a href="/user/logout">退出</a>
    </div>
</div>

<div id="main_content">
    <div id="start_post" style="display: none;height: 40%;">
        <#include "../userPage/post.ftl" />
    </div>
    <div id="tabAllMain">
    <div class="box" style="border-bottom: 0;" >
        <div class="header">
            <div class="fr"><a href="#"><img
                    src="../../static/img/portrait.png" class="avatar"
                    border="0" align="default"></a></div>
            <a style="color: deepskyblue;" href="/user/toIndex">ZZUI</a> <span class="chevron">&nbsp;›&nbsp;</span>
            <a href="/post/tabId/${post.postTabId}">${post.postTabName}</a>
            <div class="sep10"></div>
            <h1>${post.postTitle}</h1>
            <small class="gray"><a href="#">${post.postUserName}</a> · ${post.postTime}
                · ${post.postClickCount}次点击 &nbsp;
            </small>
        </div>
        <div class="cell">
            <div class="topic_content">${post.postContent}</div>
        </div>
    </div>

    <div id="replies_head_info">
        <p>${post.postReplyCount}回复</p>
    </div>

    <div id="replies">
        <#if replies?? >
            <#list replies as reply>
            <div class="cell">
                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody><tr>
                        <td width="48" valign="top" align="center"><img src="../../static/img/portrait.png" class="avatar" border="0" align="default"></td>
                        <td width="10" valign="top"></td>
                        <td width="auto" valign="top" align="left">
                            <div class="sep3"></div>
                            <strong><a href="#" >${reply.replyUserName}</a></strong>&nbsp; &nbsp;<span style="font-size: 12px;color: darkgray;">${reply.replyTimeSimple}</span>
                            <span id="reply_floor">${reply.replyFloor}</span>
                            <div class="sep5"></div>
                            <div class="reply_content">${reply.replyContent}</div>
                        </td>
                    </tr>
                    </tbody></table>
            </div>
            </#list>
        <#else>

        </#if>
    </div>
        <#if (user.userName)=='游客'>
            <h1><a href="#" id="tourist_login">游客暂不支持回复，回复请登录</a></h1>
        <#else>
            <div id="replyRefer">
                <div id="replyRefer_header">
                    <p id="first_p">添加一条新回复</p>
                    <p id="second_p"><a href="#" class="change_a">↑回到顶部</a></p>
                </div>
                <form class="layui-form" action="/reply/addReply/${post.id}" method="post" id="reply_form">
                    <input type="hidden" name="replyUserName" value="${user.userName}"
                    <input type="hidden" name="postId" value="${post.id}">
                    <textarea placeholder="请输入内容" name="replyContent" lay-verify="required|replyArea"></textarea>
                    <div class="btn_group">
                        <button class="layui-btn" type="button" id="reply_btn">回复</button>
                        <button type="reset" class="layui-btn layui-btn-primary">清空</button>
                    </div>
                </form>
                <hr style="color: #E2E2E2"/>
                <p id="third_p"><a href="/user/toIndex" class="change_a">←ZZUI</a></p>
            </div>
        </#if>

    <div id="Login" style="display: none;">
        <form class="layui-form layui-form-pane">
            <div class="layui-form-item" style="margin: 2% 0 0 5%;">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text"  id="tourist_userName" lay-verify="required" placeholder="请输入用户名" autocomplete="on" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" style="margin: 2% 0 0 5%;">
                <label class="layui-form-label">密 码</label>
                <div class="layui-input-inline">
                    <input type="password" id="tourist_userPwd" lay-verify="required"placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <span style="margin: 4% 0 0 6%;"><a href="#">忘记密码?</a></span>
            <br/>
            <input lay-submit  type="button" style="margin: 2% 0 0 5%;" class="layui-btn" value="登陆" id="login_btn">
        </form>
    </div>
<#if (user.userName)!='游客'>
    <div id="index_rightNavigation">
        <div class="cell">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                <tr>
                    <td width="48" valign="top"><a href="#"><img src="/static/img/portrait.png" class="avatar" border="0" align="default" style="max-width: 48px; max-height: 48px;"></a>
                    </td>
                    <td width="10" valign="top"></td>
                    <td width="auto" align="left"><span class="bigger"><a href="#">${user.userName}</a></span>
                    </td>
                </tr>
                </tbody>
            </table>
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                <div style="margin-top: 10px;"></div>
                <tr style="text-align: center;">
                    <td width="33%"><a href="#">${user.unreadMessage}</a></td>
                    <td width="34%"><a href="#">${user.postCollectionNum}</a></td>
                    <td width="33%"><a href="/user/getFocus/${user.id}">${user.focusNumber}</a></td>
                </tr>
                <tr style="text-align: center;">
                    <td width="33%"><a href="#">未读信息</a></td>
                    <td width="34%"><a href="#">帖子收藏</a></td>
                    <td width="33%"><a href="/user/getFocus/${user.id}">特别关注</a></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="cell">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                <tr>
                    <td width="40"><a href="#"><span class="glyphicon glyphicon-pencil" width="32" border="0"></span></a>
                    </td>
                    <td width="10"></td>
                    <td width="auto" valign="middle" align="left"><a style="cursor: pointer;"
                                                                     class="create_post">创作新主题</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</#if>
    </div>
</div>


</body>

<script>
    $(function () {
        $(".create_post").click(function () {
            $("#tabAllMain").remove();
            $("#index_rightNavigation").remove();
            $("#main_content").css("width","100%");
            $("#Main").css("width","80%");
            $("#start_post").css("margin-right", "20%");
            $("#start_post").css("display", "block");
        });
    });
</script>
<script>

</script>
<script>
    layui.use(['form','layer'], function () {
        var form = layui.form;
        var layer = layui.layer;
    });
</script>

<script>
    $(function () {
        $("#reply_btn").click(function () {
            var replyText = $("textarea[name='replyContent']").val();
                    if(replyText==''){
                        layer.alert('回复不能为空', {icon: 5});
                    }else{
                        $("#reply_form").submit();//让第一个form表单提交
                    }
            });
        //用户登录弹出层点击事件
        $("#tourist_login").click(function () {
            //自定页
            layer.open({
                title:'登录',
                type: 1,
                skin: 'layui-layer-demo', //样式类名
                anim: 2,
                area: ['420px', '250px'], //宽高
                content: $('#Login'),
        });
        });

        //登录按钮点击事件
        $("#login_btn").click(function () {
            var userName = $("#tourist_userName").val();
            var pwd = $("#tourist_userPwd").val();
            if(userName==''){
                layer.msg("用户名不能为空");
                return;
            }
            if(pwd==''){
                layer.msg("密码不能为空");
                return;
            }
            $.ajax({
               type:'POST',
               url: '../../user/tourist_login',
                dataType:'JSON',
                data:{userName:userName,userPwd:pwd},
                async:true,
                cache: false,
                success:function (data) {
                    if(data.msg==='验证通过'){
                        layer.msg("登陆成功");
                        setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
                            window.location.reload();//页面刷新
                        },1000);
                    }
                    if(data.msg==='未找到该用户'){
                        layer.msg("未找到该用户，请核对");
                    }
                    if(data.msg==='密码错误'){
                        layer.msg("密码错误，请重新输入");
                    }
                },
                error:function (data) {
                    layer.msg("登陆失败，请查看输入是否有误,若无误请联系管理员！");
                }
            });
        })

    });
</script>
</html>