package com.freeplace.cloudide.dao;

/**
 * Created by Ruslan on 02.12.2015.
 */
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.freeplace.cloudide.dao.UserDAO;
import org.freeplace.cloudide.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImplTest extends EntityDAOImplTest {

    @Autowired
    UserDAO userDao;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet[] datasets = {
                new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("User.xml")) };
        return new CompositeDataSet(datasets);
    }

    @Test
    public void findById() {
        Assert.assertNotNull(userDao.findById(1));
        Assert.assertNull(userDao.findById(3));
    }

    @Test
    public void saveUser() {
        userDao.saveUser(getSampleUser());
        Assert.assertEquals(userDao.findAllUsers().size(), 3);
    }

    @Test
    public void deleteEmployeeBySsn() {
        userDao.deleteUserByLogin("ADMIN");
        Assert.assertEquals(userDao.findAllUsers().size(), 1);
    }

    @Test
    public void deleteEmployeeByInvalidSsn() {
        userDao.deleteUserByLogin("qwerty");
        Assert.assertEquals(userDao.findAllUsers().size(), 2);
    }

    @Test
    public void findAllEmployees() {
        Assert.assertEquals(userDao.findAllUsers().size(), 2);
    }

    @Test
    public void findEmployeeBySsn() {
        Assert.assertNotNull(userDao.findUserByLogin("ADMIN"));
        Assert.assertNull(userDao.findUserByLogin("qwerty"));
    }

    public User getSampleUser() {
        User user = new User();
        user.setFirstName("Karen");
        user.setLogin("KarenLogin");
        user.setPassword("3333");
        return user;
    }

}