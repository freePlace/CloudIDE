package org.freeplace.cloudide.model.navigation;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by Ruslan on 18.01.2016.
 */
@Entity
public class NavigationExecute extends AbstractEntity {

    private static final String TABLE_ID = "id_navigation_execute";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = NavigationPanel.TABLE_ID)
    private NavigationPanel navigationPanel;

    @Override
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

    public NavigationPanel getNavigationPanel() {
        return navigationPanel;
    }

    public void setNavigationPanel(NavigationPanel navigationPanel) {
        this.navigationPanel = navigationPanel;
    }
}
