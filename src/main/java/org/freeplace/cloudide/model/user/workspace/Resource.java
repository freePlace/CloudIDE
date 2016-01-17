package org.freeplace.cloudide.model.user.workspace;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 14.01.2016.
 */
@Entity
public class Resource extends AbstractEntity {

    public static final String TABLE_ID = "id_resource";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String path;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_root_resource")
    private Resource rootResource;

    @OneToMany(mappedBy = "rootResource")
    private List<Resource> nestedResources;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name=ResourceType.TABLE_ID)
    private ResourceType resourceType;

    public Resource getRootResource() {
        return rootResource;
    }

    public void setRootResource(Resource rootResource) {
        this.rootResource = rootResource;
    }

    public List<Resource> getNestedResources() {
        return nestedResources;
    }

    public void setNestedResources(List<Resource> nestedResources) {
        this.nestedResources = nestedResources;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
