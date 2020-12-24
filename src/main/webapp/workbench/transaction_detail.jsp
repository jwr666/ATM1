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
            transactionList();
        })
        function transactionList() {
            $.ajax({

                url : "settings/transaction/transactionList.do",
                data : {
                    "accountId":accountId

                },
                type : "get",
                dataType : "json",
                success : function (data) {

                    /*
                        data
                        [{交易记录1}，{交易记录2}，{交易记录3}]
                        List<ArrayList> aList
                     */

                    var html="";


                    $.each(data,function (i,n) {
                        html += '<tr class="active">';
                        html += '<td><input type="checkbox" name="xz" value="'+n.id+'"/></td>';

                        html += '<td>'+n.transactionDate+'</td>';
                        html += '<td>'+n.transactionType+'</td>';
                        html += '<td>'+n.transactionId+'</td>';
                        html += '<td>'+n.transactionTo+'</td>';
                        html += '<td>'+n.transactionInCome+'</td>';
                        html += '<td>'+n.transactionExpend+'</td>';
                        html += '<td>'+n.transactionBalance+'</td>';

                        html += '</tr>';

                    })

                    $("#transactionBody").html(html);



                }

            })

        }

    </script>
</head>
<body style="padding-left: 0px;">
<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">

</div>
<div style="position: relative;top: 10px;">
    <table class="table table-hover">
        <thead>
        <tr style="color: #B3B3B3;">
            <td><input type="checkbox" id="qx"/></td>
            <td>交易时间</td>
            <td>类型</td>
            <td>交易编号</td>
            <td>对方</td>
            <td>收入</td>
            <td>支出</td>
            <td>账户余额</td>
        </tr>
        </thead>
        <tbody id="transactionBody">
        <%--<tr class="active">
            <td><input type="checkbox" /></td>
            <td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='workbench/activity/detail.jsp';">发传单</a></td>
            <td>zhangsan</td>
            <td>2020-10-10</td>
            <td>2020-10-20</td>
        </tr>
        <tr class="active">
            <td><input type="checkbox" /></td>
            <td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='detail.jsp';">发传单</a></td>
            <td>zhangsan</td>
            <td>2020-10-10</td>
            <td>2020-10-20</td>
        </tr>--%>
        </tbody>
    </table>
</div>



</body>
</html>