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
            //alert(accountId);
            searchBalance();


            $("#SearchBtn").click(function () {
                searchBalance();
            })
        })


        function searchBalance() {
            $.ajax({

                url: "settings/account/search.do",
                data: {
                    "accountId": accountId

                },
                type: "get",
                dataType: "json",
                success: function (data) {
                    //alert(data);
                    $("#balance").val(data);
                }

            })
        }

    </script>
</head>
<body>
<!-- Experience-->
<section class="resume-section" id="experience">
    <h3 class="mb-3">您的余额为</h3>

    <div class="col-lg-6">
        <div class="input-group">
            <input id="balance" type="text" class="form-control" aria-label="Amount (to the nearest dollar)" placeholder="5个亿" readonly="readonly">
            <span class="input-group-btn">￥
                        <button class="btn btn-primary" type="button" id="SearchBtn">查询</button>
                        </span>
        </div>
    </div>
</section>

</body>
</html>