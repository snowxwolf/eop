<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div data-options="region:'north'" >

	<span style="padding-left:10px;float:left; font-size: 16px; "><img src="" width="20" height="20" />进销存</span>

	<span style="float:right; padding-right:20px;" class="head">欢迎您,<c:if test="${ empty user.username}">游客</c:if>
        <c:if test="${ not empty user.username}">${user.username}</c:if>

      <a href="javascript:void(0)" id="mb" class="easyui-menubutton"
		 data-options="menu:'#mm',iconCls:'icon-edit'">个人中心</a>

	<div id="mm" style="width:150px;">
       <div data-options="iconCls:'icon-redo'">
        <a onclick="updatePasswd();">修改密码</a>
       </div>

      <div class="menu-sep"></div>

      <div data-options="iconCls:'icon-undo'" >
       <a  onclick="logout();">安全退出</a>
      </div>
    </div>

</div>



