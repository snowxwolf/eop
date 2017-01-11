<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>码表管理</title>
</head>
<body>
<div  class="easyui-panel" title="查询" style="height:100px"
      data-options="iconCls:'icon-search',closable:false,collapsible:true,fit:true">
    <form class="ef">
        <table class="et">

        </table>
    </form>
</div>
<table id="codes" class="easyui-datagrid">
</table>

<%--添加--%>
<div id="addCodeWin" class="easyui-dialog" title="添加" style="width:500px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-add',closable:true,closed:true,minimizable:false,modal:true,buttons:'#bb'">
    <form id="addCodeForm" class="ef" method="post">
        <table class="et">
            <tr>
                <th>
                    <label for="code">码表CODE:</label>
                </th>
                <td colspan="3">
                    <input id="code" class="easyui-validatebox" name="code" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="mname">码表名称:</label>
                </th>
                <td colspan="3">
                    <input id="mname" class="easyui-validatebox" name="cname" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="mvalue">码表值:</label>
                </th>
                <td colspan="3">
                    <input id="mvalue" class="easyui-validatebox" name="cvalue" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="corder">排序值:</label>
                </th>
                <td colspan="3">
                    <input id="corder" class="easyui-numberbox" name="corder" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="as">状态:</label>
                </th>
                <td colspan="3">
                    <select id="as" class="easyui-combobox" name="cstatus" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="bb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitCode();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('addCodeWin');">取消</a>
</div>
<%--修改--%>
<div id="updateCodeWin" class="easyui-dialog" title="修改" style="width:500px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-edit',closable:true,closed:true,minimizable:false,modal:true,buttons:'#up'">
    <form id="updateCodeForm" class="ef" method="post">
        <input type="hidden" name="cid">
        <table class="et">
            <tr>
                <th>
                    <label for="ucode">码表CODE:</label>
                </th>
                <td colspan="3">
                    <input id="ucode" class="easyui-validatebox" name="code" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="umname">码表名称:</label>
                </th>
                <td colspan="3">
                    <input id="umname" class="easyui-validatebox" name="cname" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="umvalue">码表值:</label>
                </th>
                <td colspan="3">
                    <input id="umvalue" class="easyui-validatebox" name="cvalue" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="uorder">排序值:</label>
                </th>
                <td colspan="3">
                    <input id="uorder" class="easyui-numberbox" name="corder" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="us">状态:</label>
                </th>
                <td colspan="3">
                    <select id="us" class="easyui-combobox" name="cstatus" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="up">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="updateCode();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('updateCodeWin');">取消</a>
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

        $('#codes').datagrid({
            url:'${pageContext.request.contextPath}/system/codes/listCodes.html',
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
            treeField:'name',
           /* loadFilter: function(data){
                var cs=data.cstatus;
                return cs==1?"启用":"禁用";
            } ,*/
            toolbar:[
                <shiro:hasPermission name="system:codes:add">
                {
                    iconCls: 'icon-add',
                    text:'添加',
                    handler: function(){
                      openDialog("addCodeWin");
                    }
                },'-',
                </shiro:hasPermission>
                <shiro:hasPermission name="system:codes:edit">
                {
                    iconCls: 'icon-edit',
                    text:'修改',
                    handler: function(){
                        var rows= $('#codes').datagrid('getSelections');
                        var leng=rows.length;
                        if(leng !=1 ){
                            warn("请选择1条记录.");
                            return;
                        }
                        $('#updateCodeForm').form('load',rows[0]);
                        openDialog("updateCodeWin");
                    }
                },'-',
                </shiro:hasPermission>
                <shiro:hasPermission name="system:codes:delete">
                {
                    iconCls: 'icon-remove',
                    text:'删除',
                    handler: function(){
                     var rows= $('#codes').datagrid('getSelections');
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
                                $.post('${pageContext.request.contextPath}/system/codes/delete.html',{ids:newId},function(data){
                                    var msg=data.restMsg;
                                       if(data.success){
                                           show(msg);
                                           $('#codes').datagrid('reload');
                                       }else{
                                           info(msg);
                                       }
                                       clearAllSelections("codes");
                                },"json");

                            }
                        });
                    }

                }
                </shiro:hasPermission>
            ],
            columns:[[
                {field:'ck',checkbox:true},
                {title:'id',field:'cid',width:100,align:'center',hidden:true},
                {title:'码表code',field:'code',width:100,align:'center'},
                {title:'码表名称',field:'cname',width:100,align:'center'},
                {title:'码表值',field:'cvalue',width:100,align:'center'},
                {field:'ctime',title:'创建时间',width:120,align:'center',sortable:true},
                {field:'cstatus',title:'状态',width:100,align:'center',formatter:function(value,row,index){
                    return value==1?"启用":"禁用";
                }}
            ]]
        });
    });

    function submitCode() {
      $('#addCodeForm').form('submit',{
          url:'${pageContext.request.contextPath}/system/codes/add.html',
          queryParams:$(this).serialize(),
          onSubmit: function(){
              var isValid = $(this).form('validate');
              return isValid;	// 返回false终止表单提交
          },
          success:function(data){
              var data = eval('(' + data + ')');
              var msg=data.restMsg;
              if(data.success){
                    closeDialog('addCodeWin');
                    show(msg);
                    $('#codes').datagrid('reload');
              }else{
                   error(msg);
              }
          }
      });
    }
    //修改
    function updateCode(){
        $('#updateCodeForm').form('submit',{
            url:'${pageContext.request.contextPath}/system/codes/update.html',
            queryParams:$(this).serialize(),
            onSubmit: function(){
                var isValid = $(this).form('validate');
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                var data = eval('(' + data + ')');
                var msg=data.restMsg;
                if(data.success){
                    closeDialog('updateCodeWin');
                    show(msg);
                    $('#codes').datagrid('reload');
                }else{
                    error(msg);
                }
            }

        });
    }
</script>
</html>
