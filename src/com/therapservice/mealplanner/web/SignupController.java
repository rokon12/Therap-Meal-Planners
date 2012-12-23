package com.therapservice.mealplanner.web;

import com.therapservice.mealplanner.domain.Role;
import com.therapservice.mealplanner.domain.User;
import com.therapservice.mealplanner.service.UserService;
import com.therapservice.mealplanner.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 12:38 PM
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(SignupController.class);
    private UserService userService;

    public SignupController() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User registeringUser = new User();

        registeringUser.setUserName(request.getParameter("userName"));
        registeringUser.setPassword(request.getParameter("password"));
        registeringUser.setPasswordConfirmed(request.getParameter("passwordConfirmed"));
        registeringUser.setEmail(request.getParameter("email"));
        registeringUser.setRole(Role.ROLE_USER);

        Map<String, String> messages = new HashMap<String, String>();
        if (!validateUser(registeringUser, messages)) {
            request.setAttribute("error", messages);
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        } else {
            userService.saveNewUser(registeringUser);
            response.sendRedirect("login");
        }
    }

    private boolean validateUser(User registeringUser, Map<String, String> messages) {
        boolean isValid = true;

        if (registeringUser.getUserName().isEmpty()) {
            messages.put("username.empty", "User Name is Required");
            isValid = false;
        }
        if (registeringUser.getPassword().isEmpty()) {
            messages.put("password.empty", "Password is Required");
            isValid = false;
        }
        if (registeringUser.getPasswordConfirmed().isEmpty()) {
            messages.put("passwordConfirmed.empty", "Password is Required");
            isValid = false;
        }
        if (registeringUser.getEmail().isEmpty()) {
            messages.put("email.empty", "Email is Required");
            isValid = false;
        } else if (!registeringUser.getEmail().matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            messages.put("email.error", "Invalid email, please try again.");
            isValid = false;
        }
        if (isValid) {
            if (!registeringUser.getPassword().equals(registeringUser.getPasswordConfirmed())) {
                messages.put("password.mismatched", "Password and Confirmed Password Mismatched");
                isValid = false;
            }
        }
        return isValid;
    }

}
