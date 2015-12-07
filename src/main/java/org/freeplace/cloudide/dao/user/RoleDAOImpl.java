package org.freeplace.cloudide.dao.user;

import org.freeplace.cloudide.dao.AbstractDAO;
import org.freeplace.cloudide.model.user.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Repository
public class RoleDAOImpl extends AbstractDAO<Role, Integer> implements RoleDAO{
}
