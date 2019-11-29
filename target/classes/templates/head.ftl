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
                 <a href="/user/userInfo/${user.id}">${user.userName}</a>
                 <input type="hidden" value="${user.id}" id="hidden_userId"/>
            <#else>
                 <a href="/user/toLogin">请登录</a>
            </#if>
        <#if (user.id)==0>
             <a href="#" class="tourist_login">登录</a>
        <#else>
         <a href="#" onclick="timeLine()">时间轴</a>
            <a href="#" onclick="setting()">设置</a>
            <a href="/user/logout">退出</a>
        </#if>
    </div>
</div>

<script>
    function setting(){
        layui.use(['form', 'layer'], function () {
            var form = layui.form;
            var layer = layui.layer;
            layer.open({
                type: 2,
                title: '修改信息',
                maxmin: true,
                skin: 'layui-layer-lan',
                shadeClose: true, //点击遮罩关闭层
                area : ['800px' , '600px'],
                content:'../../setting'//弹框显示的url
            });
        });
    }
    //
    function timeLine() {
        layui.use(['form', 'layer'], function () {
            var form = layui.form;
            var layer = layui.layer;
            layer.open({
                type: 2,
                title: '添加时间轴',
                maxmin: true,
                skin: 'layui-layer-lan',
                shadeClose: true, //点击遮罩关闭层
                area : ['600px' , '500px'],
                content:'../../timeline'//弹框显示的url
            });
        });
    }


</script>