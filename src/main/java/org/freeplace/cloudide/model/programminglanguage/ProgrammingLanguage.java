package org.freeplace.cloudide.model.programminglanguage;

import org.freeplace.cloudide.model.AbstractEntity;
import org.freeplace.cloudide.model.user.workspace.Project;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Entity
public class ProgrammingLanguage extends AbstractEntity {
    public static final String TABLE_ID = "id_programming_language";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = {
            @JoinColumn(name = TABLE_ID, nullable = false, updatable = false)},
            inverseJoinColumns={@JoinColumn(name=ProgrammingLanguageKeyword.TABLE_ID)})
    private List<ProgrammingLanguageKeyword> programmingLanguageKeywords;

    @OneToMany(mappedBy = "programmingLanguage")
    private List<Project> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProgrammingLanguageKeyword> getProgrammingLanguageKeywords() {
        return programmingLanguageKeywords;
    }

    public void setProgrammingLanguageKeywords(List<ProgrammingLanguageKeyword> programmingLanguageKeywords) {
        this.programmingLanguageKeywords = programmingLanguageKeywords;
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
}
