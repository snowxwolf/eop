
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>eop-基础码表</title>
    <meta name="description" content="OA,ERP" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${ctx}/static/assets/css/fonts.googleapis.com.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-rtl.min.css" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/static/assets/css/ace-ie.min.css" />
    <![endif]-->



    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="${ctx}/static/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${ctx}/static/assets/js/html5shiv.min.js"></script>
    <script src="${ctx}/static/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">

<div class="main-container ace-save-state" id="main-container">


    <div class="main-content">
        <div class="main-content-inner">


            <div class="page-content">

                <div class="page-header">
                    <h1>
                        系统管理
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            码表管理
                        </small>
                    </h1>
                  </div><!-- /.page-header -->

                <div class="widget-box widget-color-blue">
                    <div class="widget-header panel-heading ">
                        <h4 class="widget-title ">数据检索</h4>

                        <div class="widget-toolbar">
                            <a href="#" data-action="collapse">
                                <i class="ace-icon fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>

                    <div class="widget-body ">
                        <div class="widget-main">
                            <div>
                                <label for="form-field-8">Default</label>

                                <textarea class="form-control" id="form-field-8" placeholder="Default Text"></textarea>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-primary">
                    <div class="panel-heading">
                        码表
                    </div>
          <div class="panel-body">
              <div class="dataTable_wrapper">
                <table id="table_id_example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>码表code</th>
                        <th>码表名称</th>
                        <th>码表值</th>
                        <th>创建时间</th>
                        <th>状态</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
              </div>

           </div>
        </div>




            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->


    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->
<script src="${ctx}/static/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${ctx}/static/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='${ctx}/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${ctx}/static/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="${ctx}/static/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/static/assets/js/jquery-ui.custom.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.easypiechart.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.sparkline.index.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.flot.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.flot.pie.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->
<script src="${ctx}/static/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/static/assets/js/ace.min.js"></script>

<script src="${ctx}/static/assets/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/static/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${ctx}/static/assets/js/dataTables.buttons.min.js"></script>
<script src="${ctx}/static/assets/js/buttons.flash.min.js"></script>
<script src="${ctx}/static/assets/js/buttons.html5.min.js"></script>
<script src="${ctx}/static/assets/js/buttons.print.min.js"></script>
<script src="${ctx}/static/assets/js/buttons.colVis.min.js"></script>
<script src="${ctx}/static/assets/js/dataTables.select.min.js"></script>
<script>
    $(document).ready( function () {
        getTable();
    });
    function getTable(){
        $('#table_id_example').DataTable({
            "serverSide" : true,
            ajax:{
                url:"${ctx}/system/codes/listCodes.html",
                type:"post"
            },
            "searching": false,
            columns: [
                { data: 'cid' },
                { data: 'code' },
                { data: 'cname' },
                { data: 'cvalue' },
                { data: 'ctime' },
                { data: 'cstatus' }
            ],
            oLanguage:{
                "sProcessing": "Bitte warten...",
                "sLengthMenu": "显示_MENU_条 ",
                "sZeroRecords": "没有您要搜索的内容",
                "sInfo": "从_START_ 到 _END_ 条记录,总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "记录数为0",
                "sInfoFiltered": "(全部记录数 _MAX_ 条)",
                "sInfoPostFix": "",
                "sSearch": "搜索",
                "sUrl": "",
                "oPaginate": {
                    "sFirst":  "第一页",
                    "sPrevious": " 上一页 ",
                    "sNext":   " 下一页 ",
                    "sLast":   " 最后一页 "
                }
            }
        });
    }



</script>
</body>
</html>
