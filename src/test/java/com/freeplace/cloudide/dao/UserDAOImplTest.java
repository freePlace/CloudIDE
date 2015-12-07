package com.freeplace.cloudide.dao;

/**
 * Created by Ruslan on 02.12.2015.
 */
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.freeplace.cloudide.dao.user.UserDAO;
import org.freeplace.cloudide.model.user.Role;
import org.freeplace.cloudide.model.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImplTest extends EntityDAOImplTest {

    @Autowired
    private UserDAO userDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet[] datasets = {
                new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Role.xml")),
                new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("User.xml")) };
        return new CompositeDataSet(datasets);
    }

    @Test
    public void findById() {
        Assert.assertNotNull(userDAO.findById(1));
        Assert.assertNull(userDAO.findById(3));
    }

    @Test
    public void saveUser() {
        userDAO.create(getSampleUser());
        Assert.assertEquals(userDAO.findAll().size(), 3);
    }

    @Test
    public void findAllEmployees() {
        Assert.assertEquals(userDAO.findAll().size(), 2);
    }

    @Test
    public void findEmployeeBySsn() {
        Assert.assertNotNull(userDAO.findByColumnValue("ADMIN", User.COLUMN_LOGIN));
        Assert.assertNull(userDAO.findByColumnValue("qwerty", User.COLUMN_LOGIN));
    }

    public User getSampleUser() {
        User user = new User();
        user.setFirstName("FirstName");
        user.setLogin("Login");
        user.setPassword("3333");
        Role r = new Role();
        r.setId(1);
        r.setName("ROLE_USER");

        user.setRole(r);
        return user;
    }

}