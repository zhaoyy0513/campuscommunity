<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aurora>${tabName}</title>
</head>
<#include "../css.ftl" />
<link rel="stylesheet" href="../../static/css/index.css">
<link rel="stylesheet" href="../../static/css/tabAllPost.css">
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
    <div id="tabAllMain">
        <div id="allPostHeader">
            <div id="tabIntroduce">
                <div class="fr f12"><span>主题总数</span> <strong>${tabPostNum}</strong> <span
                        class="snow">&nbsp;•&nbsp;</span> <a
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
                            <a href="/user/userInfo/${post.postUserId}">
                                <img src="/static/img/portrait.png" class="avatar" border="0" align="default">
                            </a>
                        </td>
                        <td width="10"></td>

                        <td width="auto" valign="middle"><span class="item_title"><a
                                href="/post/postDetail/${post.id}">${post.postTitle}</a></span>
                            <div class="sep5" style="margin-top: 10px;"></div>
                        <span class="topic_info"><a class="node">${post.postTabName}</a> &nbsp;•&nbsp; <strong><a
                                    href="/user/userInfo/${post.postUserId}">${post.postUserName}</a></strong>

                                <#if (post.postLastReply)??>
                                &nbsp;•&nbsp; ${post.postLastReplyTimeSimple} &nbsp;•&nbsp; 最后回复来自 <strong><a
                                        href="/post/postDetail/${post.id}">${post.postLastReply}</a></strong></span>
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

<#if (user.id)!=0>
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
                   <td width="40"><a style="cursor: pointer;" class="create_post"><span
                           class="glyphicon glyphicon-pencil" width="32" border="0"></span></a>
                   </td>
                   <td width="10"></td>
                   <td width="auto" valign="middle" align="left"><a style="cursor: pointer;"
                                                                    class="create_post">创作新主题</a>
                   </td>
               </tr>
               </tbody>
           </table>
       </div>
       <iframe id="iframe" frameborder="no" border="0" marginwidth="0" marginheight="0" width=280 height=300 src="//music.163.com/outchain/player?type=0&id=2788010738&auto=0&height=430"></iframe>
   </div>
</#if>


</body>
<script>
    $(function () {
        var hidden_userId = $("#hidden_userId").val();
        $(".create_post").click(function () {
            if(hidden_userId==='0'){
                layer.msg("游客暂不支持发布帖子，请先登录");
                return ;
            }else{
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#start_post").css("display", "block");
            }
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
                layer.alert("你并没有关注任何人", {icon: 2});
                $("#tabAllMain").remove();
                $("#index_rightNavigation").remove();
                $("#no_focus").css("display", "block");
            }
        });

    });
</script>
</html>