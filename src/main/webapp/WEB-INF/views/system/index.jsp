
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
        .easyui-accordion ul li a{line-height:30px;}
        .easyui-accordion ul li div{margin:2px 0px;padding-left:10px;padding-top:2px;}
        .easyui-accordion ul li div.hover{border:1px dashed #99BBE8; background:#E0ECFF;cursor:pointer;}
        .easyui-accordion ul li div.hover a{color:#416AA3;}
        .easyui-accordion ul li div.selected{line-height:17px;/* border:1px solid #99BBE8; *//* background:#E0ECFF; *//* cursor:default; */}
        .easyui-accordion ul li div.selected a{color:#416AA3; font-weight:bold; text-decoration: none;}

    </style>
</head>
<body>
<div id="cc" class="easyui-layout" style="width:100%;height:600px">

          <%--north--%>
    <jsp:include page="top.jsp"/>

     <%--south--%>
     <jsp:include page="south.jsp"/>

     <%--east--%>

      <%--west--%>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:160px;">


        <!-- 动态生成菜单项  -->

        <div id="nav" class="easyui-accordion" >

        </div>

    </div>
    <%--center--%>
    <div data-options="region:'center'" style="padding:0px;background:#eee;">
        <div id="tabs" class="easyui-tabs" fit="true">
            <div title="首页">

                <div  class="easyui-panel" title="个人信息"
                     style="width:200px;height:150px;padding:10px;background:#fafafa;"
                     data-options="iconCls:'icon-user',closable:true,collapsible:true">

                </div>

                <div  class="easyui-panel" title="时间"
                     style="width:200px;height:250px;padding:10px;background:#fafafa;"
                     data-options="iconCls:'icon-user',closable:true,collapsible:true">

                    <div  class="easyui-calendar"></div>


                </div>




            </div>

        </div>
    </div>
</div>

<%--修改密码--%>
<div id="updatePasswdWin" class="easyui-dialog" title="修改密码" style="width:500px;height:300px;padding: 30px 60px"
     data-options="iconCls:'icon-lock',closable:true,closed:true,minimizable:false,modal:true,buttons:'#bb'">
    <form id="updatePasswdForm" class="ef" method="post">
        <table class="et">
            <tr>
                <th>
                    <label for="oldPasswd">原始密码:</label>
                </th>
                <td colspan="3">
                    <input id="oldPasswd" class="easyui-validatebox" name="oldPasswd" style="width:250px;">
                </td>
            </tr>

            <tr>
                <th>
                    <label for="newPasswd">新密码:</label>
                </th>
                <td colspan="3">
                    <input id="newPasswd" class="easyui-validatebox" name="newPasswd" style="width:250px;">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="eqPasswd">重复密码:</label>
                </th>
                <td colspan="3">
                    <input id="eqPasswd" class="easyui-validatebox" name="eqPasswd" style="width:250px;">
                </td>
            </tr>

        </table>
    </form>
</div>
<div id="bb">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="modifyPasswd();">修改</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog('updatePasswdWin');">取消</a>
</div>


<script>
    $(function(){

        $.post("${pageContext.request.contextPath}/system/menus/navMenus.html",function(data){

            //初始化左侧

            $("#nav").accordion({animate:false});//为id为nav的div增加手风琴效果，并去除动态滑动效果
            $.each(data.data, function(i, n) {
                var menulist ='';
                menulist +='<ul>';
                $.each(n.children, function(j, o) {
                    var url="<%=base%>"+o.url;
                 menulist += '<li><div class="selected"><a style="text-decoration: none;" ref="'+o.id+'" href="#" rel="' + url + '" ><div class="icon '+o.icon+'" style="float: left;">&nbsp;&nbsp;</div><div class="nav">' + o.text + '</div></a></div></li> ';
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
                    $.each(n.children, function(j, o) {
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
             $("#updatePasswdWin").panel("open");
    }
</script>
</body>
</html>
