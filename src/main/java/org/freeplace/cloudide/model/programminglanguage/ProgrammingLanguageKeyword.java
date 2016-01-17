package org.freeplace.cloudide.model.programminglanguage;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Entity
public class ProgrammingLanguageKeyword extends AbstractEntity {
    public static final String TABLE_ID = "id_programming_language_keyword";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "programmingLanguageKeywords")
    private List<ProgrammingLanguage> programmingLanguages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<ProgrammingLanguage> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
