package com.therapservice.mealplanner.utils;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface ObjectRowMapper<E> {

    E mapRowToObject(ResultSet resultSet) throws SQLException;
}