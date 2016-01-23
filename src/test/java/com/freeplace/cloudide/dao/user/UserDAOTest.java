package com.freeplace.cloudide.dao.user;

/**
 * Created by Ruslan on 02.12.2015.
 */
import com.freeplace.cloudide.dao.AbstractDAOTest;
import org.dbunit.dataset.IDataSet;
import org.freeplace.cloudide.dao.user.UserDAO;
import org.freeplace.cloudide.model.user.Role;
import org.freeplace.cloudide.model.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOTest extends AbstractDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return resourceNamesToDataSet("Role.xml","User.xml");
    }

    @Override
    public void testFindById() {
        findByIdHelper(userDAO);
    }

    @Override
    public void testCreate() {
        userDAO.create(getSampleUser());
        Assert.assertNotNull(userDAO.findById(3));
        Assert.assertEquals(userDAO.findAll().size(), 3);
    }


    @Override
    public void testDelete() {
        deleteHelper(userDAO);
    }

    @Override
    public void testFindAll() {
        Assert.assertEquals(userDAO.findAll().size(), 2);
    }

    @Test
    public void findByLogin() {
        Assert.assertTrue(userDAO.findByColumnValue("ADMIN", "login").size() == 1);
        Assert.assertTrue(userDAO.findByColumnValue("qwerty", "login").size() == 0);
    }

    public User getSampleUser() {
        User user = new User();
        user.setFirstName("FirstName");
        user.setLogin("Login");
        user.setPassword("3333");
        user.setEmail("test@gmail.com");
        Role r = new Role();
        r.setName("ROLE_NEW");
        user.setRole(r);
        return user;
    }
}