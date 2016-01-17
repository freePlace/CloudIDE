package com.freeplace.cloudide.dao.user.workspace;

import com.freeplace.cloudide.dao.AbstractDAOTest;
import org.dbunit.dataset.IDataSet;
import org.freeplace.cloudide.dao.user.workspace.ResourceDAO;
import org.freeplace.cloudide.model.user.workspace.Resource;
import org.freeplace.cloudide.model.user.workspace.ResourceType;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ruslan on 14.01.2016.
 */
public class ResourceDAOTest extends AbstractDAOTest {

    @Autowired
    private ResourceDAO resourceDAO;

    @Override
    protected IDataSet getDataSet() throws Exception {
        return resourceNamesToDataSet("ResourceType.xml", "Resource.xml");
    }

    @Override
    public void testFindById() {
        Assert.assertEquals("c:\\\\Program Files", resourceDAO.findById(1).getPath());
        Assert.assertEquals("c:\\\\Program Files\\fake.txt", resourceDAO.findById(2).getPath());
        Assert.assertEquals(resourceDAO.findById(1).getId(), resourceDAO.findById(2).getRootResource().getId());
    }

    @Override
    public void testFindAll() {
        Assert.assertEquals(2, resourceDAO.findAll().size());
        Assert.assertEquals("c:\\\\Program Files", resourceDAO.findAll().get(0).getPath());
        Assert.assertEquals("c:\\\\Program Files\\fake.txt", resourceDAO.findAll().get(1).getPath());
    }

    @Override
    public void testCreate() {
        Assert.assertEquals(2, resourceDAO.findAll().size());
        Resource rootResource = new Resource();
        String rootPath = "rootPath";
        rootResource.setPath("rootPath");
        Resource resource = new Resource();
        String path = "path";
        resource.setPath(path);
        resource.setRootResource(rootResource);
        ResourceType resourceType = new ResourceType();
        resourceType.setName("fakeName");
        resourceType.setIconPath("fakePath");
        resource.setResourceType(resourceType);
        resourceDAO.create(resource);
        Assert.assertEquals(4, resourceDAO.findAll().size());
    }

    @Override
    public void testDelete() {
        deleteHelper(resourceDAO);
    }
}
