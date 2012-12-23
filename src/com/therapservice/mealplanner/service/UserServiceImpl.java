package com.therapservice.mealplanner.service;

import com.therapservice.mealplanner.dao.JdbcUserDaoImpl;
import com.therapservice.mealplanner.dao.UserDao;
import com.therapservice.mealplanner.domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 12:52 PM
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new JdbcUserDaoImpl();
    }

    @Override
    public void saveNewUser(User user) {
        userDao.saveNewUser(user);
    }

    @Override
    public boolean checkLogin(String username, String password) {
        User user = userDao.findUserByUserName(username);

        if (user != null) {
            if (password.equals(password)) return true;
        }
        return false;
    }
}
