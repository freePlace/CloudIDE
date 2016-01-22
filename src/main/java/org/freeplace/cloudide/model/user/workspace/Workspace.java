package org.freeplace.cloudide.model.user.workspace;

import org.freeplace.cloudide.model.AbstractEntity;
import org.freeplace.cloudide.model.user.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 14.01.2016.
 */
@Entity
public class Workspace extends AbstractEntity {

    public static final String TABLE_ID = "id_workspace";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = User.TABLE_ID, nullable = false)
    private User user;

    @OneToMany(mappedBy = "workspace")
    private List<Project> projects;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
