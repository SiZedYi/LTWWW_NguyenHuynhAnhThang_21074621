package fit.iuh.thang.bai01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/user-registration")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final List<User> users = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Show registration form
        request.getRequestDispatcher("/bai01/user-registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String reEmail = request.getParameter("reEmail");
        String password = request.getParameter("password");
        String birthMonth = request.getParameter("birthMonth");
        String birthDay = request.getParameter("birthDay");
        String birthYear = request.getParameter("birthYear");
        String gender = request.getParameter("gender");

        // Simple validation
        if (firstName == null || lastName == null || email == null || password == null || gender == null || birthMonth == null || birthDay == null || birthYear == null || !email.equals(reEmail)) {
            request.setAttribute("error", "Please fill all fields correctly.");
            request.getRequestDispatcher("/bai01/user-registration.jsp").forward(request, response);
            return;
        }

        // Parse birthday
        Date birthday = null;
        try {
            String dobStr = birthDay + "-" + birthMonth + "-" + birthYear;
            birthday = new SimpleDateFormat("dd-MM-yyyy").parse(dobStr);
        } catch (Exception e) {
            birthday = null;
        }

        // Create user and add to list
        User user = new User(firstName, lastName, email, birthday, gender, password);
        users.add(user);

        // Forward to account list
        request.setAttribute("users", users);
        System.out.println(users);
        request.getRequestDispatcher("/bai01/account-list.jsp").forward(request, response);
    }
}

