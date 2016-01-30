package com.freeplace.cloudide.dao;

/**
 * Created by Ruslan on 02.12.2015.
 */
import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.freeplace.cloudide.configuration.PersistenceConfigTest;
import org.freeplace.cloudide.dao.AbstractDAO;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.io.IOException;


@ContextConfiguration(classes = { PersistenceConfigTest.class })
public abstract class AbstractDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(dataSource);
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }

    protected abstract IDataSet getDataSet() throws Exception;

    protected IDataSet resourceNamesToDataSet(String ... names) throws IOException, DataSetException {
        FlatXmlDataSet result [] = new FlatXmlDataSet[names.length];
        for(int i = 0; i < names.length; i++)
            result[i] = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream(names[i]));
        return new CompositeDataSet(result);
    }

    @Test
    public abstract void testFindById();
    @Test
    public abstract void testFindAll();
    @Test
    public abstract void testCreate();
    @Test
    public abstract void testDelete();

    protected void findByIdHelper(AbstractDAO dao) {
        Assert.assertNotNull(dao.findById(1));
        Assert.assertNotNull(dao.findById(2));

        try {
            dao.findById(3).getId();
            Assert.fail();
        } catch(ObjectNotFoundException e) { }
    }

    protected void deleteHelper(AbstractDAO dao) {
        int initSize = dao.findAll().size();
        int id = dao.findById(2).getId();
        dao.delete(dao.findById(2));
        try {
            dao.findById(id).getId();
            Assert.fail();
        } catch(ObjectNotFoundException e) { }
        Assert.assertEquals(initSize - 1, dao.findAll().size());
    }

}