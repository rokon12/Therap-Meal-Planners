package com.therapservice.mealplanner.web;

import com.therapservice.mealplanner.domain.Meal;
import com.therapservice.mealplanner.domain.Role;
import com.therapservice.mealplanner.domain.User;
import com.therapservice.mealplanner.service.MealService;
import com.therapservice.mealplanner.service.MealServiceImpl;
import com.therapservice.mealplanner.service.UserService;
import com.therapservice.mealplanner.service.UserServiceImpl;
import com.therapservice.mealplanner.web.auth.AuthKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 5:25 PM
 */
@javax.servlet.annotation.WebServlet("/meal")
public class MealController extends HttpServlet {
    Logger log = LoggerFactory.getLogger(MealController.class);
    private MealService mealService;
    private UserService userService;

    public MealController() {
        mealService = new MealServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = null;
        List<String> params = Collections.list(request.getParameterNames());
        if (params.contains("new")) {
            validateUserAccess(request, response, requestDispatcher);
            populateEditForm(request);
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/meals/createMeal.jsp");
            requestDispatcher.forward(request, response);
        }
        if (params.contains("edit")) {
            String id = request.getParameter("edit");
            if (!id.isEmpty()) {
                Meal meal = mealService.findMealById(Integer.parseInt(id));
                request.setAttribute("meal", meal);
            }
            populateEditForm(request);

            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/meals/editMeal.jsp");
            requestDispatcher.forward(request, response);
        } else {
            Meal todayMeal = mealService.findMealByDay(new Date(new java.util.Date().getTime()));
            request.setAttribute("meal", todayMeal);
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/meals/view.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void validateUserAccess(HttpServletRequest request, HttpServletResponse response, RequestDispatcher requestDispatcher) throws ServletException, IOException {
        String userName = getLoggedInUserName(request);
        if (!userName.isEmpty()) {
            User user = userService.findByUserName(userName);
            if (user.getRole() != Role.ROLE_ADMIN) {
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/meals/AccessError.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Meal meal = new Meal();
        Map<String, String> errors = new HashMap<String, String>();
        RequestDispatcher requestDispatcher = null;

        String day = request.getParameter("day");
        if (!day.isEmpty()) {
            try {
                meal.setDay(new Date(new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("day").trim()).getTime()));
                log.debug("Today : " + meal.getDay());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        meal.setMealType(request.getParameter("mealType"));
        meal.setDish(request.getParameter("dish"));
        meal.setStartTime(request.getParameter("startTime"));
        meal.setEndTime(request.getParameter("endTime"));
        meal.setCreatedBy(getLoggedInUserName(request));


        if (!validate(meal, errors)) {
            request.setAttribute("errors", errors);
            populateEditForm(request);
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/meals/createMeal.jsp");
            requestDispatcher.forward(request, response);
        } else {
            mealService.createNewMeal(meal);
            Meal todayMeal = mealService.findMealByDay(new Date(new java.util.Date().getTime()));
            request.setAttribute("meal", todayMeal);
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/meals/view.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private boolean validate(Meal meal, Map<String, String> errors) {
        boolean isValid = true;
        if (meal.getDay() == null) {
            errors.put("day.notfound", "Day Field is required");
            isValid = false;
        }
        if (meal.getDish().isEmpty()) {
            errors.put("dish.notfound", "Dish Field is required");

            isValid = false;
        }
        if (meal.getEndTime().isEmpty()) {
            errors.put("endtime.notfound", "End Time Field is required");

            isValid = false;
        }
        if (meal.getStartTime().isEmpty()) {
            errors.put("startime.notfound", "Start Time Field is required");

            isValid = false;
        }
        if (meal.getMealType().isEmpty()) {
            errors.put("mealtype.notfound", "Meal Type Field is required");
            isValid = false;
        }
        return isValid;
    }

    public void populateEditForm(HttpServletRequest request) throws ServletException, IOException {
        List<String> mealType = new ArrayList<String>();
        mealType.add("Dinner");
        mealType.add("Lunch");
        mealType.add("Breakfast");
        mealType.add("Evening Snacks");
        request.setAttribute("mealType", mealType);
    }

    public String getLoggedInUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute(AuthKey.AUTH_KEY);
    }
}
