
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>角色管理</title>
    <jsp:include page="common.jsp"/>
</head>
<body>
<div  class="easyui-panel" title="查询" data-options="iconCls:'icon-search',closable:false,collapsible:true">
    <form class="ef">
      <table class="et">

      </table>
    </form>
</div>

<table id="roles" class="easyui-datagrid">
</table>
<script>
    $(function(){
        $('#roles').datagrid({
            url:'${pageContext.request.contextPath}/system/roles/rolesList.html',
            height:450,
            pagination:true,
            height:400,
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
                <shiro:hasPermission name="system:roles:add">
                {
                    iconCls: 'icon-add',
                    text:'添加',
                    handler: function(){

                    }
                },'-',
                </shiro:hasPermission>
                <shiro:hasPermission name="system:roles:edit">
                {
                    iconCls: 'icon-edit',
                    text:'修改',
                    handler: function(){

                    }
                },'-',
                </shiro:hasPermission>
                <shiro:hasPermission name="system:roles:delete">
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
                {title:'角色CODE',field:'rcode',width:180,align:'center'},
                {title:'角色名称',field:'rname',width:180,align:'center'},
                {title:'角色值',field:'rpcode',width:180,align:'center'},
                {field:'rtime',title:'创建时间',width:60,align:'center'},
                {field:'rstatus',title:'状态',width:60,align:'center'}
            ]]
        });
    });
</script>
</body>
</html>
