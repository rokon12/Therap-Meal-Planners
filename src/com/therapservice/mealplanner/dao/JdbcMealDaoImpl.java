package com.therapservice.mealplanner.dao;

import com.therapservice.mealplanner.domain.Meal;
import com.therapservice.mealplanner.utils.DatabaseTemplate;
import com.therapservice.mealplanner.utils.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/24/12
 * Time: 6:20 PM
 */
public class JdbcMealDaoImpl implements MealDao {
    Logger log = LoggerFactory.getLogger(JdbcMealDaoImpl.class);

    @Override
    public void createNewMeal(Meal meal) {
        meal.setDateCreated(new java.sql.Date(new java.util.Date().getTime()));
        DatabaseTemplate.executeInsertQuery("INSERT INTO Meal (createdBy, startTime, endTime, dateCreated, day, dish, mealType) VALUES (?,?,?,?,?,?,?)",
                meal.getCreatedBy(), meal.getStartTime(), meal.getEndTime(), meal.getDateCreated(), meal.getDay(), meal.getDish(), meal.getMealType());
    }

    @Override
    public Meal findMealById(int mealId) {
        List<Meal> meals = DatabaseTemplate.queryForObject("SELECT * FROM Meal where id = '" + mealId + "'", new ObjectRowMapper<Meal>() {
            @Override
            public Meal mapRowToObject(ResultSet resultSet) throws SQLException {
                Meal meal = new Meal();
                meal.setStartTime(resultSet.getString("startTime"));
                meal.setEndTime(resultSet.getString("endTime"));
                meal.setMealType(resultSet.getString("mealType"));
                meal.setId(resultSet.getInt("id"));
                meal.setCreatedBy(resultSet.getString("createdBy"));
                meal.setDish(resultSet.getString("dish"));
                meal.setDay(resultSet.getDate("day"));
                return meal;
            }
        });
        return meals.size() > 0 ? meals.get(0) : null;
    }

    @Override
    public Meal findMealByDay(java.sql.Date date) {
        List<Meal> meals = DatabaseTemplate.queryForObject("SELECT * FROM Meal where day = '" + date + "'", new ObjectRowMapper<Meal>() {
            @Override
            public Meal mapRowToObject(ResultSet resultSet) throws SQLException {
                return getMealFromResultSet(resultSet);
            }
        });
        return meals.size() > 0 ? meals.get(0) : null;
    }

    @Override
    public void updateMeal(Meal meal) {

        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE Meal SET ");
        builder.append(" startTime ='").append(meal.getStartTime());
        builder.append("', endTime ='").append(meal.getEndTime());
        builder.append("', dateLastUpdated ='").append(new Date(new java.util.Date().getTime()));
        builder.append("', dish ='").append(meal.getDish());
        builder.append("', mealType ='").append(meal.getMealType());
        builder.append("'  WHERE id= ").append(meal.getId());

        log.debug(builder.toString());
        //DatabaseTemplate.execute(builder.toString());
    }

    @Override
    public List<Meal> findAllMeal() {
        return null;
    }

    private Meal getMealFromResultSet(ResultSet resultSet) throws SQLException {
        Meal meal = new Meal();
        meal.setStartTime(resultSet.getString("startTime"));
        meal.setEndTime(resultSet.getString("endTime"));
        meal.setMealType(resultSet.getString("mealType"));
        meal.setId(resultSet.getInt("id"));
        meal.setCreatedBy(resultSet.getString("createdBy"));
        meal.setDish(resultSet.getString("dish"));
        meal.setDay(resultSet.getDate("day"));
        return meal;
    }
}
