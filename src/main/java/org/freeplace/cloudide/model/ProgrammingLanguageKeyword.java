package org.freeplace.cloudide.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Entity
@Table(name = ProgrammingLanguageKeyword.TABLE_NAME)
public class ProgrammingLanguageKeyword extends AbstractModel{
    public static final String TABLE_NAME = "programming_language_keyword";
    public static final String COLUMN_ID = "id_programming_language_keyword";
    public static final String COLUMN_NAME = "name";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int id;

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = ProgrammingLanguage.JOIN_TABLE_PROGRAMMING_LANGUAGE_KEYWORD_COLLECTION_NAME)
    private List<ProgrammingLanguage> programmingLanguages;

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

    public List<ProgrammingLanguage> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<ProgrammingLanguage> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
}
