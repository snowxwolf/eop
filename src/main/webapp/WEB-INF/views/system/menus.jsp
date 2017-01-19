<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>菜单管理</title>
</head>
<body >
<div>
    <div id="searchTool">


         <shiro:hasPermission name="system:codes:add">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="openDialog('addMenuWin');">添加</a>
         </shiro:hasPermission>
         <shiro:hasPermission name="system:codes:update">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="openUpdateMenus();">修改</a>
         </shiro:hasPermission>

          <shiro:hasPermission name="system:codes:delete">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="deleteMenus();">删除</a>
          </shiro:hasPermission>
    </div>
   <table id="menus" class="easyui-datagrid">

   </table>
</div>
<%--添加--%>
<div id="addMenuWin" class="easyui-dialog" title="添加" style="width:550px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-add',closable:true,closed:true,minimizable:false,modal:true,buttons:'#bb'">
    <form id="addMenuForm" class="ef" method="post">
        <table class="et">
            <tr>
                <th>
                    <label for="code">菜单名称:</label>
                </th>
                <td colspan="3">
                    <input id="code" class="easyui-validatebox" name="mname" data-options="required:true,validType:'length[0,20]'" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="mname">菜单图标:</label>
                </th>
                <td colspan="3">
                    <input id="mname" class="easyui-validatebox" data-options="required:false,validType:'length[0,20]'" name="icon" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="pmenu">是否父菜单:</label>
                </th>
                <td colspan="3">
                    <input id="pmenu" name="parent" style="width:250px;">
                </td>
            </tr>
            <tr id="apcodeTr" style="display:none;">
                <th>
                    <label for="apcode">父菜单:</label>
                </th>
                <td colspan="3">
                    <input id="apcode"  name="pcode" style="width:250px;"/>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="url">链接:</label>
                </th>
                <td colspan="3">
                    <input id="url" class="easyui-validatebox" name="murl" data-options="required:true,validType:'length[0,50]'" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="corder">排序值:</label>
                </th>
                <td colspan="3">
                    <input id="corder" class="easyui-numberbox" name="orderValue" data-options="required:true,validType:'length[0,3]'" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="as">状态:</label>
                </th>
                <td colspan="3">
                    <select id="as" class="easyui-combobox" name="mstatus" data-options="required:true" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="bb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitMenu();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('addMenuWin');">取消</a>
</div>
<%--修改--%>
<div id="updateMenuWin" class="easyui-dialog" title="修改" style="width:500px;height:400px;padding: 30px 60px"
     data-options="iconCls:'icon-edit',closable:true,closed:true,minimizable:false,modal:true,buttons:'#up'">
    <form id="updateMenuForm" class="ef" method="post">
        <input type="hidden" name="mid">
        <input type="hidden" name="mcode">
        <table class="et">
            <tr>
                <th>
                    <label for="ucode">菜单名称:</label>
                </th>
                <td colspan="3">
                    <input id="ucode" class="easyui-validatebox" name="mname" data-options="required:true,validType:'length[0,20]'" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="umname">菜单图标:</label>
                </th>
                <td colspan="3">
                    <input id="umname" class="easyui-validatebox" data-options="required:false,validType:'length[0,20]'" name="icon" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="upmenu">是否父菜单:</label>
                </th>
                <td colspan="3">
                    <input id="upmenu" name="parent" style="width:250px;">
                </td>
            </tr>
            <tr id="upcodeTr" style="display:none;">
                <th>
                    <label for="upcode">父菜单:</label>
                </th>
                <td colspan="3">
                    <input id="upcode"  name="pcode" style="width:250px;"/>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="uurl">链接:</label>
                </th>
                <td colspan="3">
                    <input id="uurl" class="easyui-validatebox" name="murl" data-options="required:true,validType:'length[0,50]'" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="uorder">排序值:</label>
                </th>
                <td colspan="3">
                    <input id="uorder" class="easyui-numberbox" name="orderValue" data-options="required:true,validType:'length[0,3]'" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="us">状态:</label>
                </th>
                <td colspan="3">
                    <select id="us" class="easyui-combobox" name="mstatus" data-options="required:true" style="width:250px;">
                        <option value="1">启用</option>
                        <option value="0">禁用</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="up">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="updateMenus();">提交</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('updateMenuWin');">取消</a>
</div>

</body>
<script>
    $(function(){
        /*$(window).resize(function () {
         $('#menus').datagrid('resize', {
         width: $(window).width() - 10,
         height: $(window).height() - 35
         });
         });*/

        $('#menus').treegrid({
            url:'${pageContext.request.contextPath}/system/menus/getMenusList.html',
            rownumbers:true,
            checkOnSelect:true,
            nowrap: true,
            singleSelect:false,
            striped: true,
            fitColumns: true,
            animate:true,
            idField:'mid',
            treeField:"mname",
            emptyMsg:'暂无记录',
            toolbar:'#searchTool',
            columns:[[
                {field:'ck',checkbox:true},
                {title:'mid',field:'cid',width:100,align:'center',hidden:true},
                {title:'mcode',field:'mcode',width:100,align:'center',hidden:true},
                {title:'菜单名称',field:'mname',width:100,align:'center'},
                {title:'图标',field:'icon',width:100,align:'center'},
                {title:'排序值',field:'orderValue',width:100,align:'center'},
                {title:'链接',field:'murl',width:140,align:'center'},
                {field:'mstatus',title:'状态',width:100,align:'center',formatter:function(value,row,index){
                    return value==1?"启用":"禁用";
                }}
            ]]
        });

        $.post('${pageContext.request.contextPath}/system/menus/getParentMenus.html',function(data) {
            $('#apcode').combobox({
                data:data,
                valueField:'id',
                textField:'text'
            });
            $('#upcode').combobox({
                data:data,
                valueField:'id',
                textField:'text'
            });

        },"json");


        //初始化父菜单
        $('#pmenu').combobox({
            valueField:'id',
            textField:'text' ,
            data:[{id:1,text:'是'},{id:0,text:'否'}],
            onSelect:function (r) {
                 if(r.id==0){
                        $("#apcodeTr").show();
                 } else{
                     $("#apcodeTr").hide();
                 }
            }
        });
        $('#pmenu').combobox('setValue',0);

        $('#upmenu').combobox({
            valueField:'id',
            textField:'text' ,
            data:[{id:1,text:'是'},{id:0,text:'否'}],
            onSelect:function (r) {
                if(r.id==0){
                    $("#upcodeTr").show();
                } else{
                    $("#upcodeTr").hide();
                }
            }
        });


    });

    //打开修改dialog
     function openUpdateMenus() {
         var rows= $('#menus').datagrid('getSelections');
         var leng=rows.length;
         if(leng !=1 ){
             warn("请选择1条记录.");
             return;
         }
         $('#updateMenuForm').form('load',rows[0]);
         openDialog("updateMenuWin");
     }
      //删除
     function deleteMenus(){
         var rows= $('#menus').datagrid('getSelections');
         var ids='';
         $.each(rows,function (i,n) {
             ids+=n.mid+",";
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
                 $.post('${pageContext.request.contextPath}/system/menus/delete.html',{ids:newId},function(data){
                     var msg=data.restMsg;
                     if(data.success){
                         show(msg);
                         $('#menus').treegrid('reload');
                     }else{
                         info(msg);
                     }
                     clearAllSelections("menus");
                 },"json");

             }
         });
     }
     //提交添加
    function submitMenu() {
      $('#addMenuForm').form('submit',{
          url:'${pageContext.request.contextPath}/system/menus/add.html',
          queryParams:$(this).serialize(),
          onSubmit: function(){
              var isValid = $(this).form('validate');
              return isValid;	// 返回false终止表单提交
          },
          success:function(data){
              var data = eval('(' + data + ')');
              var msg=data.restMsg;
              if(data.success){
                    closeDialog('addMenuWin');
                    show(msg);
                    $('#menus').treegrid('reload');
              }else{
                   error(msg);
              }
          }
      });
    }
    //修改
    function updateMenus(){
        $('#updateMenuForm').form('submit',{
            url:'${pageContext.request.contextPath}/system/menus/update.html',
            queryParams:$(this).serialize(),
            onSubmit: function(){
                var isValid = $(this).form('validate');
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                var data = eval('(' + data + ')');
                var msg=data.restMsg;
                if(data.success){
                    closeDialog('updateMenuWin');
                    show(msg);
                    $('#menus').treegrid('reload');
                }else{
                    error(msg);
                }
            }

        });
    }



</script>
</html>
