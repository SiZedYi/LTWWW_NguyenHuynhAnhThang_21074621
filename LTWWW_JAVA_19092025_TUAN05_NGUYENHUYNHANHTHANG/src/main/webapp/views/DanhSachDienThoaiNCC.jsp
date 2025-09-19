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
        <img src="/views/img/img.png" alt="Fongo HomePhone Logo" height="80"/>
    </div>
    <div class="nav">
        <a href="#">Danh sách sản phẩm</a> |
        <a href="#">Thêm mới sản phẩm</a> |
        <a href="#">Chức năng quản lý</a>
    </div>
    <div class="content">
        <%
            List<DienThoai> dienThoais = (List<DienThoai>) request.getAttribute("dienthoaiList");
            if (dienThoais != null && !dienThoais.isEmpty()) {
        %>
        <table style="width:100%; margin-bottom:20px; border-collapse:collapse;">
            <tr style="background:#e3e3f7; font-weight:bold;">
                <td>Mã điện thoại</td>
                <td>Tên điện thoại</td>
                <td>Năm sản xuất</td>
                <td>Cấu hình</td>
                <td>Nhà cung cấp</td>
                <td>Hình ảnh</td>
            </tr>
            <%
                for (DienThoai dt : dienThoais) {
            %>
            <tr>
                <td><%= dt.getMaDT() %>
                </td>
                <td><%= dt.getTenDT() %>
                </td>
                <td><%= dt.getNamSX() %>
                </td>
                <td><%= dt.getCauHinh() %>
                </td>
                <td><%= (dt.getNhaCungCap() != null && dt.getNhaCungCap().getTenNCC() != null) ? dt.getNhaCungCap().getTenNCC() : "Không rõ NCC" %>
                </td>
                <td>
                    <% if (dt.getHinhAnh() != null && !dt.getHinhAnh().isEmpty()) { %>
                    <img src="<%= dt.getHinhAnh() %>" alt="Hình" style="height:40px;"/>
                    <% } else { %>
                    Không có hình
                    <% } %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
        } else {
        %>
        <h3>Không có sản phẩm nào trong danh sách.</h3>
        <%
            }
        %>
    </div>
    <div class="footer">
        Nguyễn Huỳnh Anh Thắng - 21074621 - DHKTPM18BTT
    </div>
</div>
</body>
</html>
