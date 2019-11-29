<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Aurora>创建主题</title>
    <link href="../../static/codemirror/lib/codemirror.css" rel="stylesheet" type="text/css">
    <link href="../../static/codemirror/addon/display/fullscreen.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../../static/css/post.css">
    <!-- 图片上传即使预览插件 -->
    <link rel="stylesheet" href="../../static/css/fileinput.min.css" />
    <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../static/js/fileinput.min.js"></script>
    <script type="text/javascript" src="../../static/js/zh.js"></script>

    <!-- 引入CodeMirror核心文件 -->
    <script type="text/javascript" src="../../static/codemirror/lib/codemirror.js"></script>
    <!-- CodeMirror支持不同语言，根据需要引入JS文件 -->
    <!-- 因为HTML混合语言依赖Javascript、XML、CSS语言支持，所以都要引入 -->
    <script type="text/javascript" src="../../static/codemirror/mode/xml/xml.js"></script>
    <script type="text/javascript" src="../../static/codemirror/mode/javascript/javascript.js"></script>
    <script type="text/javascript" src="../../static/codemirror/mode/css/css.js"></script>
    <script type="text/javascript" src="../../static/codemirror/mode/htmlmixed/htmlmixed.js"></script>

    <!-- 下面分别为显示行数、括号匹配和全屏插件 -->
    <script type="text/javascript" src="../../static/codemirror/addon/selection/active-line.js"></script>
    <script type="text/javascript" src="../../static/codemirror/addon/edit/matchbrackets.js"></script>
    <script type="text/javascript" src="../../static/codemirror/addon/display/fullscreen.js"></script>
</head>
<style>
    .CodeMirror {
        font-family: 'Consolas', 'Panic Sans', 'DejaVu Sans Mono',
        'Bitstream Vera Sans Mono', 'Menlo', 'Microsoft Yahei', monospace;
    }
</style>
<script>
    layui.use('layer', function(){
        var layer = layui.layer;
    });
</script>
<body style="height: 600px; overflow-y: visible !important;">
<div id="Main">
    <div class="sep20"></div>
    <div class="box" id="box">
        <div class="cell"><a href="/user/toIndex" style="color: deepskyblue">ZZUI</a> <span class="chevron">&nbsp;›&nbsp;</span> 创作新主题</div>
        <form method="post" enctype="multipart/form-data" id="postForm">
            <input type="hidden" value="${user.id}" name="postUserId"  id="postUserId"/>
            <input type="hidden" value="${user.userName}" name="userName" id="userName">
            <div class="cell">
                <div class="fr fade" id="title_remaining">120</div>
                主题标题
            </div>
            <div class="cell" style="padding: 0;"><textarea style="height: 40px;" class="msl" rows="1" maxlength="120" id="postTitle"
                                                              name="postTitle" autofocus="autofocus"
                                                              placeholder="请输入主题标题..."></textarea>
            </div>
            <div class="cell">
                <div class="fr fade" id="content_remaining">20000</div>
                正文<div style="float: right;font-weight: 600;">// Tab键添加4个空格 // F11键切换全屏// Esc键退出全屏</div>
            </div>
            <div style="text-align: left; border-bottom: 1px solid #e2e2e2; font-size: 14px; line-height: 120%;">
                <textarea style="visibility: hidden; display: none;" maxlength="1000" id="editor">
                </textarea>
            </div>

            <div class="form-group">
                <label class="prompt">上传图片：</label>
                <input type="file" name="myfile" class="col-sm-10 myfile" multiple data-ref="iurl" value="" />
                <input type="hidden" id="postContentImg" name="iurl" disabled class="form-control" />
            </div>

            <div class="cell">
                <select name="tabId" id="nodes" style="width: 300px;font-size: 14px;"
                        lay-verify="required"   required  class="form-control">
                </select>
            </div>
        </form>
        <div class="cell">
                <button type="button" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary" onclick="publishTopic()">
                    <i class="layui-icon layui-icon-release"></i> &nbsp;发布主题
                </button>
        </div>
    </div>
</div>
</body>

<script>
    $(function () {
        //获取所有可选择的节点列表
        $.ajax({
            url:'/tab/getAllTabs',
            method:'POST',
            dataType:'JSON',
            async:false,
            cache: false,
            success:function (result) {
                for(var key in result){
                    //console.log(key + "==" + result[key]);
                    $("#nodes").append('<option value="'+key+'">'+result[key]+'</option>');
                }
            }
        });
    });

    //初始化上传组件
    $(".myfile").fileinput({
        language : 'zh',
        uploadUrl:"/post/uploadPic",//上传的地址
        uploadAsync:true, //默认异步上传
        showUpload: true, //是否显示上传按钮,跟随文本框的那个
        showRemove : true, //显示移除按钮,跟随文本框的那个
        showCaption: true,//是否显示标题,就是那个文本框
        showPreview : true, //是否显示预览,不写默认为true
        dropZoneEnabled: true,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        dropZoneTitle: "可直接拖拉图片到此区域，目前暂只支持上传一张照片(记得点击上传，然后发布主题)",
        // 这个配置就是解决办法了,初始化时限制图片大小
        previewSettings: {
            image: {width: "100px", height: "100px"},
        },
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        allowedFileTypes: ['image'],//配置允许文件上传的类型
        allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
        allowedPreviewMimeTypes : [ 'jpg', 'png', 'jpeg', 'gif', 'bmp']//控制被预览的所有mime类型

    })
    //异步上传返回结果处理
    $('.myfile').on('fileerror', function(event, data, msg) {
        console.log("fileerror");
        console.log(data);
    });
    //异步上传返回结果处理
    $(".myfile").on("fileuploaded", function (event, data, previewId, index) {
        console.log("fileuploaded");
        var ref=$(this).attr("data-ref");
        $("input[name='"+ref+"']").val(data.response.iurl);
    });

    //同步上传错误处理
    $('.myfile').on('filebatchuploaderror', function(event, data, msg) {
        console.log("filebatchuploaderror");
        console.log(data);
    });

    //同步上传返回结果处理
    $(".myfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
        console.log("filebatchuploadsuccess");
        console.log(data);
    });

    //上传前
    $('.myfile').on('filepreupload', function(event, data, previewId, index) {
        console.log("filepreupload");
    });

</script>

<script>
    function publishTopic() {
        var postUserId = $("#postUserId").val();
        var postUserName = $("#userName").val();
        var postTitle = $("#postTitle").val();
        var postTabId = $("#nodes").val();
        var tabName =  $("#nodes option:selected").text();  //获取标签名
        var splitName = tabName.split("/");  //分割标签名
        var postTabName = splitName[1];  //设置标签名
        var postContent = $("span[role='presentation']").text().trim();
        var picName = $(".myfile").val();  //原本的图片名
        var postContentImg = $("#postContentImg").val();//传入到后台的图片名
        if(postTitle===""){
            layer.alert("标题不能为空!",{icon:2});
            return ;
        }
        if(postContent===""){
            layer.alert("内容不能为空!",{icon:2});
            return ;
        }
        else{
            layer.confirm('确定发布吗？', {
                title:'确认框'
                ,time: 0 //不自动关闭
                ,btn: ['确定','取消']
                ,yes:function(index){
                    layer.close(index);
                    var ii = layer.load();
                    //此处用setTimeout演示ajax的回调
                    setTimeout(function(){
                        $.ajax({
                            url:'/post/releasePost',
                            method:'POST',
                            dataType:'JSON',
                            data:{postUserId:postUserId,postUserName:postUserName,postTitle:postTitle,postTabId:postTabId,postTabName:postTabName,postContent:postContent,postContentImg:postContentImg},
                            cache:false,
                            async:false,
                            success:function(data){
                                if(data.msg==='发布成功'){
                                    layer.alert('发布成功', {icon: 6});
                                    setTimeout(function(){
                                        window.location.href='/user/toIndex';
                                        },1000);
                                }
                                if(data.msg==='发布失败'){
                                    layer.msg('发布失败,请联系管理员!QQ:54930XXXX', {icon: 5});
                                }
                                else{
                                    layer.msg(data.msg, {icon: 5,time: 5000});  //代表内容敏感
                                }
                            }
                        });
                        layer.close(ii);
                    }, 1000);
                }
            });
        }
    }
</script>
<script>
    $(function () {
        var editor = CodeMirror.fromTextArea(document.getElementById("editor"), {
            lineNumbers: true,     // 显示行数
            indentUnit: 4,         // 缩进单位为4
            styleActiveLine: true, // 当前行背景高亮
            matchBrackets: true,   // 括号匹配
            lineWrapping: false,    // 滚动还是自动换行(false)
            mode: "markdown",
            autofocus: true,//初始化时时候自动获取焦点，默认关闭，textarea自动设为true
        });
        editor.setOption("extraKeys", {
            // Tab键换成4个空格
            Tab: function (cm) {
                var spaces = Array(cm.getOption("indentUnit") + 1).join(" ");
                cm.replaceSelection(spaces);
            },
            // F11键切换全屏
            "F11": function (cm) {
                cm.setOption("fullScreen", !cm.getOption("fullScreen"));
            },
            // Esc键退出全屏
            "Esc": function (cm) {
                if (cm.getOption("fullScreen")) cm.setOption("fullScreen", false);
            }
        });
        //在表单提交之前，我们同步CodeMirror的数据到textarea就可以啦
        $("form").on('submit', function (e) {
            editor.save();
            // 或者获取数据
            // var data = editor.getValue();
        });
    })
</script>

<script>
</script>
</html>