package com.therapservice.mealplanner.dao;

import com.therapservice.mealplanner.domain.Meal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/25/12
 * Time: 10:00 AM
 */
public class MealDaoTest {
    private MealDao mealDao;

    @Before
    public void before() {
        mealDao = new JdbcMealDaoImpl();

    }

    //@Test
    public void testCreateNewMeal() throws Exception {
        Meal meal = new Meal();
        meal.setDish("asfasfasfasdfsaf asdf sadfas sdafasd sdfas sadfasdf asfasdf");
        meal.setCreatedBy("rokonoid");
        meal.setMealType("Dinner");
        meal.setStartTime("asfdasdf");
        meal.setEndTime("asdfasdf");
        meal.setDay(new Date(new java.util.Date().getTime()));
        mealDao.createNewMeal(meal);

    }

    // @Test
    public void testFindMealById() throws Exception {
        Assert.assertNotNull(mealDao.findMealById(1));
    }

    // @Test
    public void testFindMealByDay() throws Exception {
        Assert.assertNotNull(mealDao.findMealByDay(new Date(new java.util.Date().getTime())));
    }

    @Test
    public void testUpdateMeal() {
        Meal meal = new Meal();
        meal.setDish("asfasfasfasdfsaf asdf sadfas sdafasd sdfas sadfasdf asfasdf");
        meal.setCreatedBy("rokonoid");
        meal.setMealType("Dinner");
        meal.setStartTime("asfdasdf");
        meal.setEndTime("asdfasdf");
        meal.setDay(new Date(new java.util.Date().getTime()));
        mealDao.createNewMeal(meal);

        mealDao.updateMeal(meal);
    }
}
