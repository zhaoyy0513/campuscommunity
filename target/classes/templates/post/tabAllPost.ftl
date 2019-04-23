<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/index.css">
<link rel="stylesheet" href="../../static/css/tabAllPost.css">
<#include "../js.ftl" />
<script type="text/javascript" src="../../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
        <#include "../userPage/post.ftl" />
    </div>
    <div id="tabAllMain">
        <div id="allPostHeader">
            <div id="tabIntroduce">
                <div class="fr f12"><span>主题总数</span> <strong>${tabPostNum}</strong> <span class="snow">&nbsp;•&nbsp;</span> <a
                        href="#"></a>
                </div>
                <a href="/user/toIndex" style="color: deepskyblue;">ZZUI</a>
                <span class="chevron">&nbsp;›&nbsp;</span>${tabName}
                <div class="sep10"></div>
                <div class="sep5"></div>
                <div class="fr2" style="padding-left: 10px;">
                    <input type="button" class="create_post btn btn-warning" value="创建新主题">
                </div>
                <span class="f12">${tabDescribe}</span>
                <div class="sep10"></div>
                <div class="node_header_tabs"><a href="${backPreUrl}" class="node_header_tab_current">全部帖子</a></div>
            </div>
            <div id="page"></div>
        </div>

         <#if Posts?exists && (Posts?size>0) >
             <#list Posts as post>
            <div class="allPostCell">
                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody>
                    <tr>
                        <td width="48" valign="top" align="center">
                            <a href="#">
                                <img src="/static/img/portrait.png" class="avatar" border="0" align="default">
                            </a>
                        </td>
                        <td width="10"></td>

                        <td width="auto" valign="middle"><span class="item_title"><a
                                href="/post/postDetail/${post.id}">${post.postTitle}</a></span>
                            <div class="sep5" style="margin-top: 10px;"></div>
                            <span class="topic_info"><a class="node" href="#">${post.postTabName}</a> &nbsp;•&nbsp; <strong><a
                                    href="#">${post.postUserName}</a></strong>

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
            <h1>还没有帖子<a href="#" class="create_post" style="color: deepskyblue;">创建一个吧</a></h1>
         </#if>
    </div>
</div>

<div id="index_rightNavigation">
    <div class="cell">
        <table cellpadding="0" cellspacing="0" border="0" width="100%">
            <tbody>
            <tr>
                <td width="48" valign="top"><a href="#"><img src="/static/img/portrait.png" class="avatar" border="0"
                                                             align="default" style="max-width: 48px; max-height: 48px;"></a>
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
                <td width="33%"><a href="#">特别关注</a></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="cell">
        <table cellpadding="0" cellspacing="0" border="0" width="100%">
            <tbody>
            <tr>
                <td width="40"><a href="/new"><span class="glyphicon glyphicon-pencil" width="32" border="0"></span></a>
                </td>
                <td width="10"></td>
                <td width="auto" valign="middle" align="left"><a style="cursor: pointer;" class="create_post">创作新主题</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
<script>
    $(function () {
        $(".create_post").click(function () {
            $("#tabAllMain").remove();
            $("#index_rightNavigation").remove();
            $("#start_post").css("display", "block");
        });
    });
</script>
</html>