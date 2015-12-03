package org.freeplace.cloudide.configuration.security;

/**
 * Created by Ruslan on 03.12.2015.
 */
public enum Role {
    INSTANCE(Integer.MIN_VALUE), ROLE_ADMIN(1),ROLE_USER(2);

    private int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    int getRoleId() {
        return roleId;
    }

    public String getRoleNameById(int roleId) {
        for(Role role : Role.values()) {
            if(role.getRoleId() == roleId) return role.name();
        }
        return null;
    }

    public String [] getMainPageHasRolesAsStrings() {
        return new String[]{"hasRole('" + Role.ROLE_ADMIN.name() + "')",
                            "hasRole('" + Role.ROLE_USER.name() + "')"};
    }
}
