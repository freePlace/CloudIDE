package org.freeplace.cloudide.model;

import javax.persistence.*;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Entity
@Table(name = User.TABLE_NAME)
public class User extends AbstractModel{
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "id_user";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_PASSWORD = "password";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int id;

    @Column(name = COLUMN_FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = COLUMN_LOGIN, unique = true, nullable = false)
    private String login;

    @Column(name = COLUMN_PASSWORD, nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = Role.COLUMN_ID, nullable = false)
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = UserAccount.COLUMN_ID, unique = true, nullable = false, updatable = false)
    private UserAccount userAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

}