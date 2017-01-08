<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>码表管理</title>
</head>
<body>
<div  class="easyui-panel" title="查询" data-options="iconCls:'icon-search',closable:false,collapsible:true">
    <form class="ef">
        <table class="et">

        </table>
    </form>
</div>
<table id="codes" class="easyui-datagrid">
</table>
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
             pageSize:10,
             pageList:[10,20,30,50],
             nowrap: false,
             singleSelect:false,
             striped: true,
             fitColumns: true,
             animate:true,
             idField:'cid',
             treeField:'name',
             toolbar:[
               <shiro:hasPermission name="system:codes:add">
                 {
                 iconCls: 'icon-add',
                 text:'添加',
                 handler: function(){

                 }
                },'-',
              </shiro:hasPermission>
              <shiro:hasPermission name="system:codes:edit">
                 {
                     iconCls: 'icon-edit',
                     text:'修改',
                     handler: function(){

                     }
                 },'-',
                 </shiro:hasPermission>
                <shiro:hasPermission name="system:codes:delete">
                  {
                     iconCls: 'icon-remove',
                     text:'删除',
                     handler: function(){

                     }
                 }
                 </shiro:hasPermission>
             ],
             columns:[[
                 {field:'ck',checkbox:true},
                 {title:'码表code',field:'code',width:100,align:'center'},
                 {title:'码表名称',field:'cname',width:100,align:'center'},
                 {title:'码表值',field:'cvalue',width:100,align:'center'},
                 {field:'ctime',title:'创建时间',width:160,align:'center',sortable:true},
                 {field:'cstatus',title:'状态',width:60,align:'center',formatter:function(value,row,index){
                      return value==1?"启用":"禁用";
                 }}
             ]]
         });
     });

 </script>
</body>
</html>
