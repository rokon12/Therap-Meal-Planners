package com.therapservice.mealplanner.dao;

import com.therapservice.mealplanner.domain.Role;
import com.therapservice.mealplanner.domain.User;
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
 * Date: 12/23/12
 * Time: 12:37 PM
 */
public class JdbcUserDaoImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(JdbcUserDaoImpl.class);

    @Override
    public void saveNewUser(User user) {
        log.debug("About save new user");
        user.setDateCreated(new Date(new java.util.Date().getTime()));
        user.setDateLastUpdated(new Date(new java.util.Date().getTime()));

//
//        try {
//            Connection conn = DatabaseConnectionPool.getConnection();
//            String query = "insert into User (userName, password, email, role, dateCreated,dateLastUpdated) values (? ,? ,? ,? ,?, ?)";
//            PreparedStatement statement = conn.prepareStatement(query);
//            statement.setString(1, user.getUserName());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getEmail());
//            statement.setInt(4, user.getRole().getValue());
//            statement.setDate(5, new java.sql.Date(user.getDateCreated().getTime()));
//            statement.setDate(6, new java.sql.Date(user.getDateCreated().getTime()));
//            statement.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        DatabaseTemplate.executeInsertQuery("insert into User (userName, password, email, role, dateCreated,dateLastUpdated) values (? ,? ,? ,? ,?, ?)", user.getUserName(), user.getPassword(), user.getEmail(), user.getRole().getValue(), user.getDateCreated(), user.getDateLastUpdated());
    }

    @Override
    public User findUserByUserName(String userName) {
        List<User> users = DatabaseTemplate.queryForObject("SELECT * FROM User where userName= '" + userName + "'", new ObjectRowMapper<User>() {
            @Override
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setEmail(resultSet.getString("email"));
                user.setUserName(resultSet.getString("password"));
                user.setDateCreated(resultSet.getDate("dateCreated"));
                if (resultSet.getInt("role") == Role.ROLE_ADMIN.getValue()) {
                    user.setRole(Role.ROLE_ADMIN);
                } else {
                    user.setRole(Role.ROLE_USER);
                }
                return user;
            }
        });
        return users.size() > 0 ? users.get(0) : null;
    }
}
