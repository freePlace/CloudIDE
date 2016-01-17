package com.freeplace.cloudide.dao.programminglanguage;

import com.freeplace.cloudide.dao.AbstractDAOTest;
import org.dbunit.dataset.IDataSet;
import org.freeplace.cloudide.dao.programminglanguage.ProgrammingLanguageKeywordDAO;
import org.freeplace.cloudide.model.programminglanguage.ProgrammingLanguageKeyword;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ruslan on 15.01.2016.
 */
public class ProgrammingLanguageKeywordDAOTest extends AbstractDAOTest {

    @Autowired
    private ProgrammingLanguageKeywordDAO programmingLanguageKeywordDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return resourceNamesToDataSet("ProgrammingLanguageKeyword.xml");
    }

    @Override
    public void testFindById() {
        findByIdHelper(programmingLanguageKeywordDAO);
    }

    @Override
    public void testFindAll() {
        Assert.assertEquals(2, programmingLanguageKeywordDAO.findAll().size());
        Assert.assertEquals("static", programmingLanguageKeywordDAO.findAll().get(0).getName());
        Assert.assertEquals("int", programmingLanguageKeywordDAO.findAll().get(1).getName());
    }

    @Override
    public void testCreate() {
        Assert.assertEquals(2, programmingLanguageKeywordDAO.findAll().size());
        ProgrammingLanguageKeyword programmingLanguageKeyword = new ProgrammingLanguageKeyword();
        String testName = "double";
        programmingLanguageKeyword.setName(testName);
        Assert.assertNull(programmingLanguageKeywordDAO.findOneByColumnValue(testName, "name"));
        programmingLanguageKeywordDAO.create(programmingLanguageKeyword);
        Assert.assertEquals(3, programmingLanguageKeywordDAO.findAll().size());
        Assert.assertNotNull(programmingLanguageKeywordDAO.findOneByColumnValue(testName, "name"));
    }

    @Override
    public void testDelete() {
        deleteHelper(programmingLanguageKeywordDAO);
    }
}