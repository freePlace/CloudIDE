package com.freeplace.cloudide.dao.user.workspace;

import com.freeplace.cloudide.dao.AbstractDAOTest;
import org.dbunit.dataset.IDataSet;
import org.freeplace.cloudide.dao.user.workspace.ResourceTypeDAO;
import org.freeplace.cloudide.model.user.workspace.ResourceType;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ruslan on 15.01.2016.
 */
public class ResourceTypeDAOTest extends AbstractDAOTest {

    @Autowired
    private ResourceTypeDAO resourceTypeDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return resourceNamesToDataSet("ResourceType.xml", "Resource.xml");
    }

    @Override
    public void testFindById() {
        Assert.assertEquals("jsp", resourceTypeDAO.findById(1).getName());
        Assert.assertEquals("java", resourceTypeDAO.findById(2).getName());
    }

    @Override
    public void testFindAll() {
        Assert.assertEquals("jsp", resourceTypeDAO.findAll().get(0).getName());
        Assert.assertEquals("java", resourceTypeDAO.findAll().get(1).getName());
        Assert.assertEquals(2, resourceTypeDAO.findAll().size());
    }

    @Override
    public void testCreate() {
        ResourceType resourceType = new ResourceType();
        String iconPath = "iconPath";
        String name = "fakeName";
        resourceType.setIconPath(iconPath);
        resourceType.setName(name);
        Assert.assertEquals(2, resourceTypeDAO.findAll().size());
        try {
            resourceTypeDAO.findById(3).getId();
            Assert.fail();
        } catch(ObjectNotFoundException e) { }
        resourceTypeDAO.create(resourceType);
        Assert.assertEquals(3, resourceTypeDAO.findAll().size());
        Assert.assertNotNull(resourceTypeDAO.findOneByColumnValue("iconPath", iconPath));
        Assert.assertEquals(iconPath, resourceTypeDAO.findOneByColumnValue("iconPath", iconPath).getIconPath());
        Assert.assertEquals(name, resourceTypeDAO.findOneByColumnValue("iconPath", iconPath).getName());
    }

    @Override
    public void testDelete() {
        deleteHelper(resourceTypeDAO);
    }
}
