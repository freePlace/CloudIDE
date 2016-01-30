package org.freeplace.cloudide.dao.user;

import org.freeplace.cloudide.dao.AbstractDAO;
import org.freeplace.cloudide.model.user.UserAccount;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDAO extends AbstractDAO<UserAccount, Integer> {}