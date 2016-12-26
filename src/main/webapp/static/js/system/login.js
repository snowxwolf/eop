
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
    btnDisabled("loginBtn");
    $.post("login.html",$("#loginForm").serialize(),function (data) {
   console.info("data:"+data);
    },"json");
}