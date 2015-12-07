package org.freeplace.cloudide.model.user;

import org.freeplace.cloudide.model.AbstractModel;

import javax.persistence.*;

/**
 * Created by c3po on 12/5/2015.
 */

@Entity
@Table(name = UserAccount.TABLE_NAME)
public class UserAccount extends AbstractModel {

    public static final String TABLE_NAME = "user_account";
    public static final String TABLE_ID = "id_user_account";
    public static final String COLUMN_ENABLED = "enabled";
    public static final String COLUMN_ACCOUNT_NON_EXPIRED = "account_non_expired";
    public static final String COLUMN_CREDENTIALS_NON_EXPIRED = "credentials_non_expired";
    public static final String COLUMN_ACCOUNT_NON_LOCKED = "account_non_locked";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TABLE_ID)
    private int id;

    @Column(name = COLUMN_ENABLED)
    private boolean enabled;

    @Column(name = COLUMN_ACCOUNT_NON_EXPIRED)
    private boolean accountNonExpired;

    @Column(name = COLUMN_CREDENTIALS_NON_EXPIRED)
    private boolean credentialsNonExpired;

    @Column(name = COLUMN_ACCOUNT_NON_LOCKED)
    private boolean accountNonLocked;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = User.TABLE_ID, unique = true, nullable = false)
    private User user;

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
