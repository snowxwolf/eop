<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="UTF-8" />
    <title>首页</title>
    <meta name="description" content="OA,ERP" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="static/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="static/assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="static/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
        <link rel="stylesheet" href="static/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="static/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="static/assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
      <link rel="stylesheet" href="static/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="static/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="static/assets/js/html5shiv.min.js"></script>
    <script src="static/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
<%-- head部分head.jsp--%>
<jsp:include page="head.jsp"/>

<div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>

    <div id="sidebar" class="sidebar responsive ace-save-state">


           <%--导航菜单--%>
            <ul class="nav nav-list" id="menu">

            </ul>

           <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
               <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
           </div>

    </div>

    <%--tab页面--%>
    <div class="main-content">
        <div class="page-content">
        <div class="row">
            <div class="col-xs-12" style="padding-left:5px;">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="active"><a href="#Index" role="tab" data-toggle="tab">首页</a></li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="Index">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

    <%--footer--%>
    <jsp:include page="foot.jsp"/>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="static/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="static/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="static/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="static/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="static/assets/js/jquery-ui.custom.min.js"></script>
<script src="static/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="static/assets/js/jquery.easypiechart.min.js"></script>
<script src="static/assets/js/jquery.sparkline.index.min.js"></script>
<script src="static/assets/js/jquery.flot.min.js"></script>
<script src="static/assets/js/jquery.flot.pie.min.js"></script>
<script src="static/assets/js/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->
<script src="static/assets/js/ace-elements.min.js"></script>
<script src="static/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script src="static/js/sidebarMenu.js"></script>
<script src="static/js/bootstrap-tab.js"></script>
<script type="text/javascript">

$(function(){

   /* var menuData={
        data: [{
            id: '1',
            text: '系统设置',
            icon: 'fa-cogs',
            url: '',
            menus: [{
                id: '11',
                text: '编码管理',
                icon: 'fa-user',
                url: '/CodeType/Index'
            }]
        }, {
            id: '2',
            text: '基础数据',
            icon: 'icon-leaf',
            url: '',
            menus: [{
                id: '21',
                text: '基础特征',
                icon: 'icon-glass',
                url: '/BasicData/BasicFeature/Index'
            }, {
                id: '22',
                text: '特征管理',
                icon: 'icon-glass',
                url: '/BasicData/Features/Index'
            }, {
                id: '23',
                text: '物料维护',
                icon: 'icon-glass',
                url: '/Model/Index'
            }, {
                id: '24',
                text: '站点管理',
                icon: 'icon-glass',
                url: '/Station/Index'
            }]
        }, {
            id: '3',
            text: '权限管理',
            icon: 'icon-user',
            url: '',
            menus: [{
                id: '31',
                text: '用户管理',
                icon: 'icon-user',
                url: '/SystemSetting/User'
            }, {
                id: '32',
                text: '角色管理',
                icon: 'icon-apple',
                url: '/SystemSetting/Role'
            }, {
                id: '33',
                text: '菜单管理',
                icon: 'icon-list',
                url: '/SystemSetting/Menu'
            }, {
                id: '34',
                text: '部门管理',
                icon: 'icon-glass',
                url: '/SystemSetting/Department'
            }]
        }, {
            id: '4',
            text: '订单管理',
            icon: 'icon-envelope',
            url: '',
            menus: [{
                id: '41',
                text: '订单查询',
                icon: 'icon-glass',
                url: '/Order/Query'
            }, {
                id: '42',
                text: '订单排产',
                icon: 'icon-glass',
                url: '/Order/PLANTPRODUCT'
            }, {
                id: '43',
                text: '订单撤排',
                icon: 'icon-glass',
                url: '/Order/cancelPRODUCT'
            }, {
                id: '44',
                text: '订单HOLD',
                icon: 'icon-glass',
                url: '/Order/hold'
            }, {
                id: '45',
                text: '订单删除',
                icon: 'icon-glass',
                url: '/Order/delete'
            }, {
                id: '47',
                text: '订单插单',
                icon: 'icon-glass',
                url: '/Order/insertorder'
            }, {
                id: '48',
                text: '订单导入',
                icon: 'icon-glass',
                url: '/Order/Import'
            }]
        }]
    };*/
    $.post("menus/listMenus.html",function(data){
        console.info(data.data)
        $('#menu').sidebarMenu(data);
    },"json");

});

</script>
</body>
</html>
