<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm điện thoại mới</title>
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
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; }
        input, textarea, select { width: 100%; padding: 6px; }
        .error { color: red; font-size: 14px; }
    </style>
    <script>
        function validateForm() {
            let valid = true;
            document.getElementById('errMaDT').innerText = '';
            document.getElementById('errTenDT').innerText = '';
            document.getElementById('errNamSX').innerText = '';
            document.getElementById('errCauHinh').innerText = '';
            document.getElementById('errHinhAnh').innerText = '';

            const maDT = document.getElementById('maDT').value.trim();
            const tenDT = document.getElementById('tenDT').value.trim();
            const namSX = document.getElementById('namSX').value.trim();
            const cauHinh = document.getElementById('cauHinh').value.trim();
            const hinhAnh = document.getElementById('hinhAnh').value;

            if (!maDT) {
                document.getElementById('errMaDT').innerText = 'Mã ĐT bắt buộc nhập.';
                valid = false;
            }
            if (!tenDT) {
                document.getElementById('errTenDT').innerText = 'Tên điện thoại bắt buộc nhập.';
                valid = false;
            }
            if (!namSX.match(/^\d{4}$/)) {
                document.getElementById('errNamSX').innerText = 'Năm sản xuất phải là số nguyên 4 chữ số.';
                valid = false;
            }
            if (!cauHinh) {
                document.getElementById('errCauHinh').innerText = 'Thông tin cấu hình bắt buộc nhập.';
                valid = false;
            } else if (cauHinh.length > 255) {
                document.getElementById('errCauHinh').innerText = 'Thông tin cấu hình không quá 255 ký tự.';
                valid = false;
            }
            if (!hinhAnh) {
                document.getElementById('errHinhAnh').innerText = 'Hình ảnh bắt buộc chọn.';
                valid = false;
            } else {
                const ext = hinhAnh.split('.').pop().toLowerCase();
                if (!["png","jpg","jpeg"].includes(ext)) {
                    document.getElementById('errHinhAnh').innerText = 'Chỉ chấp nhận file png, jpg, jpeg.';
                    valid = false;
                }
            }
            return valid;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="header">
        <img src="${pageContext.request.contextPath}/views/img/logo.png" alt="Fongo HomePhone Logo" height="80"/>
    </div>
    <div class="nav">
        <a href="${pageContext.request.contextPath}/home">Danh sách sản phẩm</a> |
        <a href="${pageContext.request.contextPath}/add-phone">Thêm mới sản phẩm</a> |
        <a href="${pageContext.request.contextPath}/quan-ly">Chức năng quản lý</a>
    </div>
    <div class="content">
    <h2>Thêm điện thoại mới</h2>
    <c:if test="${not empty errors}">
        <div class="error">
            <ul>
                <c:forEach var="err" items="${errors}">
                    <li>${err}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/add-phone" enctype="multipart/form-data" onsubmit="return validateForm();">
        <div class="form-group">
            <label for="maDT">Mã ĐT:</label>
            <input type="text" id="maDT" name="maDT" required />
            <span class="error" id="errMaDT"></span>
        </div>
        <div class="form-group">
            <label for="tenDT">Tên điện thoại:</label>
            <input type="text" id="tenDT" name="tenDT" required />
            <span class="error" id="errTenDT"></span>
        </div>
        <div class="form-group">
            <label for="namSX">Năm sản xuất:</label>
            <input type="text" id="namSX" name="namSX" required maxlength="4" />
            <span class="error" id="errNamSX"></span>
        </div>
        <div class="form-group">
            <label for="cauHinh">Thông tin cấu hình:</label>
            <textarea id="cauHinh" name="cauHinh" required maxlength="255"></textarea>
            <span class="error" id="errCauHinh"></span>
        </div>
        <div class="form-group">
            <label for="hinhAnh">Hình ảnh (png, jpg, jpeg):</label>
            <input type="file" id="hinhAnh" name="hinhAnh" accept=".png,.jpg,.jpeg" required />
            <span class="error" id="errHinhAnh"></span>
        </div>
        <div class="form-group">
            <label for="maNCC">Nhà cung cấp:</label>
            <select id="maNCC" name="maNCC" required>
                <option value="">--Chọn nhà cung cấp--</option>
                <c:forEach var="ncc" items="${nccList}">
                    <option value="${ncc.maNCC}">${ncc.tenNCC}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Thêm</button>
    </form>
    </div>
</div>
    <div class="footer">
        Nguyễn Huỳnh Anh Thắng - 21074621 - DHKTPM18BTT
    </div>
</div>
</body>
</html>
