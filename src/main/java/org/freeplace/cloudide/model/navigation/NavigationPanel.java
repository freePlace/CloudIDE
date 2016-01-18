package org.freeplace.cloudide.model.navigation;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 18.01.2016.
 */
@Entity
public class NavigationPanel extends AbstractEntity{

    public static final String TABLE_ID = "id_navigation_panel";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String name;

    @OneToMany(mappedBy = "navigationPanel")
    private List<NavigationProject> navigationProjects;

    @OneToMany(mappedBy = "navigationPanel")
    private List<NavigationExecute> navigationExecutes;

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

    public List<NavigationProject> getNavigationProjects() {
        return navigationProjects;
    }

    public void setNavigationProjects(List<NavigationProject> navigationProjects) {
        this.navigationProjects = navigationProjects;
    }

    public List<NavigationExecute> getNavigationExecutes() {
        return navigationExecutes;
    }

    public void setNavigationExecutes(List<NavigationExecute> navigationExecutes) {
        this.navigationExecutes = navigationExecutes;
    }
}
