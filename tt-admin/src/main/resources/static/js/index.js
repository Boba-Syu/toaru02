/**
 * Created by MI on 2019/2/22.
 */

function login() {
    window.location.href = "login";
}

function register() {
    window.location.href = "register";
}

$(document).ready(function () { // 当页面加载完成时
    $.ajax({
        success: function () {
            setTimeout(yes, 1100); //js休眠2.1秒后调用yes()函数
        }
    })
});

function yes() { // 进度条加载完成后调用
    var str = '';
    str += '<h1 class="page-header"><small>加载完成<br>' //插入已加载完整的进度条
        + '<div class="progress">'
        + '<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" '
        + 'aria-valuemin="100" aria-valuemax="100" style="width:100%">'
        + '<span class="sr-only"></span>'
        + '</div>'
        + '</div>'
        + '</small></h1>'
        + '<button onclick="login()" type="button" class="btn btn-primary btn-sm">确定</button>'; // 插入确定按钮
    $(tableBody).html(str);
}
