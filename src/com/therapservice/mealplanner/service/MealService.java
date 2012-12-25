package com.therapservice.mealplanner.service;

import com.therapservice.mealplanner.domain.Meal;

import java.sql.Date;


/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/24/12
 * Time: 6:23 PM
 */
public interface MealService {
    public void createNewMeal(Meal meal);

    public Meal findMealById(int mealId);

    public Meal findMealByDay(Date date);
}
