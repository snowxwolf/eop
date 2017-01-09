
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