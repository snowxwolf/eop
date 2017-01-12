var myview = $.extend({},$.fn.datagrid.defaults.view,{
    onAfterRender:function(target){
        $.fn.datagrid.defaults.view.onAfterRender.call(this,target);
        var opts = $(target).datagrid('options');
        var vc = $(target).datagrid('getPanel').children('div.datagrid-view');
        vc.children('div.datagrid-empty').remove();
        if (!$(target).datagrid('getRows').length){
            var d = $('<div class="datagrid-empty"></div>').html(opts.emptyMsg || '没有记录').appendTo(vc);
            d.css({
                position:'absolute',
                left:0,
                top:50,
                width:'100%',
                textAlign:'center'
            });
        }
    }
});
/**
 * 按钮禁用
 * @param btn button id
 */
function btnDisabled(btn){

    $("#"+btn).addClass("disabled");

}
/***信息提示相关**/
function info(msg){
    $.messager.alert("提示",msg,"info");
}
function warn(msg){
    $.messager.alert("警告",msg,"warning");
}
function error(msg){
    $.messager.alert("错误",msg,"error");
}

function show(msg){
    $.messager.show({
        title:'提示',
        msg:msg,
        showType:'show'
    });
}
 /*dialog 相关*/
function openDialog(id){
    $("#"+id).dialog("open");
}

function closeDialog(id){
    $("#"+id).dialog("close");
}

/*datagrid相关*/
function relaodDatagrid(id){
    $("#"+id).datagrid("reload");
}
/**
 * 清空所有选择的项
 * @param id
 */
function clearAllSelections(id){
    $("#"+id).datagrid("clearSelections");
}

/**
 * form表单重置
 * @param id
 */
function formReset(id){
   $('#'+id).form('reset');
}

//将表单数据转为json
function form2Json(id) {
    var arr = $("#" + id).serializeArray()
    var jsonStr = "";
    jsonStr += '{';
    for (var i = 0; i < arr.length; i++) {
        jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
    }
    jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
    jsonStr += '}'

    var json = JSON.parse(jsonStr)
    return json
}