<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .form-container {
            width: 700px;
            margin: 20px auto;
            background-color: #b3e0f2;
            background: #b3e0f2;
            padding: 20px;
            border-radius: 8px;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input[type="text"], input[type="email"], textarea, select {
            width: 300px;
            padding: 5px;
            margin-top: 5px;
        }

        .row {
            display: flex;
            align-items: center;
            margin-top: 10px;
        }

        .row label {
            width: 150px;
        }

        .hobbies label, .courses label {
            display: inline-block;
            margin-right: 10px;
        }

        .qualification-table {
            border: 2px solid #0077b6;
            background: #e0f7fa;
            margin-top: 10px;
            width: 100%;
        }

        .qualification-table th, .qualification-table td {
            padding: 5px 10px;
            border: 1px solid #0077b6;
            width: 100%;
            text-align: center;
        }

        .buttons {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <form action="${pageContext.request.contextPath}/registration-form" name="formDangKy" method="GET">
        <div class="row">
            <label for="firstName">First name</label>
            <input type="text" id="firstName" name="firstName" maxlength="30" pattern="[A-Za-z ]{1,30}" required>
            <span>(max 30 characters a-z and A-Z)</span>
        </div>
        <div class="row">
            <label for="lastName">Last name</label>
            <input type="text" id="lastName" name="lastName" maxlength="30" pattern="[A-Za-z ]{1,30}" required>
            <span>(max 30 characters a-z and A-Z)</span>
        </div>
        <div class="row">
            <label>Date of birth</label>
            <select name="dobDay" required>
                <option value="">Day</option>
                <% for (int i = 1; i <= 31; i++) { %>
                <option value="<%=i%>"><%=i%>
                </option>
                <% } %>
            </select>
            <select name="dobMonth" required>
                <option value="">Month</option>
                <% String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                    for (int i = 0; i < months.length; i++) { %>
                <option value="<%=months[i]%>"><%=months[i]%>
                </option>
                <% } %>
            </select>
            <select name="dobYear" required>
                <option value="">Year</option>
                <% for (int i = 1980; i <= 2025; i++) { %>
                <option value="<%=i%>"><%=i%>
                </option>
                <% } %>
            </select>
        </div>
        <div class="row">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="row">
            <label for="mobileNumber">Mobile number</label>
            <input type="text" id="mobileNumber" name="mobileNumber" maxlength="10" pattern="\d{10}" required>
            <span>(10 digit number)</span>
        </div>
        <div class="row">
            <label>Gender</label>
            <input type="radio" id="male" name="gender" value="Male" required> <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="Female"> <label for="female">Female</label>
        </div>
        <div class="row">
            <label for="address">Address</label>
            <textarea id="address" name="address" rows="3" cols="40"></textarea>
        </div>
        <div class="row">
            <label for="city">City</label>
            <input type="text" id="city" name="city" maxlength="30" pattern="[A-Za-z ]{1,30}">
            <span>(max 30 characters a-z and A-Z)</span>
        </div>
        <div class="row">
            <label for="pinCode">Pin code</label>
            <input type="text" id="pinCode" name="pinCode" maxlength="6" pattern="\d{6}">
            <span>(6 digit number)</span>
        </div>
        <div class="row">
            <label for="state">State</label>
            <input type="text" id="state" name="state" maxlength="30" pattern="[A-Za-z ]{1,30}">
            <span>(max 30 characters a-z and A-Z)</span>
        </div>
        <div class="row">
            <label for="country">Country</label>
            <input type="text" id="country" name="country" value="India">
        </div>
        <div class="row hobbies">
            <label>Hobbies</label>
            <input type="checkbox" name="hobbies" value="Drawing"> Drawing
            <input type="checkbox" name="hobbies" value="Singing"> Singing
            <input type="checkbox" name="hobbies" value="Dancing"> Dancing
            <input type="checkbox" name="hobbies" value="Sketching"> Sketching
            <input type="checkbox" name="hobbies" value="Others"> Others
            <input type="text" name="hobbiesOther" placeholder="Specify">
        </div>
        <div class="qualification-table">
            <table style="width:100%; table-layout:fixed;">
                <tr>
                    <th style="width:10%">Sl.No.</th>
                    <th style="width:20%">Examination</th>
                    <th style="width:25%">Board</th>
                    <th style="width:25%">Percentage</th>
                    <th style="width:20%">Year of Passing</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Class X</td>
                    <td><input type="text" name="board1" maxlength="10" style="width:90%"></td>
                    <td><input type="text" name="percentage1" maxlength="5" pattern="\d{1,3}(\.\d{1,2})?"
                               style="width:90%"></td>
                    <td><input type="text" name="year1" maxlength="4" pattern="\d{4}" style="width:90%"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Class XII</td>
                    <td><input type="text" name="board2" maxlength="10" style="width:90%"></td>
                    <td><input type="text" name="percentage2" maxlength="5" pattern="\d{1,3}(\.\d{1,2})?"
                               style="width:90%"></td>
                    <td><input type="text" name="year2" maxlength="4" pattern="\d{4}" style="width:90%"></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Graduation</td>
                    <td><input type="text" name="board3" maxlength="10" style="width:90%"></td>
                    <td><input type="text" name="percentage3" maxlength="5" pattern="\d{1,3}(\.\d{1,2})?"
                               style="width:90%"></td>
                    <td><input type="text" name="year3" maxlength="4" pattern="\d{4}" style="width:90%"></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Masters</td>
                    <td><input type="text" name="board4" maxlength="10" style="width:90%"></td>
                    <td><input type="text" name="percentage4" maxlength="5" pattern="\d{1,3}(\.\d{1,2})?"
                               style="width:90%"></td>
                    <td><input type="text" name="year4" maxlength="4" pattern="\d{4}" style="width:90%"></td>
                </tr>
            </table>
        </div>
        <div class="row courses">
            <label>Course applies for</label>
            <input type="radio" name="courseApplied" value="BCA" required> BCA
            <input type="radio" name="courseApplied" value="B.Com"> B.Com
            <input type="radio" name="courseApplied" value="B.Sc"> B.Sc
            <input type="radio" name="courseApplied" value="B.A"> B.A
        </div>
        <div class="buttons">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</div>
</body>
</html>
