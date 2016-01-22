package org.freeplace.cloudide.model.user.workspace;

import org.freeplace.cloudide.model.AbstractEntity;
import org.freeplace.cloudide.model.programminglanguage.ProgrammingLanguage;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Ruslan on 06.12.2015.
 */
@Entity
public class Project extends AbstractEntity {

    public static final String TABLE_ID = "id_project";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    @NotEmpty
    private String name;

    @ManyToOne
    private Workspace workspace;

    @ManyToOne
    @JoinColumn(name = ProgrammingLanguage.TABLE_ID)
    private ProgrammingLanguage programmingLanguage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }
}
