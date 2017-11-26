var url_basic = "http://localhost:8080";
function checkLogin(){
    var employeeId = $("#employeeId").val();
    var pwd= $("#pwd").val();
    var url_login = url_basic +"/admin/adminLogin?employeeId="+employeeId +"&pwd="+pwd;
    $.ajax({
        url: url_login,
        type: 'post',
        contentType: "application/json; charset=utf-8",
        data:null,
        success:function (data) {
            debugger;
            location.href="../adminLogin.html";
        },
        error: function(data, textStatus, errorThrown){
            //调用失败
        }
    });
}

function check(){
    var employeeId = $("#employeeId").val();
    var url_check = url_basic +"/admin/findUserByEmployeeId?employeeId="+employeeId;
    $.ajax({
        url: url_check,
        type: 'post',
        contentType: "application/json; charset=utf-8",
        data:null,
        success:function (data) {
            debugger;
            location.href="../userList.html";
        },
        error: function(data, textStatus, errorThrown){
            //调用失败
        }
    });
}