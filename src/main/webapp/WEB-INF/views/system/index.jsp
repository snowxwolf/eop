
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
 String base=request.getContextPath();
%>
<html>
<head>
    <jsp:include page="common.jsp"/>
    <title>首页</title>
    <style>
        .easyui-accordion ul{list-style-type:none;margin:0px; padding:10px;}
        .easyui-accordion ul li{ padding:0px;}
        .easyui-accordion ul li a{line-height:24px;}
        .easyui-accordion ul li div{margin:2px 0px;padding-left:10px;padding-top:2px;}
        .easyui-accordion ul li div.hover{border:1px dashed #99BBE8; background:#E0ECFF;cursor:pointer;}
        .easyui-accordion ul li div.hover a{color:#416AA3;}
        .easyui-accordion ul li div.selected{/* border:1px solid #99BBE8; *//* background:#E0ECFF; *//* cursor:default; */}
        .easyui-accordion ul li div.selected a{color:#416AA3; font-weight:bold;
            text-decoration: none;}

    </style>
</head>
<body>
<div id="cc" class="easyui-layout" style="width:100%;height:600px">

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

    <div data-options="region:'south'" style="height:40px;text-align:center">
        <span style="font-size:16px;line-height:40px;"><b>snowxwolf@sina.cn &copy;所有</b>   <span><b></b>QQ:2324808561</span></span>
    </div>

    <div data-options="region:'east',title:'其他',split:true" style="width:187px;">
        <!-- 日历 -->
        <div  class="easyui-calendar">
        </div>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true" style="width:160px;">


        <!-- 动态生成菜单项  -->

        <div id="nav" class="easyui-accordion" >

        </div>

    </div>
    <div data-options="region:'center'" style="padding:0px;background:#eee;">
        <div id="tabs" class="easyui-tabs" fit="true">
            <div title="首页" style="text-align:center;">
                <span style="color:red;font-size:20px;">进销存系统</span>
            </div>

        </div>

    </div>
</div>

<%--修改密码--%>
<div id="updatePasswdWin" class="easyui-window" title="修改密码" style="width:600px;height:400px"
     data-options="iconCls:'icon-lock',modal:true,closable:true,closed:true,minimizable:false">
    <form id="updatePasswdForm" method="post">
        <table   border="0" cellpadding="1" cellspacing="2" style="align-content: center">
            <tr>
                <td width="60" align="right">
                    原始密码
                </td>
                <td>
                    <input class="easyui-textbox" name="oldPasswd">
                </td>
            </tr>

            <tr>
                <td width="60" align="right">
                    原始密码
                </td>
                <td>
                    <input class="easyui-textbox" name="oldPasswd">
                </td>
            </tr>
        </table>
    </form>
</div>


<script>
    $(function(){

        $.post("${pageContext.request.contextPath}/system/menus/navMenus.html",function(data){

            //初始化左侧

            $("#nav").accordion({animate:false});//为id为nav的div增加手风琴效果，并去除动态滑动效果
            $.each(data.data, function(i, n) {
                var menulist ='';
                menulist +='<ul>';
                $.each(n.menus, function(j, o) {
                    var url="<%=base%>"+o.url;
                 menulist += '<li><div class="selected"><a style="text-decoration: none;" ref="'+o.id+'" href="#" rel="' + url + '" ><span class="icon '+o.icon+'" >&nbsp;&nbsp;</span><span class="nav">' + o.text + '</span></a></div></li> ';
                 });
                menulist += '</ul>';

                $('#nav').accordion('add', {
                    title: n.text,
                    content: menulist,
                    iconCls: n.icon
                });
            });
            $('.easyui-accordion li a').click(function(){//当单击菜单某个选项时，在右边出现对用的内容
                var tabTitle = $(this).children('.nav').text();//获取超链里span中的内容作为新打开tab的标题
                var url = $(this).attr("rel");
                var menuid = $(this).attr("ref");//获取超链接属性中ref中的内容
                var icon = getIcon(menuid,icon);
                addTab(tabTitle,url,icon);//增加tab
                $('.easyui-accordion li div').removeClass("selected");
                $(this).parent().addClass("selected");
            }).hover(function(){
                $(this).parent().addClass("hover");
            },function(){
                $(this).parent().removeClass("hover");
            });
            //选中第一个
            var panels = $('#nav').accordion('panels');
            var t = panels[0].panel('options').title;
            $('#nav').accordion('select', t);

            //获取左侧导航的图标
            function getIcon(menuid){
                var icon;
                $.each(data.data, function(i, n) {
                    $.each(n.menus, function(j, o) {
                        if(o.id==menuid){
                            icon = o.icon;
                        }
                    })
                })
                return icon;
            }
            function addTab(subtitle,url,icon){
                if(!$('#tabs').tabs('exists',subtitle)){
                    $('#tabs').tabs('add',{
                        title:subtitle,
                        content:createFrame(url),
                        closable:true,
                        icon:icon
                    });
                }else{
                    $('#tabs').tabs('select',subtitle);
                    $('#mm-tabupdate').click();
                }
                tabClose();
            }
            function createFrame(url)
            {
                var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                return s;
            }
            function tabClose()
            {
                /*双击关闭TAB选项卡*/
                $(".tabs-inner").dblclick(function(){
                    var subtitle = $(this).children(".tabs-closable").text();
                    $('#tabs').tabs('close',subtitle);
                })
                /*为选项卡绑定右键*/
                $(".tabs-inner").bind('contextmenu',function(e){
                    $('#mm').menu('show', {
                        left: e.pageX,
                        top: e.pageY
                    });
                    var subtitle =$(this).children(".tabs-closable").text();
                    $('#mm').data("currtab",subtitle);
                    $('#tabs').tabs('select',subtitle);
                    return false;
                });
            }
            //绑定右键菜单事件
            function tabCloseEven()
            {
                //刷新
                $('#mm-tabupdate').click(function(){
                    var currTab = $('#tabs').tabs('getSelected');
                    var url = $(currTab.panel('options').content).attr('src');
                    $('#tabs').tabs('update',{
                        tab:currTab,
                        options:{
                            content:createFrame(url)
                        }
                    })
                })
                //关闭当前
                $('#mm-tabclose').click(function(){
                    var currtab_title = $('#mm').data("currtab");
                    $('#tabs').tabs('close',currtab_title);
                })
                //全部关闭
                $('#mm-tabcloseall').click(function(){
                    $('.tabs-inner span').each(function(i,n){
                        var t = $(n).text();
                        $('#tabs').tabs('close',t);
                    });
                });
                //关闭除当前之外的TAB
                $('#mm-tabcloseother').click(function(){
                    $('#mm-tabcloseright').click();
                    $('#mm-tabcloseleft').click();
                });
                //关闭当前右侧的TAB
                $('#mm-tabcloseright').click(function(){
                    var nextall = $('.tabs-selected').nextAll();
                    if(nextall.length==0){
                        //msgShow('系统提示','后边没有啦~~','error');
                        alert('后边没有啦~~');
                        return false;
                    }
                    nextall.each(function(i,n){
                        var t=$('a:eq(0) span',$(n)).text();
                        $('#tabs').tabs('close',t);
                    });
                    return false;
                });
                //关闭当前左侧的TAB
                $('#mm-tabcloseleft').click(function(){
                    var prevall = $('.tabs-selected').prevAll();
                    if(prevall.length==0){
                        alert('到头了，前边没有啦~~');
                        return false;
                    }
                    prevall.each(function(i,n){
                        var t=$('a:eq(0) span',$(n)).text();
                        $('#tabs').tabs('close',t);
                    });
                    return false;
                });
                //退出
                $("#mm-exit").click(function(){
                    $('#mm').menu('hide');
                })
            }
            //弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
            function msgShow(title, msgString, msgType) {
                $.messager.alert(title, msgString, msgType);
            }

        },"json");

    });

    function logout(){
        $.messager.confirm('确认','您确认要退出吗?',function(r){
            if (r){
                window.location.href="${pageContext.request.contextPath}/logout.html";
            }
        });

    }

    function updatePasswd(){
             $("#updatePasswdWin").window("open");
    }
</script>
</body>
</html>
