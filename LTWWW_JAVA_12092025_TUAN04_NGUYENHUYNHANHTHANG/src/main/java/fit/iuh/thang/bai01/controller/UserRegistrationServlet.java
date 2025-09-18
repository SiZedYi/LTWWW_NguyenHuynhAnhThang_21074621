package fit.iuh.thang.bai01.controller;

import fit.iuh.thang.bai01.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@WebServlet("/user-registration")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final List<User> users = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Show registration form
        request.getRequestDispatcher("/views/bai01/user-registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
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
        //  Validation
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            request.setAttribute("error", "Please fill all fields correctly.");
            request.getRequestDispatcher("/views/bai01/user-registration.jsp").forward(request, response);
            return;
        }

        users.add(user);

        // Forward to account list
        request.setAttribute("users", users);
        System.out.println(users);
        request.getRequestDispatcher("/views/bai01/account-list.jsp").forward(request, response);
    }
}

