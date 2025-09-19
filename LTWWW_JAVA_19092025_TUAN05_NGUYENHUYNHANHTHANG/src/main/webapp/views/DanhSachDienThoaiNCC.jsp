<%@ page import="fit.iuh.thang.ltwww_java_19092025_tuan05_nguyenhuynhanhthang.model.DienThoai" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        body {
            margin: 0;
            padding: 0;
        }
        .container {
            border: 2px solid #000;
            width: 800px;
            margin: 30px auto;
            background: #fff;
        }
        .header {
            text-align: center;
            padding: 20px 0 10px 0;
        }
        .nav {
            border-top: 1px solid #000;
            border-bottom: 1px solid #000;
            background: #f8f8ff;
            text-align: center;
            padding: 5px 0;
        }
        .nav a {
            text-decoration: underline;
            margin: 0 10px;
            font-weight: bold;
        }
        .content {
            min-height: 300px;
            padding: 20px;
        }
        .footer {
            border-top: 1px solid #000;
            text-align: center;
            padding: 8px 0;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <img src="./img/img.png" alt="Fongo HomePhone Logo" height="80" />
    </div>
    <div class="nav">
        <a href="#">Danh sách sản phẩm</a> |
        <a href="#">Thêm mới sản phẩm</a> |
        <a href="#">Chức năng quản lý</a>
    </div>
    <div class="content">
        <%
            List<DienThoai> listDt = (List<DienThoai>) request.getAttribute("listDienThoai");
            if (listDt == null) {
                System.out.println("<h3>Không có sản phẩm nào trong danh sách.</h3>");
            } else {
                System.out.println("<h2>Danh sách điện thoại:</h2>");
            for (DienThoai dt : listDt) {
                System.out.println("<table border='1' cellpadding='10'>");
                System.out.println("<tr><th>Mã ĐT</th><th>Tên ĐT</th></tr>");
            }
            }
                %>
    </div>
    <div class="footer">
        Nguyễn Huỳnh Anh Thắng - 21074621 - DHKTPM18BTT
    </div>
</div>
</body>
</html>
