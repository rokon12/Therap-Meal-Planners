package com.therapservice.mealplanner.dao;

import com.therapservice.mealplanner.utils.DatabaseConnectionPool;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 3:38 PM
 */
public class JdbcConnectionTest {
    @Test
    public void testConnection() {
        try {
            Connection connection = DatabaseConnectionPool.getConnection();
            Assert.assertNotNull(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
