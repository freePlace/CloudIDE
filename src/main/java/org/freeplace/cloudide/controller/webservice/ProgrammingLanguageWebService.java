package org.freeplace.cloudide.controller.webservice;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.dao.ProgrammingLanguageDAOImpl;
import org.freeplace.cloudide.model.ProgrammingLanguage;
import org.freeplace.cloudide.service.ProgrammingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
@RestController
@RequestMapping(ProgrammingLanguageWebService.SERVICE_PATH)
public class ProgrammingLanguageWebService extends AbstractWebService{

    public static final String SERVICE_PATH = BASE_PATH + Path.SLASH + "programmingLanguage";

    @Autowired
    private ProgrammingLanguageService programmingLanguageService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getProgrammingLanguages() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageService.findAll();
        return new ResponseEntity<List<ProgrammingLanguage>>(programmingLanguages, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addLanguage(@RequestBody String language) {
         //
        return new ResponseEntity<Long>(1l, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteLanguage(@PathVariable("id") Long id) {

    }
}