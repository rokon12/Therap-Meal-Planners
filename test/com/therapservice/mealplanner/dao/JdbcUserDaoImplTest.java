package com.therapservice.mealplanner.dao;

import com.therapservice.mealplanner.domain.Role;
import com.therapservice.mealplanner.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 3:02 PM
 */
public class JdbcUserDaoImplTest {

    UserDao userDao = new JdbcUserDaoImpl();

    @Test
    public void testSaveNewUser() throws Exception {
        User user = new User();
        user.setUserName("admin");
        user.setPassword("rokonoid12");
        user.setEmail("anm_brr@yahoo.com");
        user.setRole(Role.ROLE_ADMIN);

        userDao.saveNewUser(user);
    }

    @Test
    public void testFindUserByUserName() throws Exception {
        User user = userDao.findUserByUserName("admin");
        Assert.assertNotNull(user);
    }
}
