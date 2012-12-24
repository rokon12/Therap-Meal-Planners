package com.therapservice.mealplanner.web;

import com.therapservice.mealplanner.domain.Meal;
import com.therapservice.mealplanner.service.MealService;
import com.therapservice.mealplanner.service.MealServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public MealController() {
        mealService = new MealServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = null;
        List<String> params = Collections.list(request.getParameterNames());
        if (params.contains("new")) {
            populateEditForm(request, response, requestDispatcher);
        } else {
            requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/meals/view.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        Meal meal = new Meal();
        Map<String, String> errors = new HashMap<String, String>();
        RequestDispatcher requestDispatcher = null;

        /* TODO String to Sql Date conversion doesn't work */

        String day = request.getParameter("day");
        if (!day.isEmpty()) {
            try {
                meal.setDay(new Date(new SimpleDateFormat("mm/dd/yyyy", Locale.ENGLISH).parse(request.getParameter("day").trim()).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        meal.setMealType(request.getParameter("mealType"));
        meal.setDish(request.getParameter("dish"));
        meal.setStartTime(request.getParameter("startTime"));
        meal.setEndTime(request.getParameter("endTime"));


        if (!validate(meal, errors)) {
            request.setAttribute("errors", errors);
            populateEditForm(request, response, requestDispatcher);
        } else {
            mealService.createNewMeal(meal);
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

    public void populateEditForm(HttpServletRequest request, HttpServletResponse response, RequestDispatcher requestDispatcher) throws ServletException, IOException {
        List<String> mealType = new ArrayList<String>();
        mealType.add("Dinner");
        mealType.add("Lunch");
        mealType.add("Breakfast");
        mealType.add("Evening Snacks");
        request.setAttribute("mealType", mealType);

        requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/meals/createMeal.jsp");
        requestDispatcher.forward(request, response);
    }
}
