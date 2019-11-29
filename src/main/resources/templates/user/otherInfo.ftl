<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aurora->个人发布中心</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/otherInfo.css">
<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/js/iconfont.js"></script>
<script type="text/javascript" src="../../static/layui/layui.js"></script>
<style>
    .icon {
        width: 1.5em;
        height: 1.5em;
        vertical-align: -0.15em;
        fill: currentColor;
        overflow: hidden;
    }
</style>
<body>
<#include "../head.ftl"/>
<#include "../touristLogin.ftl" />
<div class="timeline">
    <div class="timeline_title">
        <input hidden id="focus_userId" value="${focus.id}">
        <input hidden id="userId" value="${user.id}">
        <input hidden id="focus_userName" value="${focus.userName}">
        <span id="timeLine_span" class="chevron" style="font-weight: 600;"></span>的所有时间轴
        <span id="postCountSpan">
            <span class="snow">时间轴总数&nbsp;</span>
            <strong class="red" id="TimeLineCount">${TimeLineCount}</strong>
        </span>
    </div>
    <#list lines as line>
        <div class="allTimeLine">
            <div class="line_time">
                ${line.releaseTime}
                <#if (line.userId)==(user.id)>
                     <a Gohref="/timeline/deleteTimeLine/${line.id}"
                        style="cursor: pointer; background-color: orangered;margin-top: 2px;display:inline-block;float: right;"
                        class="count_livid delete_time_a">删除</a>
                <#else >
                </#if>
            </div>
            <div class="line_content">${line.content}</div>
        </div>
    </#list>
</div>
<div id="main_info">
    <span id="main_info_left">
        <img src="../../static/img/portrait.png">
        <span id="info">
            <span>${focus.userName}</span>
            <span>&nbsp;(${focus.userCollege})</span>
        </span>
        <div style="margin: 8px 5px 0 0;">
            <#if (focus.userRole)==1>
                <span style="color: blue;">普通用户</span>
            <#else>
                <#if (focus.userRole)==2>
                 <span style="color: greenyellow;">教师</span>
                <#else>
                <span style="color: orange;">系统管理员</span>
                </#if>
            </#if>
        </div>
    </span>
    <span id=main_info_right style="display: none;"><button type="button" class="option_btn especial_btn"
                                                            onclick="btnConfirm()"><span
            style="font-weight: 600;"></span></button></span>
</div>

<div id="posted">
    <div class="header">
        <span id="post_span" class="chevron" style="font-weight: 600;"></span>的所有帖子
        <span id="postCountSpan">
            <span class="snow">帖子总数&nbsp;</span>
            <strong class="red" id="postCount">${postCount}</strong>
        </span>
    </div>
</div>
<div id="tabAllMain">
         <#if Posts?exists && (Posts?size>0) >
             <#list Posts as post>
            <div class="allPostCell">
                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody>
                    <tr>
                        <td width="48" valign="top" align="center">
                            <a>
                                <img src="/static/img/portrait.png" class="avatar" border="0" align="default">
                            </a>
                        </td>
                        <td width="10"></td>

                        <td width="auto" valign="middle"><span class="item_title"><a
                                href="/post/postDetail/${post.id}">${post.postTitle}</a></span>
                            <div class="sep5" style="margin-top: 10px;"></div>
                        <span class="topic_info"><a href="/post/tabId/${post.postTabId}"
                                                    class="node">${post.postTabName}</a> &nbsp;•&nbsp; <strong><a
                                    href="/user/userInfo/${post.postUserId}">${post.postUserName}</a></strong>

                                <#if (post.postReplyCount)!=0>
                                &nbsp;•&nbsp; ${post.postLastReplyTimeSimple} &nbsp;•&nbsp; 最后回复来自 <strong><a
                                        href="#">${post.postLastReply}</a></strong></span>
                                <#else>
                                <!--为空啥也不显示-->
                                </#if>
                        </td>
                          <#if (post.postReplyCount)==0>
                              <td width="70" align="right" valign="middle">
                                  <a href="/post/postDetail/${post.id}" class="count_livid">0</a>
                              </td>
                          <#else>
                                <td width="70" align="right" valign="middle">
                                    <a href="/post/postDetail/${post.id}" class="count_livid">${post.postReplyCount}</a>
                                </td>
                          </#if>
                    </tr>
                    </tbody>
                </table>
                  <#if (user.id)==0>
                  <#else>
                      <#if (post.postUserId)==(user.id)>
                                 <a Gohref="/post/deletePost/${post.id}"
                                    style="cursor: pointer; background-color: orangered;display:inline-block;margin:-5.0% 7% 0 0 ;float: right;"
                                    class="count_livid delete_a">删除</a>
                      <#else>
                      </#if>
                  </#if>
            </div>
             </#list>
         <#else>
         </#if>
</div>

</body>
<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form;
        var layer = layui.layer;
    });
</script>

<script type="text/javascript">
    $(function () {
        var focusId = $("#focus_userId").val();
        var userId = $("#userId").val();
        var otherName = $("#focus_userName").val();
        var status = '${status}';
        var Mycontent = "&nbsp;&nbsp;我";
        var Othercontent = "&nbsp;&nbsp;" + otherName;
        if (focusId === userId) {
            $("#post_span").html(Mycontent); //我的所有帖子
            $("#timeLine_span").html(Mycontent); //我的所有时间轴
        } else {
            $("#post_span").html(Othercontent); //某人的所有帖子
            $("#timeLine_span").html(Othercontent); //某人所有时间轴
        }
        if ('focused' === status) {
            //上面默认设置按钮是隐藏的，如果进来的不是用户本人，则显示出来按钮
            $("#main_info_right").css("display", "inline-block");
            $(".option_btn span").text('取消特别关注');
            $(".option_btn")
                    .css({
                        'background-color': 'rgb(180,180,180)',
                        'color': 'white',
                        'width': '103px',
                        'height': '28px'
                    });
        }
        if ('unFocused' === status) {
            //上面默认设置按钮是隐藏的，如果进来的不是用户本人，则显示出来按钮
            $("#main_info_right").css("display", "inline-block");
            $(".option_btn span").text('添加特别关注');
            $(".option_btn")
                    .css({'background-color': '#FFDF00', 'color': '#402112'});
        }

        //删除按钮的点击事件
        $(".delete_a").click(function () {
            var gohref = $(this).attr("Gohref");
            var parent = $(this).parent();
            var postCount = $("#postCount").text();
            layer.confirm("确定删除此帖子吗？", {btn: ['确定', '取消'], title: "确认或取消"}, function (index) {
                $.ajax({
                    type: 'POST',
                    dataType: 'JSON',
                    url: gohref,
                    cache: false,
                    async: false,
                    success: function (data) {
                        if ('success' === data) {  //如果业务操作成功
                            parent.fadeOut();
                            $("#postCount").text(parseInt(postCount) - 1);
                            layer.alert("删除成功!", {icon: 1});
                            layer.close(index);  //关闭当前弹窗
                        } else {
                            layer.alert("删除失败，请重试！", {icon: 2});
                            layer.close(index);  //关闭当前弹窗
                        }
                    },
                    error: function (data) {
                        layer.alert("请求异常!请联系管理员", {icon: 2});
                    }
                });
            }); //layer
        }); //delete_a

        //删除时间轴的点击事件
        $(".delete_time_a").click(function () {
            var gohref = $(this).attr("Gohref");
            var parent = $(this).parent().parent();
            var TimeLineCount = $("#TimeLineCount").text();
            layer.confirm("确定删除此时间轴吗？", {btn: ['确定', '取消'], title: "确认或取消"}, function (index) {
                $.ajax({
                    type: 'POST',
                    dataType: 'JSON',
                    url: gohref,
                    cache: false,
                    async: false,
                    success: function (data) {
                        if ('success' === data) {  //如果业务操作成功
                            parent.fadeOut();
                            $("#TimeLineCount").text(parseInt(TimeLineCount) - 1);
                            layer.alert("删除成功!", {icon: 1});
                            layer.close(index);  //关闭当前弹窗
                        } else {
                            layer.alert("删除失败，请重试！", {icon: 2});
                            layer.close(index);  //关闭当前弹窗
                        }
                    },
                    error: function (data) {
                        layer.alert("请求异常!请联系管理员", {icon: 2});
                    }
                });
            }); //layer
        }); //delete_time_a
    })


</script>

<script>
    function btnConfirm() {
        var btnText = $(".option_btn span").text();
        var clickName = '${focus.userName}';
        var userId = '${user.id}';
        var focusId = '${focus.id}';
        if ('0' === userId) {
            layer.msg("游客暂不支持添加关注,请登录");
            return;
        }
        if ('取消特别关注' === btnText) {
            layer.confirm("确定取消关注" + clickName + "吗？", {btn: ['确定', '取消'], title: "确认或取消"}, function (index) {
                $.ajax({
                    type: 'POST',
                    dataType: 'JSON',
                    url: '/user/cancelFocus',
                    data: {'userId': userId, 'focusId': focusId},
                    cache: false,
                    success: function (data) {
                        if ('success' === data) {  //如果业务操作成功
                            $(".option_btn").css({'background-color': '#FFDF00', 'color': '#402112'});
                            $(".option_btn span").text('添加特别关注');
                            layer.close(index);  //关闭当前弹窗
                        } else {
                            layer.alert("操作失败，请重试");
                            layer.close(index);  //关闭当前弹窗
                        }
                    },
                });
            }); //layer
        } else { //如果内容是添加特别关注的(后端已经判断这个人，用户目前还没有关注)
            layer.confirm("确定添加关注" + clickName + "吗？", {btn: ['确定', '取消'], title: "添加确认"}, function (index) {
                $.ajax({
                    type: 'POST',
                    dataType: 'JSON',
                    url: '/user/addFocus',
                    data: {'userId': userId, 'focusId': focusId},
                    cache: false,
                    success: function (data) {
                        if ('correct' === data) {  //如果业务操作成功
                            $(".option_btn")
                                    .css({'background-color': 'rgb(180,180,180)', 'color': 'white'});
                            $(".option_btn span").text('取消特别关注');
                            layer.close(index);  //关闭当前弹窗
                        } else {
                            layer.alert("操作失败，请重试");
                            layer.close(index);  //关闭当前弹窗
                        }
                    },
                });
            }); //layer
        }
    };
</script>


</html>