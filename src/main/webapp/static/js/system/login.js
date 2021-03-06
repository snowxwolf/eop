
// 使用jsencrypt类库加密js方法，
function encryptRequest(reqUrl, data, publicKey) {
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey);
    // ajax请求发送的数据对象
    var sendData = new Object();
    // 将data数组赋给ajax对象
    for (var key in data) {
        sendData[key] = encrypt.encrypt(data[key]);
    }

    $.ajax({
        url: reqUrl,
        type: 'post',
        data: sendData,
        dataType: 'json',
        //contentType: 'application/json; charset=utf-8',
        success: function (data) {
            console.info(data);
        },
        error: function (xhr) {
            //console.error('出错了');
        }
    });

}

$(function () {
    $('#testme').click(function () {

        var data = [];
        data['username'] = $('#username').val();
        data['passwd'] = $('#passwd').val();

        var pkey = $('#pubkey').val();
        encryptRequest('/WebForm2.aspx', data, pkey);
    });
});

function geneCode(){
    var url=$("#checkCode").attr("src");
    var nurl=url+"?t"+new Date();
    $("#checkCode").attr("src",nurl);
}

function login() {

        $("#loginForm").form('submit',{
          url:"login.html",
          queryParams:$(this).serialize(),
          onSubmit: function(){
                var isValid = $(this).form('validate');
                return isValid;	// 返回false终止表单提交
            },
            success:function(data){
                var data = eval('(' + data + ')');
                if(data.success){
                    window.location.href="index.html";
                }    else{
                    var msg=data.restVal;
                    error(msg);
                }
            }

        });

}
