<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>用户管理</title>
</head>
<body >
<div>
    <div id="searchTool">

        <div  style="height: 30px;" >
            <form id="searchForm" method="post">
                <span>码表code:</span>
                <input type="text"  class="easyui-validatebox" name="code"/>

                <span>码表状态:</span>
                <select class="easyui-combobox" name="cstatus" data-options="required:true" style="width:250px;">
                    <option value="1">启用</option>
                    <option value="0">禁用</option>
                </select>

                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="queryUser();">提交</a>
                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="formReset('searchForm');">重置</a>
            </form>
        </div>

        <shiro:hasPermission name="system:codes:add">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-user-add'" onclick="openDialog('addUserWin');">添加</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="system:codes:update">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-user-edit'" onclick="openUpdateUser();">修改</a>
        </shiro:hasPermission>

        <shiro:hasPermission name="system:codes:delete">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-user-delete'" onclick="deleteUser();">删除</a>
        </shiro:hasPermission>
    </div>
    <table id="user" class="easyui-datagrid"  toolbar="#search">

    </table>
</div>
<%--添加--%>
<div id="addUserWin" class="easyui-dialog" title="添加" style="width:500px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-add',closable:true,closed:true,minimizable:false,modal:true,buttons:'#bb'">
    <form id="addUserForm" class="ef" method="post">
        <table class="et">
            <tr>
                <th>
                    <label for="code">码表CODE:</label>
                </th>
                <td colspan="3">
                    <input id="code" class="easyui-validatebox" name="code" data-options="required:true,validType:'length[0,20]'" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="mname">码表名称:</label>
                </th>
                <td colspan="3">
                    <input id="mname" class="easyui-validatebox" data-options="required:true,validType:'length[0,10]'" name="cname" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="mvalue">码表值:</label>
                </th>
                <td colspan="3">
                    <input id="mvalue" class="easyui-validatebox" name="cvalue" data-options="required:true,validType:'length[0,60]'" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="corder">排序值:</label>
                </th>
                <td colspan="3">
                    <input id="corder" class="easyui-numberbox" name="corder" data-options="required:true,validType:'length[0,3]'" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="adescr">描述:</label>
                </th>
                <td colspan="3">
                    <input id="adescr" class="easyui-textbox" name="descr" data-options="multiline:true,required:true,validType:'length[0,40]'" style="width:250px;height: 50px;"/>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="as">状态:</label>
                </th>
                <td colspan="3">
                    <select id="as" class="easyui-combobox" name="cstatus" data-options="required:true" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="bb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitUser();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('addUserWin');">取消</a>
</div>
<%--修改--%>
<div id="updateUserWin" class="easyui-dialog" title="修改" style="width:500px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-edit',closable:true,closed:true,minimizable:false,modal:true,buttons:'#up'">
    <form id="updateUserForm" class="ef" method="post">
        <input type="hidden" name="cid">
        <table class="et">
            <tr>
                <th>
                    <label for="ucode">码表CODE:</label>
                </th>
                <td colspan="3">
                    <input id="ucode" class="easyui-validatebox" name="code" data-options="required:true,validType:'length[0,20]'" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="umname">码表名称:</label>
                </th>
                <td colspan="3">
                    <input id="umname" class="easyui-validatebox" name="cname" data-options="required:true,validType:'length[0,20]'" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="umvalue">码表值:</label>
                </th>
                <td colspan="3">
                    <input id="umvalue" class="easyui-validatebox" name="cvalue" data-options="required:true,validType:'length[0,60]'" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="uorder">排序值:</label>
                </th>
                <td colspan="3">
                    <input id="uorder" class="easyui-numberbox" name="corder" data-options="required:true,validType:'length[0,3]'" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="udescr">描述:</label>
                </th>
                <td colspan="3">
                    <input id="udescr" class="easyui-textbox" name="descr" data-options="multiline:true,required:true,validType:'length[0,40]'" style="width:250px;height: 50px;"/>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="us">状态:</label>
                </th>
                <td colspan="3">
                    <select id="us" class="easyui-combobox" name="cstatus" data-options="required:true" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="up">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="updateUser();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('updateUserWin');">取消</a>
</div>

</body>
<script>
    $(function(){
        /*$(window).resize(function () {
         $('#codes').datagrid('resize', {
         width: $(window).width() - 10,
         height: $(window).height() - 35
         });
         });*/

        $('#user').datagrid({
            url:'${pageContext.request.contextPath}/system/user/listUser.html',
            pagination:true,
            rownumbers:true,
            checkOnSelect:true,
            pageNumber:1,
            pageSize:10,
            pageList:[10,20,30,50],
            nowrap: true,
            singleSelect:false,
            striped: true,
            fitColumns: true,
            animate:true,
            idField:'cid',
            emptyMsg:'暂无记录',
            toolbar:'#searchTool',
            columns:[[
                {field:'ck',checkbox:true},
                {title:'用户code',field:'ucode',width:180,align:'center'},
                {title:'用户名称',field:'uname',width:180,align:'center'},
                {field:'ctime',title:'创建时间',width:60,align:'center'},
                {field:'ustatus',title:'状态',width:100,align:'center',formatter:function(value,row,index){
                    return value==1?"启用":"禁用";
                }}
            ]]
        });
    });

    //打开修改dialog
    function openUpdateUser() {
        var rows= $('#user').datagrid('getSelections');
        var leng=rows.length;
        if(leng !=1 ){
            warn("请选择1条记录.");
            return;
        }
        $('#updateUserForm').form('load',rows[0]);
        openDialog("updateUserWin");
    }
    //删除
    function deleteUser(){
        var rows= $('#user').datagrid('getSelections');
        var ids='';
        $.each(rows,function (i,n) {
            ids+=n.cid+",";
        });
        var leng=ids.length;
        var newId= ids.substr(0,leng-1);
        var newAry= newId.split(",");
        var nlen=newId.length;
        if(nlen<1){
            warn("请选择要删除的记录.");
            return;
        }
        var infoLen=newAry.length;
        $.messager.confirm('确认','您确认要删除这'+infoLen+'条记录吗?',function(r){
            if (r){
                $.post('${pageContext.request.contextPath}/system/user/delete.html',{ids:newId},function(data){
                    var msg=data.restMsg;
                    if(data.success){
                        show(msg);
                        $('#user').datagrid('reload');
                    }else{
                        info(msg);
                    }
                    clearAllSelections("user");
                },"json");

            }
        });
    }
    //提交添加
    function submitUser() {
        $('#addUserForm').form('submit',{
            url:'${pageContext.request.contextPath}/system/user/add.html',
            queryParams:$(this).serialize(),
            onSubmit: function(){
                var isValid = $(this).form('validate');
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                var data = eval('(' + data + ')');
                var msg=data.restMsg;
                if(data.success){
                    closeDialog('addUserWin');
                    show(msg);
                    $('#user').datagrid('reload');
                }else{
                    error(msg);
                }
            }
        });
    }
    //修改
    function updateUser(){
        $('#updateUserForm').form('submit',{
            url:'${pageContext.request.contextPath}/system/user/update.html',
            queryParams:$(this).serialize(),
            onSubmit: function(){
                var isValid = $(this).form('validate');
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                var data = eval('(' + data + ')');
                var msg=data.restMsg;
                if(data.success){
                    closeDialog('updateUserWin');
                    show(msg);
                    $('#user').datagrid('reload');
                }else{
                    error(msg);
                }
            }

        });
    }
    //将表单数据转为json
    function form2Json(id) {

        var arr = $("#" + id).serializeArray()
        var jsonStr = "";

        jsonStr += '{';
        for (var i = 0; i < arr.length; i++) {
            jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
        }
        jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
        jsonStr += '}'

        var json = JSON.parse(jsonStr)
        return json
    }

    //查询
    function queryUser() {
        // var data=$('#searchForm').serialize();
        var data=form2Json('searchForm');
        $('#user').datagrid({
            queryParams:data
        });


    }
</script>
</html>
