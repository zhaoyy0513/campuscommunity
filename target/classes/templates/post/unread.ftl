<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aurora>未读信息</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/index.css">
<link rel="stylesheet" href="../../static/css/unread.css">
<#include "../js.ftl" />
<body style="overflow-y:auto;">
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
    <div class="header">
        <a href="/user/toIndex" style="margin-left: 2%;color: darkgray;">ZZUI</a>
        <span class="chevron">&nbsp;›&nbsp;</span> 提醒系统
        <span id="postCount">
            <span class="snow">总共收到的提醒&nbsp;</span>
            <strong class="red unread_warn">${user.unreadMessage}</strong>
        </span>
    </div>

    <div id="tabAllMain">
        <#if unreads??>
        <#list unreads as unread>
            <div class="cell aa">
                <img src="../../static/img/portrait.png" class="avatar" border="0" align="default"></a>
                <span>
                        <a href="#">
                         <strong>${unread.infocomeName}</strong>
                        </a> 在 <a href="/post/postDetail/${unread.postId}"
                                  style="color: #778087;background-color: gainsboro;">${unread.postTitle}</a> 里回复了你
                    </span>&nbsp;
                <span class="">${unread.infocomeTime}</span> &nbsp;
                <a style="cursor: pointer;" Gohref="/unread/delete/${unread.id}" class="node delete_unread">删除</a>
                <a style="cursor: pointer;" Gohref="/unread/cancelUnread/${unread.id}"
                   class="node cancel_unread">标记为已读</a>
                <input type="hidden" value="${unread.postId}"/>
                <div class="reply_cont">
                    <span style="display:inline-block;color: #778087;background-color: gainsboro;">${unread.info}</span>
                </div>
            </div>
        </#list>
        <#else>
        </#if>
    </div>
</div>

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
                                   Gohref="/postCollection/getCollections/${user.id}">${user.postCollectionNum}</a></td>
                <td width="33%"><a style="cursor: pointer;" class="focus_a"
                                   Gohref="/user/getFocus/${user.id}">${user.focusNumber}</a></td>
            </tr>
            <tr style="text-align: center;">
                <td width="33%"><a href="#">未读信息</a></td>
                <td width="34%"><a href="#">帖子收藏</a></td>
                <td width="33%"><a href="#">特别关注</a></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="cell">
        <table cellpadding="0" cellspacing="0" border="0" width="100%">
            <tbody>
            <tr>
                <td width="40"><a style="cursor: pointer;" class="create_post"><span class="glyphicon glyphicon-pencil"
                                                                                     width="32" border="0"></span></a>
                </td>
                <td width="10"></td>
                <td width="auto" valign="middle" align="left"><a style="cursor: pointer;" class="create_post">创作新主题</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <iframe id="iframe" frameborder="no" border="0" marginwidth="0" marginheight="0" width=280 height=300
            src="//music.163.com/outchain/player?type=0&id=2788010738&auto=0&height=430"></iframe>
</div>

</body>
<script>
    $(function () {
        //让相应的发布界面显示出来
        $(".create_post").click(function () {
            $(".header").remove();
            $("#tabAllMain").remove();
            $("#index_rightNavigation").remove();
            $("#start_post").css("display", "block");
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
                $(".header").remove();
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_unread").css("display", "block");
            }
        });

        //给收藏信息的a标签添加点击事件
        $(".collection_a").click(function () {
            if ($(this).text() !== "0") {
                //判断是否有未读信息，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href = Gohref;
            } else {
                layer.alert("你并没有收藏帖子", {icon: 2});
                //如果没有关注的人，则跳到提示的界面，让他去关注其他人
                $(".header").remove();
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
                layer.alert("你并没有关注任何人", {icon: 2});
                $(".header").remove();
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_focus").css("display", "block");
            }
        });

        //给删除按钮添加标签
        $(".delete_unread").click(function () {
            var gohref = $(this).attr("Gohref"); //删除操作所需要的连接
            var parent = $(this).parent();
            var postId = $(this).next().val();
            var unreadCount = $(".unread_a").text();
            layer.confirm('确定删除这条回复吗', {
                btn: ['确定', '取消'] //按钮
            }, function (index) {
                //点击确定之后执行ajax代码，执行后台业务的操作
                $.ajax({
                    type: 'POST',
                    url: gohref,
                    dataType: 'JSON',
                    async: false,  //不异步，执行成功再执行下面的
                    cache: false,
                    data: {'postId': postId},
                    success: function (data) {
                        if ('success' === data) {
                            parent.fadeOut();
                            $(".unread_a").text(parseInt(unreadCount) - 1);//右侧收藏数
                            $(".unread_warn").text(parseInt(unreadCount) - 1);//中间显示的提醒总数
                            layer.alert("删除成功!", {icon: 1});
                        } else {
                            layer.alert("删除失败，请重试！", {icon: 2});
                        }
                    },
                    error: function (data) {
                        layer.alert("请求异常!请联系管理员", {icon: 2});
                    }
                });
            }, function (index) {
                //取消之后的操作
                layer.close(index);
            });
        })

        //标记为已读按钮的点击事件
        $(".cancel_unread").click(function () {
            //点击确定之后执行ajax代码，执行后台业务的操作
            var unreadCount = $(".unread_a").text(); //获取右侧未读文本数
            var unreadWarnCount = $(".unread_warn").text(); //获取中间提醒总数
            var gohref = $(this).attr("Gohref");
            var parent = $(this).parent();
            layer.confirm('确定标记为已读吗', {
                btn: ['确定', '取消'] //按钮
            }, function (index) {
                $.ajax({
                    url: gohref,
                    method: 'POST',
                    dataType: 'JSON',
                    async: false,
                    cache: false,
                    success: function (res) {
                        if ('success' === res) {
                            layer.msg("标记成功");
                            $(".unread_a").text(parseInt(unreadCount) - 1);
                            $(".unread_warn").text(parseInt(unreadWarnCount) - 1)
                            parent.fadeOut(); //移除父类这一行
                        }
                        else {
                            layer.alert("标记失败，请重试!", {icon: 5});
                        }
                    },
                    error: function () {
                        layer.alert("连接服务器失败,请联系管理员", {icon: 2});
                    }
                });
            }, function (index) {
                //取消之后的操作
                layer.close(index);
            });
        }); //cancel_unread

    });
</script>
</html>