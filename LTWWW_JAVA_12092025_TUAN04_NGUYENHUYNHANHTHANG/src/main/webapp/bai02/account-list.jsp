<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.thang.bai01.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account List</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 600px; margin: 40px auto; background: #f7f7f7; padding: 30px; border-radius: 8px; }
        h2 { text-align: center; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #2056a7; padding: 8px; text-align: center; }
        th { background: #2056a7; color: #fff; }
    </style>
</head>
<body>
<div class="container">
    <h2>Account List</h2>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Birthday</th>
            <th>Gender</th>
        </tr>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            if (users != null) {
                for (User u : users) {
        %>
        <tr>
            <td><%= u.getFirstName() %></td>
            <td><%= u.getLastName() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getBirthday() != null ? u.getBirthday() : "" %></td>
            <td><%= u.getGender() %></td>
        </tr>
        <%      }
            }
        %>
    </table>
    <div style="margin-top:20px;text-align:center;">
        <a href="${pageContext.request.contextPath}/bai02/user-registration.jsp">Register New User</a>
    </div>
</div>
</body>
</html>

