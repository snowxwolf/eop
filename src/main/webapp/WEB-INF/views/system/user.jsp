<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>用户管理</title>
</head>
<body>
<div  class="easyui-panel" title="查询" data-options="iconCls:'icon-search',closable:false,collapsible:true">
    <form class="ef">
        <table class="et">

        </table>
    </form>
</div>
<table id="user" class="easyui-datagrid">

</table>
    <script>
        $(function(){
            $('#user').datagrid({
                url:'${pageContext.request.contextPath}/system/user/listUser.html',
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
                idField:'ucode',
                treeField:'uname',
                toolbar:[
                    <shiro:hasPermission name="system:user:add">
                    {
                        iconCls: 'icon-add',
                        text:'添加',
                        handler: function(){

                        }
                    },'-',
                    </shiro:hasPermission>
                    <shiro:hasPermission name="system:user:edit">
                    {
                        iconCls: 'icon-edit',
                        text:'修改',
                        handler: function(){

                        }
                    },'-',
                    </shiro:hasPermission>
                    <shiro:hasPermission name="system:user:delete">
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
                    {title:'用户code',field:'ucode',width:180,align:'center'},
                    {title:'用户名称',field:'uname',width:180,align:'center'},
                    {field:'ctime',title:'创建时间',width:60,align:'center'},
                    {field:'ustatus',title:'状态',width:60,align:'center'}
                ]]
            });
        });
    </script>
</body>
</html>
