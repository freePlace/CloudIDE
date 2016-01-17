package com.freeplace.cloudide.dao.user;

import com.freeplace.cloudide.dao.AbstractDAOTest;
import org.dbunit.dataset.IDataSet;
import org.freeplace.cloudide.dao.user.RoleDAO;
import org.freeplace.cloudide.model.user.Role;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ruslan on 15.01.2016.
 */
public class RoleDAOTest extends AbstractDAOTest {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return resourceNamesToDataSet("Role.xml");
    }

    @Override
    public void testFindById() {
        findByIdHelper(roleDAO);
    }

    @Override
    public void testFindAll() {
        Assert.assertEquals(2, roleDAO.findAll().size());
        Assert.assertEquals("ROLE_ADMIN", roleDAO.findAll().get(0).getName());
        Assert.assertEquals("ROLE_USER", roleDAO.findAll().get(1).getName());
    }

    @Override
    public void testCreate() {
        Assert.assertEquals(2, roleDAO.findAll().size());
        Role role = new Role();
        String testName = "ROLE_TEST";
        role.setName(testName);
        Assert.assertNull(roleDAO.findOneByColumnValue(testName, "name"));
        roleDAO.create(role);
        Assert.assertEquals(3, roleDAO.findAll().size());
        Assert.assertNotNull(roleDAO.findOneByColumnValue(testName, "name"));
    }

    @Override
    public void testDelete() {
        deleteHelper(roleDAO);
    }
}