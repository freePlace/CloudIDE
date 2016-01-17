package org.freeplace.cloudide.model.user.workspace;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 15.01.2016.
 */
@Entity
public class ResourceType extends AbstractEntity {

    public static final String TABLE_ID = "id_resource_type";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String name;

    private String iconPath;

    @OneToMany(mappedBy = "resourceType", cascade = CascadeType.REMOVE)
    private List<Resource> resources;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
