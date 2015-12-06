package org.freeplace.cloudide.service;

import org.freeplace.cloudide.dao.ProgrammingLanguageDAOImpl;
import org.freeplace.cloudide.model.ProgrammingLanguage;
import org.freeplace.cloudide.model.ProgrammingLanguageKeyword;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@Service
@Transactional
public class ProgrammingLanguageService {

    @Autowired
    private ProgrammingLanguageDAOImpl programmingLanguageDAO;

    public List<ProgrammingLanguage> findAll() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageDAO.findAll();
        programmingLanguages.forEach(programmingLanguage -> Hibernate.initialize(programmingLanguage.getProgrammingLanguageKeywords()));
        return programmingLanguages;
    }

    public List<ProgrammingLanguageKeyword> findProgramingLanguageKeywordsByProgrammingLanguage(int languageId) {
        ProgrammingLanguage programmingLanguage = programmingLanguageDAO.findById(languageId);
        Hibernate.initialize(programmingLanguage.getProgrammingLanguageKeywords());
        return programmingLanguage.getProgrammingLanguageKeywords();
    }
}
