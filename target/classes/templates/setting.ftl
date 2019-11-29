<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Aurora>修改信息</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script type="text/javascript" src="../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../static/layui/layui.js"></script>
</head>
<body>
<div style="margin-left:24%;">
    <div class="form_main">
        <form class="layui-form">
        <div class="layui-form-item">
                <#if user??>
                <#if (user.userRole)==1>
                    <label class="layui-form-label">学 号</label>
                <#else>
                     <label class="layui-form-label">工 号</label>
                </#if>

                    <div class="layui-input-inline">
                        <input type="text" value="${user.userId}" name="userId" lay-verify="required"
                               class="layui-input" disabled="disabled">
                    </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" name="userName" lay-verify="required"
                           value="${user.userName}" class="layui-input" disabled="disabled">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">密 码</label>
                <div class="layui-input-inline">
                    <input type="password" name="userPwd"
                           lay-verify="required" value="${user.userPwd}"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">手机号</label>
                <div class="layui-input-inline">
                    <input type="text" name="userPhone" value="${user.userPhone}"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">学院</label>
                <div class="layui-input-block" style="width: 300px;">
                    <select name="userCollege" lay-verify="required">
                        <option <#if (user.userCollege)=='软件学院'>selected="selected"</#if> value="软件学院">软件学院</option>
                        <option <#if (user.userCollege)=='政法学院'>selected="selected"</#if> value="政法学院">政法学院</option>
                        <option <#if (user.userCollege)=='体育学院'>selected="selected"</#if> value="体育学院">体育学院</option>
                        <option <#if (user.userCollege)=='外国语学院'>selected="selected"</#if> value="外国语学院">外国语学院</option>
                        <option <#if (user.userCollege)=='艺术设计学院'>selected="selected"</#if> value="艺术设计学院">艺术设计学院
                        </option>
                        <option <#if (user.userCollege)=='机电工程学院'>selected="selected"</#if> value="机电工程学院">机电工程学院
                        </option>
                        <option <#if (user.userCollege)=='国际教育学院'>selected="selected"</#if> value="国际教育学院">国际教育学院
                        </option>
                        <option <#if (user.userCollege)=='继续教育学院'>selected="selected"</#if> value="继续教育学院">继续教育学院
                        </option>
                        <option <#if (user.userCollege)=='马克思主义学院'>selected="selected"</#if> value="马克思主义学院">马克思主义学院
                        </option>
                        <option <#if (user.userCollege)=='经济与管理学院'>selected="selected"</#if> value="经济与管理学院">经济与管理学院
                        </option>
                        <option <#if (user.userCollege)=='电子信息工程学院'>selected="selected"</#if> value="电子信息工程学院">
                            电子信息工程学院
                        </option>
                        <option <#if (user.userCollege)=='电气信息工程学院'>selected="selected"</#if> value="电气信息工程学院">
                            电气信息工程学院
                        </option>
                        <option <#if (user.userCollege)=='建筑环境工程学院'>selected="selected"</#if> value="建筑环境工程学院">
                            建筑环境工程学院
                        </option>
                        <option <#if (user.userCollege)=='数学与信息科学学院'>selected="selected"</#if> value="数学与信息科学学院">
                            数学与信息科学学院
                        </option>
                        <option <#if (user.userCollege)=='能源与动力工程学院'>selected="selected"</#if> value="能源与动力工程学院">
                            能源与动力工程学院
                        </option>
                        <option <#if (user.userCollege)=='食品与生物工程学院'>selected="selected"</#if> value="食品与生物工程学院">
                            食品与生物工程学院
                        </option>
                        <option <#if (user.userCollege)=='烟草科学与工程学院'>selected="selected"</#if> value="烟草科学与工程学院">
                            烟草科学与工程学院
                        </option>
                        <option <#if (user.userCollege)=='材料与化学工程学院'>selected="selected"</#if> value="材料与化学工程学院">
                            材料与化学工程学院
                        </option>
                        <option <#if (user.userCollege)=='物理与电子工程学院'>selected="selected"</#if> value="物理与电子工程学院">
                            物理与电子工程学院
                        </option>
                        <option <#if (user.userCollege)=='计算机与通信工程学院'>selected="selected"</#if> value="计算机与通信工程学院">
                            计算机与通信工程学院
                        </option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item" style="position: relative; right: 6%;">
                <label for="select_op" class="layui-form-label" style="width: 120px;">找回密码问题</label>
                <div class="layui-input-inline">
                    <select name="problemId" id="select_op" lay-verify="required" required>
                        <option value="">请选择</option>
                        <optgroup label="学生时代">
                             <#list problemFirst as problem>
                                 <option value="${problem.problemId}"
                                    <#if (problem.problemId)=(user.problemId)>selected</#if> >${problem.problemName}</option>
                             </#list>
                        </optgroup>

                        <optgroup label="情感岁月">
                              <#list problemSecond as problem>
                                  <option value="${problem.problemId}"
                                        <#if (problem.problemId)=(user.problemId)>selected</#if> >${problem.problemName}</option>
                              </#list>
                        </optgroup>

                    </select>
                </div>
            </div>

            <div class="layui-form-item" style="position: relative; right: 6%;">
                <label class="layui-form-label" style="width: 120px;">问题答案</label>
                <div class="layui-input-inline">
                    <input type="text" name="problemAnswer"
                           lay-verify="required" value="${user.problemAnswer}"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline"
                     style="position: relative; left: 5%;">
                    <input type="radio" name="userSex" value="男" title="男" checked>
                    <input type="radio" name="userSex" value="女" title="女">
                </div>
            </div>


            <div class="layui-form-item" style="position: relative; left: 5%;">
                <div class="layui-input-block">
                    <button class="layui-btn" style="position: relative; right: 7%;"
                            lay-submit lay-filter="user_submit">立即提交
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
                </#if>
        </div>
            <input type="hidden" value="${user.id}" name="id"/>
            <input type="hidden" value="${user.userRole}" name="userRole"/>
            <#if (user.userImg)??>
            <!-- 如果用户头像不为空-->
            <input type="hidden" value="${user.userImg}" name="userImg"/>
            <#else>
            <!-- 如果用户头像为空-->
            </#if>
            <input type="hidden" value="${user.unreadMessage}" name="unreadMessage"/>
            <input type="hidden" value="${user.postCollectionNum}" name="postCollectionNum"/>
            <input type="hidden" value="${user.focusNumber}" name="focusNumber"/>
        </form>
    </div>
</div>
</body>
<script>
    $(function () {
        $("input[disabled='disabled']").css("background-color", "#E8EAED");
    })
</script>
<script type="text/javascript">
    //相当于java的main是layui的入口，使用哪个模块就在下面layui.use方框里写
    layui.use(['layer', 'form', 'jquery'], function () {
        var layer = layui.layer;
        var form = layui.form;
        var $ = layui.jquery;
        //监听提交
        form.on('submit(user_submit)', function (data) {
            var filed = data.field;
            var problemId = data.field.problemId;
            if (problemId === "") {
                //如果没有选择问题，则跳出
                layer.msg("请选择密码找回问题，并回答", {icon: 5});
                return;
            }
            $.ajax({
                method: "post",
                url: "/user/update",
                data: filed,
                dataType: "json",
                async: false,
                cache: false,
                success: function (res) {
                    if ('success' === res) {
                        layer.msg("修改成功", {icon: 6, time: 2000});
                        var index = parent.layer.getFrameIndex(window.name);
                        setTimeout(function () {
                            parent.layer.close(index);
                        }, 1000);
                    }
                    else {
                        layer.msg("修改失败", {anim: 6, icon: 5, time: 2000});
                    }
                },
                error: function (res) {
                    layer.msg("连接服务器失败!", {icon: 5});
                }
            });
            return false;
        });
    });
</script>
</html>