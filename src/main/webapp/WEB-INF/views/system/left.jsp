<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ERP</title>
<%@ include file="common.jsp"%>

<script type="text/javascript">
        var tableHeight ;
		$(function(){
			$('#left').accordion({    
			    animate:true,
			    width:174,
			    height:500 
			    
			});  
			
			//选择1 打开侧栏
		    $('#accordion').accordion('select',0);
			selectTable= $("table[name='datagridLeft']").datagrid({ 
			onSelect:function(rowIndex, rowData){
			   //var id = parseInt(rowData.id);
			    window.open(rowData.method,'main'); 

			},	
			onLoadSuccess:function(row, data){
			   
		    },
		    onLoadError:function(row, data){
		    },
	        rowStyler:function(index,row){   
     		}    
		      
		  });
			
		});
    
	</script>
</head>
	
<body >
   <div id="left" class="easyui-accordion" style="width:173px;">
    	    <table name="datagridLeft" class="easyui-datagrid"  data-options="
    	    showHeader:false,showFooter:false,singleSelect:true,border:false,animate:false">   
		    <thead >   
		        <tr> 
		            <th data-options="field:'method',hidden:true,align:'center'"></th> 
		            <th data-options="field:'select',width:170,align:'left'"></th>   
		        </tr>   
		    </thead>   
		    <tbody> 
		         
			  </tbody>   
            </table> 
   </div>
</div>

</body>
</html>
