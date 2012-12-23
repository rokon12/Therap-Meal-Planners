package com.therapservice.mealplanner.service;

import com.therapservice.mealplanner.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 12:50 PM
 */
public interface UserService {
    public void saveNewUser(User user);

    public boolean checkLogin(String username, String password);
}
