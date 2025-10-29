<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            width: 400px;
            margin: 40px auto;
            background: #f7f7f7;
            padding: 30px;
            border-radius: 8px;
        }

        h2 {
            text-align: center;
        }

        .row {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="email"], input[type="password"], select {
            width: 100%;
            padding: 8px;
        }

        .gender-row {
            display: flex;
            gap: 20px;
            margin-top: 8px;
        }

        .btn {
            width: 100%;
            background: #2056a7;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration Form</h2>
    <form action="${pageContext.request.contextPath}/user-registration" method="post">
        <div class="row">
            <label for="firstName">First Name</label>
            <input type="text" id="firstName" name="firstName" required>
        </div>
        <div class="row">
            <label for="lastName">Last Name</label>
            <input type="text" id="lastName" name="lastName" required>
        </div>
        <div class="row">
            <label for="email">Your Email</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="row">
            <label for="reEmail">Re-enter Email</label>
            <input type="email" id="reEmail" name="reEmail" required>
        </div>
        <div class="row">
            <label for="password">New Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="row">
            <label>Birthday</label>
            <div class="col-3">
                <select name="birthMonth" required>
                    <option value="">Month</option>
                    <option value="1">January</option>
                    <option value="2">February</option>
                    <option value="3">March</option>
                    <option value="4">April</option>
                    <option value="5">May</option>
                    <option value="6">June</option>
                    <option value="7">July</option>
                    <option value="8">August</option>
                    <option value="9">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
            </div>

            <div class="col-3">
                <select name="birthDay" required>
                    <option value="">Day</option>
                    <% for (int i = 1; i <= 31; i++) { %>
                    <option value="<%=i%>"><%=i%>
                    </option>
                    <% } %>
                </select>
            </div>
            <div class="col-3">
                <select name="birthYear" required>
                    <option value="">Year</option>
                    <% for (int i = 1980; i <= 2025; i++) { %>
                    <option value="<%=i%>"><%=i%>
                    </option>
                    <% } %>
                </select>
            </div>


        </div>
        <div class="row gender-row">
            <label><input type="radio" name="gender" value="Female" required> Female</label>
            <label><input type="radio" name="gender" value="Male"> Male</label>
        </div>
        <div class="row">
            <button type="submit" class="btn">Sign Up</button>
        </div>
    </form>
</div>
</body>
</html>

