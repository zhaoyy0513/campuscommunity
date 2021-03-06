<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aurora>帖子详情</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/postDetail.css">
<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../static/layui/layui.js"></script>
<body style="background-color: whitesmoke;">
<#include "../head.ftl"/>
<#include "../touristLogin.ftl" />
<div id="main_content">
    <div id="start_post" style="display: none;height: 40%;">
        <#include "../user/post.ftl" />
    </div>
    <div id="no_focus" style="display: none;height: 40%;">
        <#include "../user/noFocus.ftl" />
    </div>
    <div id="no_unread" style="display: none;height: 40%;">
         <#include "../user/noUnread.ftl" />
    </div>
    <div id="no_collection" style="display: none;height: 40%;">
         <#include "../user/noCollection.ftl" />
    </div>
    <div id="tabAllMain">
        <div class="box" style="border-bottom: 0;">
            <div class="header">
                <div class="fr"><a href="/user/userInfo/${post.postUserId}"><img
                        src="../../static/img/portrait.png" class="avatar"
                        border="0" align="default"></a></div>
                <a style="color: deepskyblue;" href="/user/toIndex">Aurora</a> <span
                    class="chevron">&nbsp;›&nbsp;</span>
                <a href="/post/tabId/${post.postTabId}">${post.postTabName}</a>
                <div class="sep10"></div>
                <h1>${post.postTitle}</h1>
                <small class="gray"><a href="#">${post.postUserName}</a>&nbsp${post.postTime}
                    · ${post.postClickCount}次点击 &nbsp;
                </small>
                <div style="float: right;">
                    <button type="button" class="btn btn-primary" id="collectBtn">添加收藏</button>
                    <input type="hidden" value="${user.id}/${post.id}"/>
                    <input type="hidden" value="${status}" id="status"/>
                </div>
            </div>
            <div class="cell">
                <div class="topic_content">${post.postContent}</div>
            </div>
        </div>

        <div id="replies_head_info">
            <p style="font-weight: 600;"><span>${post.postReplyCount}</span>条回复</p>
        </div>

        <div id="replies">
        <#if replies?? >
            <#list replies as reply>
                <#if (reply.replyUserId)==(user.id)>
                          <div class="cell">
                              <table cellpadding="0" cellspacing="0" border="0" width="100%">
                                  <tbody>
                                  <tr>
                                      <td width="48" valign="top" align="center"><a
                                              href="/user/userInfo/${reply.replyUserId}"><img
                                              src="../../static/img/portrait.png" class="avatar" border="0"
                                              align="default"></a></td>
                                      <td width="10" valign="top"></td>
                                      <td width="auto" valign="top" align="left">
                                          <div class="sep3"></div>
                                          <strong><a
                                                  href="/user/userInfo/${reply.replyUserId}">${reply.replyUserName}</a></strong>&nbsp;
                                          &nbsp;<span
                                              style="font-size: 12px;color: darkgray;">${reply.replyTimeSimple}</span>
                                          <span id="reply_floor">
                                              ${reply.replyFloor}
                                          </span>
                                          <div class="sep5"></div>
                                          <div class="reply_content">${reply.replyContent}</div>
                                      </td>
                                  </tr>
                                  </tbody>
                              </table>
                              <a params="${reply.id}/${reply.postId}"
                                 style="cursor: pointer; background-color: orangered;display:inline-block;margin:-4.7% 4% 0 0 ;float: right;"
                                 class="count_livid delete_reply">删除</a>
                          </div>
                <#else>
                      <div class="cell">
                          <table cellpadding="0" cellspacing="0" border="0" width="100%">
                              <tbody>
                              <tr>
                                  <td width="48" valign="top" align="center"><a
                                          href="/user/userInfo/${reply.replyUserId}"><img
                                          src="../../static/img/portrait.png" class="avatar" border="0" align="default"></a>
                                  </td>
                                  <td width="10" valign="top"></td>
                                  <td width="auto" valign="top" align="left">
                                      <div class="sep3"></div>
                                      <strong><a
                                              href="/user/userInfo/${reply.replyUserId}">${reply.replyUserName}</a></strong>&nbsp;
                                      &nbsp;<span
                                          style="font-size: 12px;color: darkgray;">${reply.replyTimeSimple}</span>
                                      <span id="reply_floor">
                                          ${reply.replyFloor}
                                      </span>
                                      <a class="reply_icon" style="margin-right: 12px;float: right;" href="#"
                                         onclick="replyOne('${reply.replyUserId}','${reply.replyUserName}');"><img
                                              src="../../static/img/reply.png" border="0" alt="Reply"></a>
                                      <a style="margin-right: 14px;float: right;text-decoration: none; display: none;"
                                         href="#"
                                         onclick="replyOne('${reply.replyUserId}','${reply.replyUserName}');">回复</a>
                                      <div class="sep5"></div>
                                      <div class="reply_content">${reply.replyContent}</div>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
                      </div>

                </#if>

            </#list>
        <#else>
        </#if>
        </div>
        <#if (user.userName)=='游客'>
            <h1><a style="cursor: pointer;" class="tourist_reply">游客暂不支持回复，回复请登录</a></h1>
        <#else>
            <div id="replyRefer">
                <div id="replyRefer_header">
                    <p id="first_p">添加一条新回复</p>
                    <p id="second_p"><a style="cursor: pointer;" class="back_top">↑回到顶部</a></p>
                </div>
                <form class="layui-form" action="/reply/addReply/${post.id}" method="post" id="reply_form">
                    <input type="hidden" name="replyUserId" value="${user.id}"/>
                    <input type="hidden" name="replyUserName" value="${user.userName}"/>
                    <input type="hidden" name="infoTo" value=""/>
                    <textarea placeholder="请输入内容" id="replyTextArea" name="replyContent"
                              lay-verify="required"></textarea>
                    <div class="btn_group">
                        <button class="layui-btn" type="button" id="reply_btn">回复</button>
                        <button type="reset" class="layui-btn layui-btn-primary">清空</button>
                    </div>
                </form>
                <hr style="color: #E2E2E2"/>
                <p id="third_p"><a href="/user/toIndex" class="change_a">←Aurora</a></p>
            </div>
        </#if>
<#if (user.userName)!='游客'>
    <div id="index_rightNavigation">
        <div class="cell">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                <tr>
                    <td width="48" valign="top"><a href="/user/userInfo/${user.id}"><img src="/static/img/portrait.png"
                                                                                         class="avatar" border="0"
                                                                                         align="default"
                                                                                         style="max-width: 48px; max-height: 48px;"></a>
                    </td>
                    <td width="10" valign="top"></td>
                    <td width="auto" align="left"><span class="bigger"><a
                            href="/user/userInfo/${user.id}">${user.userName}</a></span>
                    </td>
                </tr>
                </tbody>
            </table>
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                <div style="margin-top: 10px;"></div>
                <tr style="text-align: center;">
                    <td width="33%"><a style="cursor: pointer;" class="unread_a"
                                       Gohref="/unread/unreadsByUid/${user.id}">${user.unreadMessage}</a></td>
                    <td width="34%"><a style="cursor: pointer;" class="collection_a"
                                       Gohref="/postCollection/getCollections/${user.id}">${user.postCollectionNum}</a>
                    </td>
                    <td width="33%"><a style="cursor: pointer;" class="focus_a"
                                       Gohref="/user/getFocus/${user.id}">${user.focusNumber}</a></td>
                </tr>
                <tr style="text-align: center;">
                    <td width="33%">未读信息</td>
                    <td width="34%">帖子收藏</td>
                    <td width="33%">特别关注</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="cell">
            <table cellpadding="0" cellspacing="0" border="0" width="100%">
                <tbody>
                <tr>
                    <td width="40"><a style="cursor: pointer;" class="create_post"><span
                            class="glyphicon glyphicon-pencil" width="32"
                            border="0"></span></a>
                    </td>
                    <td width="10"></td>
                    <td width="auto" valign="middle" align="left"><a style="cursor: pointer;"
                                                                     class="create_post">创作新主题</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <iframe id="iframe" frameborder="no" border="0" marginwidth="0" marginheight="0" width=280 height=300
                src="//music.163.com/outchain/player?type=0&id=2788010738&auto=0&height=430"></iframe>
    </div>
</#if>
    </div>
</div>
</body>
<script>
    $(function () {
        //根据帖子是否被收藏，来设置按钮样式
        var status = $("#status").val();
        if (status === 'collected') {
            //如果已经收藏，则直接修改相应的属性,如果没有收藏，则使用默认的
            $("#collectBtn").attr("class", "btn btn-warning").text("取消收藏");
        }

        //回复按钮的逻辑
        $(".reply_icon").mouseover(function () {
            $(this).next().css("display", "block");
        }).next().mouseout(function () {
            $(this).css("display", "none");
        });

        //回到顶部按钮的点击事件(过渡动画)
        //var timer=null;
        $(".back_top").click(function () {
            $('body,html').animate({scrollTop: 0}, 300);
            return false;
            // cancelAnimationFrame(timer);
            // timer = requestAnimationFrame(function fn(){
            //     var oTop = document.body.scrollTop || document.documentElement.scrollTop;
            //     if(oTop > 0){
            //         document.body.scrollTop = document.documentElement.scrollTop = oTop - 30;
            //         timer = requestAnimationFrame(fn);
            //     }else{
            //         cancelAnimationFrame(timer);
            //     }
            // });
        });

        //删除回复的点击事件
        $(".delete_reply").click(function () {
            var parent = $(this).parent();
            var replyConut = $("#replies_head_info p>span").text();
            var params = $(this).attr("params").split('/');
            var Rid = params[0];
            var Pid = params[1];

            layer.confirm('确定删除此回复吗', {
                btn: ['确定', '取消'] //选项按钮
            }, function () {
                //点击确定之后跳转的
                $.ajax({
                    url: '/reply/deleteReply',
                    method: 'POST',
                    dataType: 'JSON',
                    data: {'Rid': Rid, 'Pid': Pid},
                    async: false,
                    cache: false,
                    success: function (res) {
                        if ('success' === res) {
                            layer.msg("删除回复成功!", {icon: 6, time: 2000});
                            $("#replies_head_info p>span").text(parseInt(replyConut)-1);
                            parent.fadeOut();
                        } else {
                            layer.alert("删除回复失败!,请联系管理员", {icon: 5});
                        }
                    },
                    error: function () {
                        layer.alert("连接服务器异常!,请联系管理员", {icon: 5});
                    }
                });
            }, function () {
                layer.close();
            });
        });

        //回复区登录操作,#Login的内容在上面include(touristLogin.ftl里)
        $(".tourist_reply").click(function () {
            //自定页
            layer.open({
                title: '登录',
                type: 1,
                skin: 'layui-layer-demo', //样式类名
                anim: 2,
                area: ['420px', '250px'], //宽高
                content: $('#Login'),
            });
        });


    })
</script>
<script>
    function replyOne(toId, toName) { //添加回复给某个用户功能的按钮
        //第一个参数是目的用户的id，第二个参数是目的用户的用户名
        //进入这个方法后获取焦点，并将要回复的名字写入到里面
        $("input[name='infoTo']").val(toId);
        //focus可能会失效，这里设置个定时器函数进行功能的实现
        setTimeout(function () {
            $("#replyTextArea").focus().text('@' + toName + ' ');
        }, 100);
    }
</script>

<script>
    $(function () {
        ////创建帖子按钮的点击事件
        $(".create_post").click(function () {
            $("#tabAllMain").remove();
            $("#index_rightNavigation").remove();
            $("#main_content").css("width", "100%");
            $("#Main").css("width", "80%");
            $("#start_post").css({"margin-right": "20%", "display": "block"});
        });

        //给未读信息的a标签添加点击事件
        $(".unread_a").click(function () {
            if ($(this).text() !== "0") {
                //判断是否有未读信息，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href = Gohref;
            } else {
                layer.alert("你并没有未读信息", {icon: 2});
                //如果没有关注的人，则跳到提示的界面，让他去关注其他人
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_unread").css("display", "block");
            }
        });

        //给收藏信息的a标签添加点击事件
        $(".collection_a").click(function () {
            if ($(this).text() !== "0") {
                //判断是否有收藏，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href = Gohref;
            } else {
                layer.alert("你并没有收藏帖子", {icon: 2});
                //如果没有收藏，则跳到提示的界面，让他去收藏帖子
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_collection").css("display", "block");
            }
        });

        //给特别关注的a标签添加点击事件
        $(".focus_a").click(function () {
            if ($(this).text() !== "0") {
                //判断是否有关注的人，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href = Gohref;
            } else {
                //如果没有关注的人，则跳到提示的界面，让他去关注别人
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_focus").css("display", "block");
            }
        });

        //添加收藏按钮点击事件
        $("#collectBtn").click(function () {
            var btn = $(this); //获取当前点击的这个按钮
            var btnText = $(this).text();  //用来判断是收藏还是取消
            var needValues = $(this).next().val();  //获取所需要的数据用于下面切割
            var values = needValues.split('/'); //切割数据得到用户索引id和帖子索引id
            var user_id = values[0]; //获取当前用户索引id
            var post_id = values[1];//获取帖子索引id
            var toAddUrl = '/postCollection/addCollect/' + post_id;
            var toCancelUrl = '/postCollection/cancelCollect/' + post_id;
            var collection_a = $(".collection_a").text();
            if ("添加收藏" === btnText) {
                if (user_id === '0') {
                    layer.msg("游客暂不支持收藏，请先登录");
                    layer.close();
                    return;
                }
                //如果在下面确定选项中直接$(this)获取的并不是要设置的按钮，因此提前设置好
                layer.confirm('确定添加收藏吗？', {
                    btn: ['确定', '取消'] //按钮的选项
                }, function (index) {
                    $.ajax({
                        type: 'POST',
                        dataType: 'JSON',
                        data: {"userId": user_id},
                        url: toAddUrl,
                        async: false,  //关闭异步，一步一步进行
                        cache: false,  //关闭缓存，每次使用后台返回的新的值
                        success: function (data) {
                            if ("success" === data) {
                                btn.attr("class", "btn btn-warning").text("取消收藏");
                                $(".collection_a").text(parseInt(collection_a) + 1);
                                layer.close(index);
                            } else {
                                layer.alert("添加收藏失败", {icon: 2});
                            }
                        },
                        error: function (data) {
                            layer.alert("连接异常!,重试或联系管理员", {icon: 2});
                        }
                    });
                }, function (index) {
                    //取消之后的操作
                    layer.close(index);
                });
            } else {
                //如果是取消收藏按钮
                layer.confirm('确定取消收藏吗？', {
                    btn: ['确定', '取消'] //按钮的选项
                }, function (index) {
                    $.ajax({
                        type: 'POST',
                        dataType: 'JSON',
                        url: toCancelUrl,
                        data: {"userId": user_id},
                        async: false,
                        cache: false,
                        success: function (data) {
                            if ("success" === data) {
                                btn.attr("class", "btn btn-primary").text("添加收藏");
                                $(".collection_a").text(parseInt(collection_a) - 1);
                                layer.close(index);
                            } else {
                                layer.alert("添加收藏失败", {icon: 2});
                            }
                        },
                        error: function (data) {
                            layer.alert("连接异常!,重试或联系管理员", {icon: 2});
                        }
                    });
                }, function (index) {
                    //取消之后的操作
                    layer.close(index);
                });
            }

        });//收藏和取消按钮点击事件

    });
</script>

<script>
    $(function () {
        //帖子回复点击事件
        $("#reply_btn").click(function () {
            var replyText = $("textarea[name='replyContent']").val();
            var replyConut = $("#replies_head_info p>span").text();
            layer.confirm('确定提交回复吗', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                //点击确定之后执行ajax代码，执行后台业务的操作
                if (replyText == '') {
                    layer.alert('回复不能为空', {icon: 2});
                } else {
                    var replyArr = replyText.trim();
                    var pos = replyArr.indexOf("@");
                    //不同的回复结果跳转不同的controller位置
                    if (pos != 0) {//如果索引位置不是0
                        //不等于0 表示用户@完用户之后 又将@这些去掉了，那么清空infoTo这个表单的内容
                        $("input[name='infoTo']").val("");
                        $.ajax({
                            url:'/reply/replyValidate',
                            method:'POST',
                            dataType:'JSON',
                            data:$("#reply_form").serialize(),
                            cache:false,
                            async:false,
                            success:function (data) {
                                if('success'===data.msg){
                                    $("#replies_head_info p>span").text(parseInt(replyConut) + 1);
                                    //action="/reply/addReply/${post.id}"
                                    $("#reply_form").submit();//让第一个form表单提交
                                }
                                else{
                                    layer.msg(data.msg,{icon:5,time: 5000});
                                    return ;
                                }
                            },
                            error:function () {
                                layer.msg("连接服务器失败，请联系管理员",{icon:2});
                            }
                        });

                    } else {
                        //如果是用户@某个用户 则直接提交
                        var url = "/reply/replyUser/${post.id}";
                        $.ajax({
                            url:'/reply/replyValidate',
                            method:'POST',
                            dataType:'JSON',
                            data:$("#reply_form").serialize(),
                            cache:false,
                            async:false,
                            success:function (data) {
                                if('success'===data.msg){
                                    $("#replies_head_info p>span").text(parseInt(replyConut) + 1);
                                    $("#reply_form").attr("action", url).submit();
                                }
                                else{
                                    layer.msg(data.msg,{icon:5,time:5000});
                                    return ;
                                }
                            },
                            error:function () {
                                layer.msg("连接服务器失败，请联系管理员",{icon:2});
                            }
                        });
                    }
                }
            }, function () {
                //取消之后的操作
                layer.close();
            });
        });
    });
</script>
</html>