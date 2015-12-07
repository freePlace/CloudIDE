package org.freeplace.cloudide.model;

import org.freeplace.cloudide.model.programminglanguage.ProgrammingLanguage;
import org.freeplace.cloudide.model.user.User;

import javax.persistence.*;

/**
 * Created by Ruslan on 06.12.2015.
 */
@Entity
@Table(name = Project.TABLE_NAME)
public class Project extends AbstractModel{

    public static final String TABLE_NAME = "project";
    public static final String TABLE_ID = "id_project";
    public static final String COLUMN_NAME = "name";
    public static final String PROGRAMMING_LANGUAGE_MAPPED_BY = "programmingLanguage";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TABLE_ID)
    private int id;

    @Column(name = COLUMN_NAME)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = User.TABLE_ID, nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ProgrammingLanguage.TABLE_ID, nullable = false)
    private ProgrammingLanguage programmingLanguage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
