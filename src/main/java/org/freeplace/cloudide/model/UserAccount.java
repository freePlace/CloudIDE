package org.freeplace.cloudide.model;

import javax.persistence.*;

/**
 * Created by c3po on 12/5/2015.
 */

@Entity
@Table(name = UserAccount.TABLE_NAME)
public class UserAccount {

    public static final String TABLE_NAME = "userAccount";
    public static final String COLUMN_ID = "id_userAccount";
    public static final String COLUMN_ENABLED = "enabled";
    public static final String COLUMN_ACCOUNT_NON_EXPIRED = "accountNonExpired";
    public static final String COLUMN_CREDENTIALS_NON_EXPIRED = "credentialsNonExpired";
    public static final String COLUMN_ACCOUNT_NON_LOCKED = "accountNonLocked";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int id;

    @Column(name = COLUMN_ENABLED)
    private boolean enabled;

    @Column(name = COLUMN_ACCOUNT_NON_EXPIRED)
    private boolean accountNonExpired;

    @Column(name = COLUMN_CREDENTIALS_NON_EXPIRED)
    private boolean credentialsNonExpired;

    @Column(name = COLUMN_ACCOUNT_NON_LOCKED)
    private boolean accountNonLocked;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userAccount")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
