<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>社区主页</title>
    <#include "css.ftl" />
    <link rel="stylesheet" href="/static/css/index.css">
    <#include "js.ftl" />
    <script type="text/javascript" src="../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
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

<div id="main_content">
    <div id="start_post" style="display: none;height: 40%;">
        <#include "user/post.ftl" />
    </div>
    <div id="no_focus" style="display: none;height: 40%;">
        <#include "user/noFocus.ftl" />
    </div>

    <div id="index_content">
        <div id="primary_title">
            <ul class="nav nav-pills">
            <#list tabList as tab>
                <li role="presentation" class="primary_li">
                    <a myHref="/tab/parentTabId/${tab.id}" href="#">
                        ${tab.tabName}
                    </a>
                </li>
            </#list>
            </ul>
        </div>

        <div id="secondary_title">
        <span style="cursor: pointer;" id="second_title">
              <#list xuebaList as xueba>
                 <a href="/post/tabId/${xueba.id}" style="padding: 2px;">${xueba.tabName}  /</a>
              </#list>
        </span>
        </div>

        <div id="main_article">
            <#if posts??>
            <#list posts as post>
            <div class="cell post_content">
                <table cellpadding="0" cellspacing="0" border="0" width="100%">
                    <tbody>
                    <tr>
                        <td width="48" valign="top" align="center">
                            <a href="/user/userInfo/${post.postUserId}">
                                <img src="/static/img/portrait.png" class="avatar" border="0" align="default">
                            </a>
                        </td>
                        <td width="10"></td>

                        <td width="auto" valign="middle"><span class="item_title"><a
                                href="/post/postDetail/${post.id}">${post.postTitle}</a></span>
                            <div class="sep5" style="margin-top: 10px;"></div>
                            <span class="topic_info"><a class="node" href="/user/userInfo/${post.postUserId}">${post.postTabName}</a> &nbsp;•&nbsp; <strong><a
                                    href="/user/userInfo/${post.postUserId}">${post.postUserName}</a></strong>
                                <#if (post.postLastReplyTimeSimple)??>
                                &nbsp;•&nbsp; ${post.postLastReplyTimeSimple}  &nbsp;•&nbsp; 最后回复来自
                                    <strong style="color:black">
                                    ${post.postLastReply}
                                    </strong>
                                </span>
                                </#if>

                        </td>
                        <td width="70" align="right" valign="middle">
                            <a href="/post/postDetail/${post.id}" class="count_livid">${post.postReplyCount}</a>
                        </td>
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
</div>
    <#if (user.userName)!='游客'>
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
                    <td width="33%"><a href="#">${user.unreadMessage}</a></td>
                    <td width="34%"><a href="#">${user.postCollectionNum}</a></td>
                    <td width="33%"><a style="cursor: pointer;" class="focus_a" Gohref="/user/getFocus/${user.id}">${user.focusNumber}</a></td>
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
                    <td width="40"><a href="#"><span class="glyphicon glyphicon-pencil" width="32" border="0"></span></a>
                    </td>
                    <td width="10"></td>
                    <td width="auto" valign="middle" align="left"><a style="cursor: pointer;" id="create_post">创作新主题</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    </#if>
</body>

<script>
    $(function () {
        //给第一个li设置被选中属性
        $($("ul").children().get(0)).addClass("active");
        //给一级标题设置点击事件，添加和删除相应的样式
        $(".nav li").click(function () {
            $(this).addClass("active");
            $(this).siblings().removeClass("active");
        });

        //创建帖子按钮的点击事件
        $("#create_post").click(function () {
            $("#index_content").remove();
            $("#index_rightNavigation").remove();
            $("#start_post").css("display", "block");
        });

        //给特别关注的a标签添加点击事件
        $(".focus_a").click(function () {
            if($(this).text()!=="0"){
                //判断是否有关注的人，如果有则直接跳转
                var Gohref = $(this).attr("Gohref");
                window.location.href=Gohref;
            }else{
                //如果没有关注的人，则跳到提示的界面，让他去关注别人
                $("#index_content").remove();
                $("#index_rightNavigation").remove();
                $("#no_focus").css("display", "block");
            }
        });
    })
</script>

<script>
    $(function () {
        $(".primary_li>a").click(function () {
            var aimUrl = $(this).attr("myHref");
            //aimurl = /tab/parentTabId/{tab.id};
            $.ajax({
                type: 'POST',
                url: aimUrl,
                dataType: 'JSON',
                // data:{id:num},
                async: true,
                cache: false,
                success: function (data) {
                    // 返回的是个list;
                    var tabs = data.tabs;
                    if (tabs != null) {
                        $("#second_title").children().remove();
                        if (tabs.length > 9) {
                            $("#secondary_title").css("height", "85px");
                            for (var i = 0; i < tabs.length; i++) {
                                $("#second_title").append('<a href="/post/tabId/'+tabs[i].id+'"style="padding: 2px;">' + tabs[i].tabName + ' /</a>');
                                if (i % 5 == 0 && i !== 0) {
                                    $("#second_title").append("<br/>");
                                }
                            }
                        } else {
                            $("#secondary_title").css("height", "40px");
                            for (var i = 0; i < tabs.length; i++) {
                                $("#second_title").append('<a href="/post/tabId/'+tabs[i].id+'"style="padding: 2px;">' + tabs[i].tabName + ' /</a>');
                            }
                        }
                    }
                    // var test = data.posts;
                    // for(var j=0;j<test.length;j++){
                    //     console.log(test);
                    // }
                    //重新渲染新的帖子
                    $(".post_content").css("display","none");
                    var post = data.posts;
                   for(var i=0;i<post.length;i++){
                       if((post[i].postLastReply)!=""){
                           $("#main_article").append(' <div class="cell post_content">\n' +
                                   '                <table cellpadding="0" cellspacing="0" border="0" width="100%">\n' +
                                   '                    <tbody>\n' +
                                   '                    <tr>\n' +
                                   '                        <td width="48" valign="top" align="center">\n' +
                                   '                            <a href="/user/userInfo/'+post[i].postUserId+'">\n' +
                                   '                                <img src="/static/img/portrait.png" class="avatar" border="0" align="default">\n' +
                                   '                            </a>\n' +
                                   '                        </td>\n' +
                                   '                        <td width="10"></td>\n' +
                                   '\n' +
                                   '                        <td width="auto" valign="middle"><span class="item_title"><a\n' +
                                   '                                href="/post/postDetail/'+post[i].id+'">'+post[i].postTitle+'</a></span>\n' +
                                   '                            <div class="sep5" style="margin-top: 10px;"></div>\n' +
                                   '                            <span class="topic_info"><a class="node" href="#">'+post[i].postTabName+'</a> &nbsp;•&nbsp; <strong><a\n' +
                                   '                                    href="/user/userInfo/'+post[i].postUserId+'">'+post[i].postUserName+'</a></strong>\n' +
                                   '\n' +
                                   '                              \n'+
'                                &nbsp;•&nbsp;'+post[i].postLastReplyTimeSimple+' &nbsp;•&nbsp; 最后回复来自 <strong style="color:black">'+post[i].postLastReply+'</strong></span>\n' +
'                                \n' +
                                   '\n' +
                                   '                        </td>\n' +
                                   '                        <td width="70" align="right" valign="middle">\n' +
                                   '                            <a href="#" class="count_livid">'+post[i].postReplyCount+'</a>\n' +
                                   '                        </td>\n' +
                                   '                    </tr>\n' +
                                   '                    </tbody>\n' +
                                   '                </table>\n' +
                                   '            </div>');
                       }else{
                           $("#main_article").append(' <div class="cell post_content">\n' +
                                   '                <table cellpadding="0" cellspacing="0" border="0" width="100%">\n' +
                                   '                    <tbody>\n' +
                                   '                    <tr>\n' +
                                   '                        <td width="48" valign="top" align="center">\n' +
                                   '                            <a href="/user/userInfo/'+post[i].postUserId+'">\n' +
                                   '                                <img src="/static/img/portrait.png" class="avatar" border="0" align="default">\n' +
                                   '                            </a>\n' +
                                   '                        </td>\n' +
                                   '                        <td width="10"></td>\n' +
                                   '\n' +
                                   '                        <td width="auto" valign="middle"><span class="item_title"><a\n' +
                                   '                                href="/post/postDetail/'+post[i].id+'">'+post[i].postTitle+'</a></span>\n' +
                                   '                            <div class="sep5" style="margin-top: 10px;"></div>\n' +
                                   '                            <span class="topic_info"><a class="node" href="#">'+post[i].postTabName+'</a> &nbsp;•&nbsp; <strong><a\n' +
                                   '                                    href="/user/userInfo/'+post[i].postUserId+'">'+post[i].postUserName+'</a></strong>\n' +
                                   '\n' +
                                   '\n' +
                                   '                        </td>\n' +
                                   '                        <td width="70" align="right" valign="middle">\n' +
                                   '                            <a href="#" class="count_livid">'+post[i].postReplyCount+'</a>\n' +
                                   '                        </td>\n' +
                                   '                    </tr>\n' +
                                   '                    </tbody>\n' +
                                   '                </table>\n' +
                                   '            </div>');
                       }
                   }
                   }
            });

        });
    })
</script>

<script>
    layui.use('element', function () {
        var element = layui.element;
    });
</script>
</html>