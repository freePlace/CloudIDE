package org.freeplace.cloudide.service.navigation;

import org.freeplace.cloudide.dao.navigation.NavigationExecuteDAO;
import org.freeplace.cloudide.dao.navigation.NavigationPanelDAO;
import org.freeplace.cloudide.model.navigation.NavigationPanel;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Created by Ruslan on 18.01.2016.
 */
@Service
public class NavigationPanelService {

    @Autowired
    private NavigationPanelDAO navigationPanelDAO;

    @Transactional
    public NavigationPanel loadMainNavigationPanel() {
        NavigationPanel panel = navigationPanelDAO.findOneByColumnValue("name", "main");
        Hibernate.initialize(panel.getNavigationExecutes());
        Hibernate.initialize(panel.getNavigationProjects());
        return panel;
    }
}