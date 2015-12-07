package org.freeplace.cloudide.model.programminglanguage;

import org.freeplace.cloudide.model.AbstractModel;
import org.freeplace.cloudide.model.Project;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Entity
@Table(name = ProgrammingLanguage.TABLE_NAME)
public class ProgrammingLanguage extends AbstractModel {
    public static final String TABLE_NAME = "programming_language";
    public static final String TABLE_ID = "id_programming_language";
    public static final String JOIN_TABLE_PROGRAMMING_LANGUAGE_KEYWORD_NAME = "programming_language_programming_language_keyword";
    public static final String JOIN_TABLE_PROGRAMMING_LANGUAGE_KEYWORD_COLLECTION_NAME = "programmingLanguageKeywords";
    public static final String COLUMN_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = TABLE_ID)
    private int id;

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = JOIN_TABLE_PROGRAMMING_LANGUAGE_KEYWORD_NAME, joinColumns = {
            @JoinColumn(name = TABLE_ID, nullable = false, updatable = false)},
            inverseJoinColumns={@JoinColumn(name=ProgrammingLanguageKeyword.TABLE_ID)})
    private List<ProgrammingLanguageKeyword> programmingLanguageKeywords;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = Project.PROGRAMMING_LANGUAGE_MAPPED_BY)
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
}
