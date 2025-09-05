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

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationForm() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get data from form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dobDay = request.getParameter("dobDay");
        String dobMonth = request.getParameter("dobMonth");
        String dobYear = request.getParameter("dobYear");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String pinCode = request.getParameter("pinCode");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String[] hobbiesArr = request.getParameterValues("hobbies");
        String hobbiesOther = request.getParameter("hobbiesOther");
        String courseApplied = request.getParameter("courseApplied");

        // Parse birthday
        Date birthday = null;
        try {
            String dobStr = dobDay + "-" + dobMonth + "-" + dobYear;
            birthday = new SimpleDateFormat("dd-MMMM-yyyy").parse(dobStr);
        } catch (Exception e) {
            birthday = null;
        }

        // Collect hobbies
        List<String> hobbies = new ArrayList<>();
        if (hobbiesArr != null) {
            for (String h : hobbiesArr) {
                hobbies.add(h);
            }
        }
        if (hobbiesOther != null && !hobbiesOther.trim().isEmpty()) {
            hobbies.add(hobbiesOther.trim());
        }

        // Collect qualifications
        List<Student.Qualification> qualifications = new ArrayList<>();
        qualifications.add(new Student.Qualification("Class X", request.getParameter("board1"), request.getParameter("percentage1"), request.getParameter("year1")));
        qualifications.add(new Student.Qualification("Class XII", request.getParameter("board2"), request.getParameter("percentage2"), request.getParameter("year2")));
        qualifications.add(new Student.Qualification("Graduation", request.getParameter("board3"), request.getParameter("percentage3"), request.getParameter("year3")));
        qualifications.add(new Student.Qualification("Masters", request.getParameter("board4"), request.getParameter("percentage4"), request.getParameter("year4")));

        // Set data to Student
        Student sv = new Student(firstName, lastName, birthday, email, mobileNumber, gender, address, city, pinCode, state, country, hobbies, qualifications, courseApplied);

        // Set object student to request object
        request.setAttribute("student", sv);

        // Forward to result-form.jsp
        request.getRequestDispatcher("/bai01/result-form.jsp").forward(request, response);
    }
}

