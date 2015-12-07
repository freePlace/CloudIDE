package org.freeplace.cloudide.service.programminglanguage;

import org.freeplace.cloudide.dao.programminglanguage.ProgrammingLanguageDAOImpl;
import org.freeplace.cloudide.model.programminglanguage.ProgrammingLanguage;
import org.freeplace.cloudide.model.programminglanguage.ProgrammingLanguageKeyword;
import org.freeplace.cloudide.service.AbstractService;
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
public class ProgrammingLanguageService extends AbstractService<ProgrammingLanguage, Integer>{

    @Autowired
    private ProgrammingLanguageDAOImpl dao;

    public List<ProgrammingLanguage> findAll() {
        List<ProgrammingLanguage> programmingLanguages = dao.findAll();
        programmingLanguages.forEach(programmingLanguage -> Hibernate.initialize(programmingLanguage.getProgrammingLanguageKeywords()));
        return programmingLanguages;
    }
}
