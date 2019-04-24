<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/otherInfo.css">
<script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../static/layui/layui.js"></script>
<body>
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

<div id="main_info">
    <span id="main_info_left">
        <img src="../../static/img/portrait.png">
        <span id="info">
            <span>${focus.userName}</span>
            <span>&nbsp;(${focus.userCollege})</span>
        </span>
    </span>
    <span id=main_info_right><button type="button" class="option_btn especial_btn" onclick="btnConfirm()"><span style="font-weight: 600;"></span></button></span>
</div>

<div id="posted">
    <div class="header">
        <span class="chevron" style="font-weight: 600;">&nbsp;&nbsp;${focus.userName}</span>的所有帖子
        <span id="postCount">
            <span class="snow">帖子总数&nbsp;</span>
            <strong class="red">${postCount}</strong>
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
                            <a href="/user/userInfo/${post.postUserId}">
                                <img src="/static/img/portrait.png" class="avatar"  border="0" align="default">
                            </a>
                        </td>
                        <td width="10"></td>

                        <td width="auto" valign="middle"><span class="item_title"><a
                                href="/post/postDetail/${post.id}">${post.postTitle}</a></span>
                            <div class="sep5" style="margin-top: 10px;"></div>
                        <span class="topic_info"><a class="node" href="#">${post.postTabName}</a> &nbsp;•&nbsp; <strong><a
                                    href="/user/userInfo/${post.postUserId}">${post.postUserName}</a></strong>

                                <#if (post.postLastReply)??>
                                &nbsp;•&nbsp; ${post.postLastReplyTimeSimple} &nbsp;•&nbsp; 最后回复来自 <strong><a
                                        href="#">${post.postLastReply}</a></strong></span>
                                <#else>
                                <!--为空啥也不显示-->
                                </#if>

                        </td>
                          <#if (post.postReplyCount)==0>
                              <td width="70" align="right" valign="middle">
                                  <a href="#" class="count_livid">0</a>
                              </td>
                          <#else>
                                <td width="70" align="right" valign="middle">
                                    <a href="#" class="count_livid">${post.postReplyCount}</a>
                                </td>
                          </#if>
                    </tr>
                    </tbody>
                </table>
            </div>
             </#list>
         <#else>
         </#if>
</div>



<div id="time_shaft">

</div>



</body>
<script>
    layui.use(['form','layer'], function () {
        var form = layui.form;
        var layer = layui.layer;
    });
</script>

<script type="text/javascript">
    $(function () {
        var status = '${status}';
        if('focused'===status){
            $(".option_btn span").text('取消特别关注');
            $(".option_btn").removeClass("especial_btn")
                    .css({'background-color':'rgb(180,180,180)','color':'white','width':'103px','height':'28px'});
        }
    })
</script>

<script>
    function btnConfirm() {
        var btnText = $(".option_btn span").text();
        var clickName = '${focus.userName}';
        var userId = '${user.id}';
        var focusId = '${focus.id}';
        if('取消特别关注'===btnText){
            layer.confirm("确定取消关注"+clickName+"吗？", {btn: ['确定', '取消'], title: "取消确认"}, function (index) {
                $.ajax({
                    type:'POST',
                    dataType:'JSON',
                    url:'/user/cancelFocusUser',
                    data:{'userId':userId,'focusId':focusId},
                    cache: false,
                    success:function (data) {
                        if(data!=null){
                            layer.msg(data);
                            layer.close(index);  //关闭当前弹窗
                        }
                    },
                });
            }); //layer
        }
    };
</script>


</html>