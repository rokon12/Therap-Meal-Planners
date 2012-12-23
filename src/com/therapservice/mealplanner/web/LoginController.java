package com.therapservice.mealplanner.web;

import com.therapservice.mealplanner.domain.User;
import com.therapservice.mealplanner.service.UserService;
import com.therapservice.mealplanner.service.UserServiceImpl;
import com.therapservice.mealplanner.web.auth.AuthKey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 3:52 PM
 */
@javax.servlet.annotation.WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserService userService;

    public LoginController() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = new User();

        String userName = (request.getParameter("userName"));
        String password = (request.getParameter("password"));


        Map<String, String> messages = new HashMap<String, String>();
        if (!validateUser(userName, password, messages)) {

            request.setAttribute("error", messages);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } else if (!userService.checkLogin(userName, password)) {
            messages.put("userNotFound", "Incorrect UserName/Password, Please Try again with valid user name and password");
            request.setAttribute("error", messages);
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute(AuthKey.AUTH_KEY, userName);

            response.sendRedirect("home/index");
        }
    }

    private boolean validateUser(String userName, String password, Map<String, String> messages) {
        boolean isValid = true;

        if (userName.isEmpty()) {
            messages.put("username.empty", "User Name is Required");
            isValid = false;
        }
        if (password.isEmpty()) {
            messages.put("password.empty", "Password is Required");
            isValid = false;
        }

        return isValid;
    }
}
