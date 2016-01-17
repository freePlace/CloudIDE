package com.freeplace.cloudide.dao.user;

import com.freeplace.cloudide.dao.AbstractDAOTest;
import org.dbunit.dataset.IDataSet;
import org.freeplace.cloudide.dao.user.UserAccountDAO;
import org.freeplace.cloudide.model.user.UserAccount;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ruslan on 15.01.2016.
 */
public class UserAccountDAOTest{}/* extends AbstractDAOTest {

    @Autowired
    private UserAccountDAO userAccountDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return resourceNamesToDataSet("UserAccount.xml");
    }

    @Override
    public void testFindById() {
        findByIdHelper(userAccountDAO);
    }

    @Override
    public void testFindAll() {
        Assert.assertEquals(2, userAccountDAO.findAll().size());
        Assert.assertEquals(true, userAccountDAO.findAll().get(0).isAccountNonExpired());
        Assert.assertEquals(false, userAccountDAO.findAll().get(1).isAccountNonLocked());
    }

    @Override
    public void testCreate() {
        Assert.assertEquals(2, userAccountDAO.findAll().size());
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountNonExpired(true);
        userAccountDAO.create(userAccount);
        Assert.assertEquals(3, userAccountDAO.findAll().size());
    }

    @Override
    public void testDelete() {
        deleteHelper(userAccountDAO);
    }
}*/