<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/styles.css" rel="stylesheet" />


    <script type="text/javascript">
        var accountId="${account.accountId}";
        $(function () {

            $("#transferBtn").click(
                function () {

                    transfer();
                }
            )
        })

        function transfer() {
            $.ajax({

                url: "settings/account/transfer.do",
                data: {
                    "accountId": accountId,
                    "toAccount": $("#toAccount").val(),
                    "toMoney": $("#toMoney").val()
                },
                type: "get",
                dataType: "json",
                success: function (data) {

                    //alert(data);
                    if (data.success) {

                        alert("转账成功!"+"您当前余额为:"+data.msg+"元");

                    } else {

                        alert("转账失败！");
                        var msg = data.msg;
                        if ("" != msg) {
                            alert(msg);
                        }

                    }
                }

            })
        }

    </script>
</head>
<body>
<section class="resume-section" id="interests">

    <form>
        <div class="form-group">
            <input type="text"  required data-msg="请输入对方账号" placeholder="对方账号" class="input-material" id="toAccount">
        </div>
        <div class="form-group">
            <input  type="password"  required data-msg="请输入转账金额" placeholder="转账金额" class="input-material" id="toMoney">
        </div>
        <button  type="button" class="btn btn-primary" id="transferBtn">转账</button>
    </form>
</section>


</body>
</html>