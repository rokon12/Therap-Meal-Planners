package com.therapservice.mealplanner.dao;

import com.therapservice.mealplanner.domain.Meal;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/24/12
 * Time: 6:19 PM
 */
public interface MealDao {
    public void createNewMeal(Meal meal);

    public Meal findMealById(int meal);

    public Meal findMealByDay(Date date);

}
