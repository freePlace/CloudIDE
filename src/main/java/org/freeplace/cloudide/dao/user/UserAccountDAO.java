package org.freeplace.cloudide.dao.user;

import org.freeplace.cloudide.dao.AbstractDAO;
import org.freeplace.cloudide.model.user.UserAccount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ruslan on 15.01.2016.
 */
@Repository
public class UserAccountDAO extends AbstractDAO<UserAccount, Integer>{
}
