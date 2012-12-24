package com.therapservice.mealplanner.service;

import com.therapservice.mealplanner.dao.MealDao;
import com.therapservice.mealplanner.dao.MealDaoImpl;
import com.therapservice.mealplanner.domain.Meal;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/24/12
 * Time: 6:23 PM
 */
public class MealServiceImpl implements MealService {

    private MealDao mealDao;

    public MealServiceImpl() {
        mealDao = new MealDaoImpl();
    }

    @Override
    public void createNewMeal(Meal meal) {
        mealDao.createNewMeal(meal);
    }

    @Override
    public Meal findMealById(int mealId) {
        return mealDao.findMealById(mealId);
    }

    @Override
    public Meal findMealByDay(Date date) {
        return mealDao.findMealByDay(date);
    }
}
