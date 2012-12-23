package com.therapservice.mealplanner.dao;

import com.therapservice.mealplanner.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 12:35 PM
 */
public interface UserDao {
    public void saveNewUser(User user);

    public User findUserByUserName(String userName);

}
