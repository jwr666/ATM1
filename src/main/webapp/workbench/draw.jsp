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
            $("#drawBtn").click(function () {


                draw();
                //alert("发出ajax请求");
            })

        })
        function draw() {

            $.ajax({
                url: "settings/account/draw.do",
                data: {
                    "accountId": accountId,
                    "money":$("#money").val()
                },
                type: "get",
                dataType: "json",
                success: function (data) {
                    if (data.success){

                        alert("取款成功!"+"您当前余额为:"+data.msg+"元");

                    }else{

                        alert("取款失败！");
                        var msg=data.msg;
                        if (""!=msg){
                            alert(msg);
                        }

                    }
                }

            })

        }

    </script>
</head>
<body>
<section class="resume-section" id="skills">
    <h3 class="mb-3">请输入你要取出的金额</h3>

    <div class="col-lg-6">
        <div class="input-group">
            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="金额" id="money">
            <span class="input-group-btn">￥
                        <button class="btn btn-primary" type="button" id="drawBtn">取出</button>
                        </span>
        </div>
    </div>

</section>


</body>
</html>