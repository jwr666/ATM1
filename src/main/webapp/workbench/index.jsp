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
       /* var ownerId="${account.accountOwnerId}"
        $(function () {
            searchName();

        })
        function searchName() {
            $.ajax({

                url : "settings/account/searchName.do",
                data : {
                    "ownerId":ownerId
                },
                type : "get",
                dataType : "json",
                success : function (data) {
                    $("#name").html(data);
                }

            })*/
        }


    </script>
</head>
<body>
<section class="resume-section" id="about">
    <div class="resume-section-content">
        <h1 class="mb-0">
            尊敬的
            <span class="text-primary" id="name">${name}</span>
        </h1>
        <div class="subheading mb-5">
            <!-- 3542 Berry Street · Cheyenne Wells, CO 80810 · (317) 585-8468 ·
            <a href="mailto:name@email.com">name@email.com</a> -->
        </div>

        <p class="lead mb-5">  &#12288;&#12288;欢迎访问本网站，本网站使用 Java Web(具体框架是ssm) 实现一个自动提款机系统，包括用户登录、取款、存款和转账等功能，并且用户所有操作都在数据库中记录日志，方便管理员查看。数据库使用 MySQL；前端界面使用 BootStrap，并适配移动端浏览器；日志功能使用 log4j 将日志记录数据库。
        </p>
        <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
            <div class="flex-grow-1">
            </div>
            <div class="flex-shrink-0"><span class="text-primary">design by cust.18.jwr in changchun</span></div>
        </div>
        <div class="social-icons">
            <a class="social-icon" href="javascript:void(0);"><i class="fab fa-linkedin-in"></i></a>
            <a class="social-icon" href="javascript:void(0);"><i class="fab fa-github"></i></a>
            <a class="social-icon" href="javascript:void(0);"><i class="fab fa-twitter"></i></a>
            <a class="social-icon" href="javascript:void(0);"><i class="fab fa-facebook-f"></i></a>
        </div>

    </div>
</section>

</body>
</html>