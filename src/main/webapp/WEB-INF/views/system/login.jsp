
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>登录</title>
</head>
<body>
<div id="w" class="easyui-window" title="登录" data-options="modal:true,iconCls:'Lockgo',closable:false,minimizable:false" style="width:400px;padding:20px 70px 20px 70px;">
    <form id="loginForm" method="post">
    <div style="margin-bottom:10px">
        <input class="easyui-textbox" id="name" name="name" style="width:100%;height:30px;padding:12px" data-options="prompt:'用户名',iconCls:'icon-man',required:true,iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" id="logpass" name="passwd" type="password" style="width:100%;height:30px;padding:12px" data-options="prompt:'密码',iconCls:'icon-lock',required:true,iconWidth:38">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" type="text" name="code" style="width:50%;height:30px;padding:12px" data-options="prompt:'验证码',required:true,validType:'length[0,4]'"> <a href="javascript:;" class="showcode" onclick="geneCode()"><img  id="checkCode" style=" margin:0 0 0 3px ; vertical-align:middle; height:26px;" src="checkCode.html"></a>
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
    </form>


</div>
<script src="${pageContext.request.contextPath}/static/js/system/login.js"></script>
</body>
</html>
