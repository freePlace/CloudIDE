package org.freeplace.cloudide.controller.webservice;

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
public class ProgrammingLanguageWebService {

    public static final String SERVICE_PATH = "/programingLanguage";

    @Autowired
    private ProgrammingLanguageService programmingLanguageService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getLanguages() {
        List<ProgrammingLanguage> languages = programmingLanguageService.findAll();
        return new ResponseEntity<List<ProgrammingLanguage>>(languages, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity addLanguage(@RequestBody String coordinate) {
         //
        return new ResponseEntity<Long>(1l, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteCoordinate(@PathVariable("id") Long id) {
       // coordinateRepository.delete(id);
    }
}