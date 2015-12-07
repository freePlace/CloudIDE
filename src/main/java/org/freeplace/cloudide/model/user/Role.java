package org.freeplace.cloudide.model.user;

import org.freeplace.cloudide.model.AbstractModel;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends AbstractModel {
    public static final String TABLE_NAME = "role";
    public static final String TABLE_ID = "id_role";
    public static final String COLUMN_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TABLE_ID)
    private int id;

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = TABLE_NAME)
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
}
