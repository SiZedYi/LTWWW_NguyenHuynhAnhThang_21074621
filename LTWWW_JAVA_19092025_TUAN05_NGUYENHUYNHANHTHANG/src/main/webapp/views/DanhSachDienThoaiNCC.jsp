<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <img src="${pageContext.request.contextPath}/views/img/logo.png" alt="Fongo HomePhone Logo" height="80"/>
    </div>
    <div class="nav">
        <a href="${pageContext.request.contextPath}/home">Danh sách sản phẩm</a> |
        <a href="${pageContext.request.contextPath}/add-phone">Thêm mới sản phẩm</a> |
        <a href="${pageContext.request.contextPath}/quan-ly">Quản lý</a>
    </div>
    <div class="content">
        <form method="get" action="${pageContext.request.contextPath}/home" style="margin-bottom:20px;">
            <label for="tenNCC">Tìm kiếm nhà cung cấp: </label>
            <input type="text" id="tenNCC" name="tenNCC" value="${tenNCC}" placeholder="Nhập tên nhà cung cấp..."/>
            <button type="submit">Tìm kiếm</button>
        </form>
        <c:choose>
            <c:when test="${not empty dienthoaiList}">
                <table style="width:100%; margin-bottom:20px; border-collapse:collapse;">
                    <tr style="background:#e3e3f7; font-weight:bold;">
                        <td>Mã điện thoại</td>
                        <td>Tên điện thoại</td>
                        <td>Năm sản xuất</td>
                        <td>Cấu hình</td>
                        <td>Nhà cung cấp</td>
                        <td>Hình ảnh</td>
                    </tr>
                    <c:forEach var="dt" items="${dienthoaiList}">
                        <tr>
                            <td>${dt.maDT}</td>
                            <td>${dt.tenDT}</td>
                            <td>${dt.namSX}</td>
                            <td>${dt.cauHinh}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${dt.nhaCungCap != null && dt.nhaCungCap.tenNCC != null}">
                                        ${dt.nhaCungCap.tenNCC}
                                    </c:when>
                                    <c:otherwise>
                                        Không rõ NCC
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${dt.hinhAnh != null && dt.hinhAnh != ''}">
                                        <img src="${pageContext.request.contextPath}/views/img/${dt.hinhAnh}" alt="Hình" style="height:40px;"/>
                                    </c:when>
                                    <c:otherwise>
                                        Không có hình
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h3>Không có sản phẩm nào trong danh sách.</h3>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="footer">
        Nguyễn Huỳnh Anh Thắng - 21074621 - DHKTPM18BTT
    </div>
</div>
</body>
</html>