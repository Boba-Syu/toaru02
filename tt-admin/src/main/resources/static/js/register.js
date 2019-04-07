/**
 * Created by MI on 2019/2/22.
 */
function back() { // 返回按钮功能设置
    window.location.href = "login";
}
function yes() { // 确定按钮功能设置
    console.error(1);
    if ($(id3).val() == "" || $(pwd3).val() == "") {
        window.alert("输入框内不能为空!");
    }
    else {
        var user = new Object();
        user.name = $.trim($(id3).val());
        user.pwd = $.trim($(pwd3).val());
        $.ajax({
            type: 'get',
            url: "userRegister",
            timeout: 1000,
            data: {ObjectUser: JSON.stringify(user)},
            dataType: 'text',
            success: function (result) {
                if (result == "success") {
                    window.alert("注册成功");
                    window.location.href = "login";
                }
                else {
                    window.alert("注册失败");
                }
            },
            error: function () {
                window.alert("注册失败!");
            }
        })
    }
}
$(document).ready(function () {
    $("input").keyup(function (event) { // 当聚焦在输入框时, 回车键功能设置
        if (event.keyCode == 108 || event.keyCode == 13) {
            yes();
        }
    });
});