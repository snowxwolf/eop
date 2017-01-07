<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>top</title>
<%@ include file="common.jsp"%>
</head>

<body>
  <div>TOP</div>
  <div style="position: absolute; right: 0px; bottom: 0px;">
	<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_pfMenu',iconCls:'ext-icon-rainbow'">更换皮肤</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'ext-icon-cog'">控制面板</a> <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'ext-icon-disconnect'">注销</a>
</div>
<div id="layout_north_pfMenu" style="width: 120px; display: none;">
	<div onclick="changeTheme('default');" title="default">default</div>
	<div onclick="changeTheme('gray');" title="gray">gray</div>
	<div onclick="changeTheme('metro');" title="metro">metro</div>
	<div onclick="changeTheme('bootstrap');" title="bootstrap">bootstrap</div>
	<div onclick="changeTheme('black');" title="black">black</div>
	<div onclick="changeTheme('cupertino');" title="cupertino">cupertino</div>
	<div onclick="changeTheme('dark-hive');" title="dark-hive">dark-hive</div>
	<div onclick="changeTheme('pepper-grinder');" title="pepper-grinder">pepper-grinder</div>
	<div onclick="changeTheme('sunny');" title="sunny">sunny</div>
	<div class="menu-sep"></div>
	<div onclick="changeTheme('metro-blue');" title="metro-blue">metro-blue</div>
	<div onclick="changeTheme('metro-gray');" title="metro-gray">metro-gray</div>
	<div onclick="changeTheme('metro-green');" title="metro-green">metro-green</div>
	<div onclick="changeTheme('metro-orange');" title="metro-orange">metro-orange</div>
	<div onclick="changeTheme('metro-red');" title="metro-red">metro-red</div>
</div>
<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-user_edit'" onclick="$('#passwordDialog').dialog('open');">修改密码</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-user'" onclick="showMyInfoFun();">我的信息</div>
</div>
<div id="layout_north_zxMenu" style="width: 100px; display: none;">
	<div data-options="iconCls:'ext-icon-lock'" onclick="lockWindowFun();">锁定窗口</div>
	<div class="menu-sep"></div>
	<div data-options="iconCls:'ext-icon-door_out'" onclick="logoutFun();">退出系统</div>
</div>

<script type="text/javascript">
  
  //退出
  function logoutFun(){
	  var basePath="<%=basePath%>";
	  var logout=basePath+"admin/controller/logout.do";
	  
	  window.location.href=logout;
	  
  }
</script>
</body>
</html>