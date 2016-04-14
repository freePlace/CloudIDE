package com.freeplace.cloudide.dao.programminglanguage;

import com.freeplace.cloudide.dao.AbstractDAOTest;
import org.freeplace.cloudide.model.programminglanguage.ProgrammingLanguage;
import org.junit.Assert;
import org.dbunit.dataset.IDataSet;
import org.freeplace.cloudide.dao.programminglanguage.ProgrammingLanguageDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ruslan on 15.01.2016.
 */
public class ProgrammingLanguageDAOTest extends AbstractDAOTest {
private int test;
    @Autowired
    private ProgrammingLanguageDAO programmingLanguageDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return resourceNamesToDataSet("ProgrammingLanguage.xml");
    }

    @Override
    public void testFindById() {
        findByIdHelper(programmingLanguageDAO);
    }

    @Override
    public void testFindAll() {
        Assert.assertEquals(2, programmingLanguageDAO.findAll().size());
        Assert.assertEquals("lang1", programmingLanguageDAO.findAll().get(0).getName());
        Assert.assertEquals("lang2", programmingLanguageDAO.findAll().get(1).getName());
    }

    @Override
    public void testCreate() {
        Assert.assertEquals(2, programmingLanguageDAO.findAll().size());
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        String testName = "scala";
        programmingLanguage.setName(testName);
        Assert.assertNull(programmingLanguageDAO.findOneByColumnValue("name",testName));
        programmingLanguageDAO.create(programmingLanguage);
        Assert.assertEquals(3, programmingLanguageDAO.findAll().size());
        Assert.assertNotNull(programmingLanguageDAO.findOneByColumnValue("name",testName));
    }

    @Override
    public void testDelete() {
        deleteHelper(programmingLanguageDAO);
    }
}
