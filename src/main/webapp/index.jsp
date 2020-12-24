<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
    <head>
       <base href="<%=basePath%>">
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Resume - Start Bootstrap Theme</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
        <script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/js/bootstrap.js"></script>

        <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.3/css/bootstrap.min.css" rel="stylesheet">

        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />

        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>

        <script type="text/javascript">
            $(function () {
                window.open("workbench/index.jsp","workareaFrame");

            })
        </script>
 
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">Clarence Taylor</span>
                <span class="d-none d-lg-block"><img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="assets/img/profile.jpg" alt="" /></span>
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" target="workareaFrame"href="workbench/index.jsp">主页</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" target="workareaFrame" href="workbench/searchBalance.jsp">余额查询</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" target="workareaFrame"href="workbench/save.jsp">存款</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" target="workareaFrame"href="workbench/draw.jsp">取款</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" target="workareaFrame"href="workbench/transfer.jsp">转账</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" target="workareaFrame"href="workbench/transaction_detail.jsp">交易记录查询</a></li>
                </ul>
            </div>
        </nav>
        <div id="workarea" class="resume-section">
            <iframe style="border-width: 0px; width: 100%; height: 700px;" name="workareaFrame"></iframe>

        </div>


    </body>
</html>
