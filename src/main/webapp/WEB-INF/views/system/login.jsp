
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>登录</title>
</head>
<body>
<div id="w" class="easyui-window" title="请先登录" data-options="modal:true,iconCls:'Lockgo',closable:false,minimizable:false" style="width:400px;padding:20px 70px 20px 70px;">

    <div style="margin-bottom:10px">
        <input class="easyui-textbox" id="logname" style="width:100%;height:30px;padding:12px" data-options="prompt:'登录邮箱',iconCls:'icon-man',iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" id="logpass" type="password" style="width:100%;height:30px;padding:12px" data-options="prompt:'登录密码',iconCls:'icon-lock',iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" type="text" id="logyzm" style="width:50%;height:30px;padding:12px" data-options="prompt:'验证码'"> <a href="javascript:;" class="showcode" onclick="changeVeryfy()"><img style=" margin:0 0 0 3px ; vertical-align:middle; height:26px;" src="checkCode.html"></a>
    </div>
    <%--<div style="margin-bottom:20px">
        <input type="checkbox" checked="checked" id="logrem">
        <span>Remember me</span>
    </div>--%>
    <div>
        <a href="javascript:;" onclick="login()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
            <span style="font-size:14px;">登录</span>
        </a>
    </div>



</div>
</body>
</html>
