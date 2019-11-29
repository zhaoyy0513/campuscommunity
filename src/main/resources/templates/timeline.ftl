<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link>
    <link href="../static/css/timeline.css" rel="stylesheet">
    <link href="../static/layui/css/layui.css" rel="stylesheet">
    <script src="../static/js/jquery-3.3.1.min.js" type="text/javascript">
    </script>
    <script src="../static/js/iconfont.js" type="text/javascript"></script>
    <script src="../static/layui/layui.js" type="text/javascript"></script>
    <style>
        .icon {
            width: 2em;
            height: 2em;
            vertical-align: -0.15em;
            fill: currentColor;
            overflow: hidden;
        }
    </style>
</head>
<body>
<div id="fullContent">
    <div class="Input_Box">
        <div contenteditable="true" class="Input_text"></div>
        <div class="Input_Foot">
            <a class="imgBtn" onclick="showIcon()">'◡'</a><a class="postBtn">确定</a>
        </div>
    </div>

    <div id="icon_div">
        <div id="all_icon" style="margin:2px 2px 2px 2px;">
        </div>
    </div>
</div>
</body>
<script>
    function showIcon() {
        $("#icon_div").toggle(300);
    }

    function addIcon(i) {
        var pos = $("a[iconNum=" + i + "]").children().html();
        var icon = '<svg class="icon" aria-hidden="true">' + pos + '</svg>';
        $(".Input_text").append(icon + '&nbsp'); //加空格防止图片后面无法添加内容
    }
</script>

<script>
    $(function () {
        //一般直接写在一个js文件中
        layui.use(['layer', 'form'], function () {
            var layer = layui.layer;
        });
        var icon_alias = ["#icon-a",
            "#icon-bizui",
            "#icon-baiyan",
            "#icon-aixin",
            "#icon-dajing",
            "#icon-ziya",
            "#icon-daxiao",
            "#icon-esi",
            "#icon-fadai",
            "#icon-fankun",
            "#icon-ganga",
            "#icon-fennu",
            "#icon-hanyan",
            "#icon-jingkong",
            "#icon-haochi",
            "#icon-jingsong",
            "#icon-jingya",
            "#icon-kaixin",
            "#icon-lengku",
            "#icon-danao",
            "#icon-liulei",
            "#icon-nanguo",
            "#icon-tiaopi",
            "#icon-xingxingyan",
            "#icon-ku",
            "#icon-huaixiao",
            "#icon-tianshi",
            "#icon-xianwen",
            "#icon-yiwen",
            "#icon-fendou"
        ];

        var icon_describle = [
            "啊",
            "闭嘴",
            "白眼",
            "爱心",
            "大惊",
            "呲牙",
            "大笑",
            "饿死",
            "发呆",
            "犯困",
            "尴尬",
            "愤怒",
            "汗颜",
            "惊恐",
            "好吃",
            "惊悚",
            "惊讶",
            "开心",
            "冷酷",
            "大闹",
            "流泪",
            "难过",
            "调皮",
            "星星眼",
            "酷",
            "坏笑",
            "天使",
            "献吻",
            "疑问",
            "奋斗"
        ];
        for (var i = 0; i < icon_alias.length; i++) {
            var pos = icon_alias[i];
            var des = icon_describle[i];
            var type = '<a iconNum="' + i + '" onclick="addIcon(' + i + ')" style="margin:1px 0.5px 0 0.5px; cursor:pointer;" title="' + des + '"><svg class="icon" style="border:1px solid #ccc;padding:2px 2px 2px 2px;" aria-hidden="true"><use xlink:href="' + pos + '"></use></svg></a>';
            $("#all_icon").append(type);
        }
    });

    //确定发布按钮点击事件
    $(".postBtn").click(function () {
        var Uid = '${user.id}';
        var content = $(".Input_text").html();
        if ('' === content) {
            layer.alert("内容不能为空");
            return ;
        } else {
            layer.confirm('确定提交吗?', {
                        btn: ['确定', '取消'] //选项按钮
                    }, function () {
                        //点击确定之后跳转的
                        $.ajax({
                            url: '/timeline/insertTimeLine',
                            method: 'POST',
                            dataType: 'JSON',
                            data: {'Uid': Uid, 'content': content},
                            async: false,
                            cache: false,
                            success: function (res) {
                                if ('success' === res) {
                                    layer.msg("添加时间轴成功,可进入个人发布中心查看!", {icon: 6,time: 2000});
                                    var index = parent.layer.getFrameIndex(window.name);
                                    setTimeout(function () {
                                        parent.layer.close(index);
                                    }, 2000);
                                } else {
                                    layer.alert("添加时间轴失败!,请联系管理员", {icon: 5});
                                }
                            },
                            error: function () {
                                layer.alert("连接服务器异常!,请联系管理员", {icon: 5});
                            }
                        });
                    },
                    function () {
                        layer.close();
                    });
        }
    });
</script>
</html>