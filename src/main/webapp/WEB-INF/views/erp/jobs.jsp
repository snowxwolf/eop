<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <jsp:include page="../system/common.jsp"/>
    <title>职位管理</title>
</head>
<body >
<div>
    <div id="searchTool">

        <div  style="height: 30px;" >
            <form id="searchForm" method="post">
                <span>职位名称:</span>
                <input type="text"  class="easyui-validatebox" name="jname"/>

                <span>状态:</span>
                <select class="easyui-combobox" name="state" data-options="required:true" style="width:250px;">
                    <option value="1">启用</option>
                    <option value="0">禁用</option>
                </select>

                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="queryJob();">提交</a>
                <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="formReset('searchForm');">重置</a>
            </form>
        </div>

       <%-- <shiro:hasPermission name="erp:codes:add">--%>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-user-add'" onclick="openDialog('addJobWin');">添加</a>
        <%--</shiro:hasPermission>
        <shiro:hasPermission name="erp:codes:update">--%>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-user-edit'" onclick="openUpdateJob();">修改</a>
      <%--  </shiro:hasPermission>

        <shiro:hasPermission name="erp:codes:delete">--%>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-user-delete'" onclick="deleteJob();">删除</a>
        <%--</shiro:hasPermission>--%>
    </div>
    <table id="jobs" class="easyui-datagrid"  toolbar="#search">

    </table>
</div>
<%--添加--%>
<div id="addJobWin" class="easyui-dialog" title="添加" style="width:500px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-add',closable:true,closed:true,minimizable:false,modal:true,buttons:'#bb'">
    <form id="addJobForm" class="ef" method="post">
        <table class="et">
            <tr>
                <th>
                    <label for="aname">职位名称:</label>
                </th>
                <td colspan="3">
                    <input id="aname" class="easyui-validatebox" name="jname" data-options="required:true,validType:'length[0,20]'" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="descr">描述:</label>
                </th>
                <td colspan="3">
                    <input id="descr" class="easyui-textbox" name="descr" data-options="multiline:true,required:true,validType:'length[0,40]'" style="width:250px;height: 50px;"/>
                </td>
            </tr>

            <tr>
                <th>
                    <label for="as">状态:</label>
                </th>
                <td colspan="3">
                    <select id="as" class="easyui-combobox" name="state" data-options="required:true" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="bb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitJob();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('addJobWin');">取消</a>
</div>
<%--修改--%>
<div id="updateJobWin" class="easyui-dialog" title="修改" style="width:500px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-edit',closable:true,closed:true,minimizable:false,modal:true,buttons:'#up'">
    <form id="updateJobForm" class="ef" method="post">
        <input type="hidden" name="jid">
        <table class="et">
            <tr>
                <th>
                    <label for="uname">角色名称:</label>
                </th>
                <td colspan="3">
                    <input id="uname" class="easyui-validatebox" name="jname" data-options="required:true,validType:'length[0,20]'" style="width:250px;">
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
                    <label for="us">状态:</label>
                </th>
                <td colspan="3">
                    <select id="us" class="easyui-combobox" name="state" data-options="required:true" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="up">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="updateJob();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('updateJobWin');">取消</a>
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

        $('#jobs').datagrid({
            url:'${pageContext.request.contextPath}/erp/jobs/listJobs.html',
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
            idField:'rid',
            emptyMsg:'暂无记录',
            toolbar:'#searchTool',
            columns:[[ {field:'ck',checkbox:true},
                {title:'jid',field:'jid',width:180,align:'center',hidden:true},
                {title:'CODE',field:'jcode',width:180,align:'center',hidden:true},
                {title:'职位名称',field:'jname',width:180,align:'center'},
                {field:'descr',title:'简介',width:60,align:'center'},
                {field:'state',title:'状态',width:60,align:'center',formatter:function(value,row,index){
                    return value==1?"启用":"禁用";
                }}
            ]]
        });
    });

    //打开修改dialog
    function openUpdateJob() {
        var rows= $('#jobs').datagrid('getSelections');
        var leng=rows.length;
        if(leng !=1 ){
            warn("请选择1条记录.");
            return;
        }
        $('#updateJobForm').form('load',rows[0]);
        openDialog("updateJobWin");
    }
    //删除
    function deleteJob(){
        var rows= $('#jobs').datagrid('getSelections');
        var ids='';
        $.each(rows,function (i,n) {
            ids+=n.jid+",";
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
                $.post('${pageContext.request.contextPath}/erp/jobs/delete.html',{ids:newId},function(data){
                    var msg=data.restMsg;
                    if(data.success){
                        show(msg);
                        $('#jobs').datagrid('reload');
                    }else{
                        info(msg);
                    }
                    clearAllSelections("jobs");
                },"json");

            }
        });
    }
    //提交添加
    function submitJob() {
        $('#addJobForm').form('submit',{
            url:'${pageContext.request.contextPath}/erp/jobs/add.html',
            queryParams:$(this).serialize(),
            onSubmit: function(){
                var isValid = $(this).form('validate');
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                var data = eval('(' + data + ')');
                var msg=data.restMsg;
                if(data.success){
                    closeDialog('addJobWin');
                    show(msg);
                    $('#jobs').datagrid('reload');
                }else{
                    error(msg);
                }
            }
        });
    }
    //修改
    function updateJob(){
        $('#updateJobForm').form('submit',{
            url:'${pageContext.request.contextPath}/erp/jobs/update.html',
            queryParams:$(this).serialize(),
            onSubmit: function(){
                var isValid = $(this).form('validate');
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                var data = eval('(' + data + ')');
                var msg=data.restMsg;
                if(data.success){
                    closeDialog('updateJobWin');
                    show(msg);
                    $('#jobs').datagrid('reload');
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
    function queryJob() {
        // var data=$('#searchForm').serialize();
        var data=form2Json('searchForm');
        $('#jobs').datagrid({
            queryParams:data
        });


    }
</script>
</html>
