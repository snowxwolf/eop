
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
    $.messager.alert("警告",msg,"warn");
}
function error(msg){
    $.messager.alert("错误",msg,"error");
}


function closeDialog(id){
    $("#"+id).dialog("close");
}