package org.freeplace.cloudide.model.user;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Entity
public class Role extends AbstractEntity {
    public static final String TABLE_ID = "id_role";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
