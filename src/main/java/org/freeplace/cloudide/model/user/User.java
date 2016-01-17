package org.freeplace.cloudide.model.user;

import org.freeplace.cloudide.model.AbstractEntity;
import org.freeplace.cloudide.model.user.workspace.Workspace;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Entity
public class User extends AbstractEntity {
    public static final String TABLE_ID = "id_user";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String firstName;

    private String login;

    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = Role.TABLE_ID)
    private Role role;

    @OneToOne(mappedBy = "user")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "user")
    private List<Workspace> workspaces;

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

    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}