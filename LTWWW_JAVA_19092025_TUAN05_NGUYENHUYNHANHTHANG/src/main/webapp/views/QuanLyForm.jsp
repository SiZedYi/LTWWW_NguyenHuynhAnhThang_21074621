<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <h2>Quản lý điện thoại</h2>
    <c:if test="${not empty message}">
        <div style="color: green;">${message}</div>
    </c:if>
    <c:if test="${not empty dienthoaiList}">
        <table style="width:100%; margin-bottom:20px; border-collapse:collapse;">
            <tr style="background:#e3e3f7; font-weight:bold;">
                <td>Mã điện thoại</td>
                <td>Tên điện thoại</td>
                <td>Năm sản xuất</td>
                <td>Cấu hình</td>
                <td>Nhà cung cấp</td>
                <td>Hình ảnh</td>
                <td>Xóa</td>
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
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/quan-ly">
                            <input type="hidden" name="maDT" value="${dt.maDT}" />
                            <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa điện thoại này?');">Xóa</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty dienthoaiList}">
        <h3>Không có sản phẩm nào trong danh sách.</h3>
    </c:if>
</div>
