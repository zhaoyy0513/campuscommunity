<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ZZUI>我的特别关注</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/index.css">
<link rel="stylesheet" href="../../static/css/focusPosts.css">
<#include "../js.ftl" />
<body style="overflow-y:auto;">
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
        <#include "../user/post.ftl" />
    </div>
    <div id="no_focus" style="display: none;height: 40%;">
        <#include "../user/noFocus.ftl" />
    </div>
    <div id="no_unread" style="display: none;height: 40%;">
         <#include "../user/noUnread.ftl" />
    </div>
    <div id="no_collection"  style="display: none;height: 40%;">
         <#include "../user/noCollection.ftl" />
    </div>
    <div class="header">
        <a href="/user/toIndex" style="margin-left: 2%;color: darkgray;">ZZUI</a>
        <span class="chevron">&nbsp;›&nbsp;</span> 收藏的帖子
        <span id="postCount">
            <span class="snow">帖子总数&nbsp;</span>
            <strong class="red">${postCount}</strong>
        </span>
    </div>
    <div id="tabAllMain">
         <#if Posts??>
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
</div>

<div id="index_rightNavigation">
    <div class="cell">
        <table cellpadding="0" cellspacing="0" border="0" width="100%">
            <tbody>
            <tr>
                <td width="48" valign="top"><a href="/user/userInfo/${user.id}"><img src="/static/img/portrait.png" class="avatar" border="0"
                                                                                     align="default" style="max-width: 48px; max-height: 48px;"></a>
                </td>
                <td width="10" valign="top"></td>
                <td width="auto" align="left"><span class="bigger"><a href="/user/userInfo/${user.id}">${user.userName}</a></span>
                </td>
            </tr>
            </tbody>
        </table>
        <table cellpadding="0" cellspacing="0" border="0" width="100%">
            <tbody>
            <div style="margin-top: 10px;"></div>
            <tr style="text-align: center;">
                <td width="33%"><a style="cursor: pointer;" class="unread_a" Gohref="/unread/unreadsByUid/${user.id}">${user.unreadMessage}</a></td>
                <td width="34%"><a style="cursor: pointer;" class="collection_a" Gohref="/postCollection/getCollections/${user.id}">${user.postCollectionNum}</a></td>
                <td width="33%"><a style="cursor: pointer;" class="focus_a" Gohref="/user/getFocus/${user.id}">${user.focusNumber}</a></td>
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
                <td width="40"><a style="cursor: pointer;" class="create_post"><span class="glyphicon glyphicon-pencil" width="32" border="0"></span></a>
                </td>
                <td width="10"></td>
                <td width="auto" valign="middle" align="left"><a style="cursor: pointer;" class="create_post">创作新主题</a>
                </td>
            </tr>
            </tbody>
        </table>
        <iframe id="iframe" frameborder="no" border="0" marginwidth="0" marginheight="0" width=280 height=300 src="//music.163.com/outchain/player?type=0&id=2788010738&auto=1&height=430"></iframe>
    </div>
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
            if($(this).text()!=="0"){
                //判断是否有未读信息，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href=Gohref;
            }else{
                layer.alert("你并没有未读信息",{icon: 2});
                //如果没有关注的人，则跳到提示的界面，让他去关注其他人
                $(".header").remove();
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_unread").css("display", "block");
            }
        });

        //给收藏信息的a标签添加点击事件
        $(".collection_a").click(function () {
            if($(this).text()!=="0"){
                //判断是否有收藏，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href=Gohref;
            }else{
                layer.alert("你并没有收藏帖子",{icon: 2});
                //如果没有收藏，则跳到提示的界面，让他去收藏帖子
                $(".header").remove();
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_collection").css("display", "block");
            }
        });

        //给特别关注的a标签添加点击事件
        $(".focus_a").click(function () {
            if($(this).text()!=="0"){
                //判断是否有关注的人，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href=Gohref;
            }else{
                //如果没有关注的人，则跳到提示的界面，让他去关注别人
                layer.alert("你并没有关注任何人",{icon: 2});
                $(".header").remove();
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_focus").css("display", "block");
            }
        });
    });
</script>
</html>