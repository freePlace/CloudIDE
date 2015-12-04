package org.freeplace.cloudide.service;

import org.freeplace.cloudide.dao.ProgrammingLanguageDAOImpl;
import org.freeplace.cloudide.model.ProgrammingLanguage;
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
        return programmingLanguageDAO.findAll();
    }
}
