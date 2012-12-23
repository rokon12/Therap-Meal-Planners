package com.therapservice.mealplanner.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 5:25 PM
 */
@javax.servlet.annotation.WebServlet("/meal/view")
public class MealController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/meals/view.jsp");
    }
}
