package org.freeplace.cloudide.controller.webservice.executor;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.controller.webservice.AbstractWebService;
import org.freeplace.cloudide.controller.webservice.model.ValidationModule;
import org.freeplace.cloudide.service.executor.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ruslan on 06.12.2015.
 */
@RestController
@RequestMapping(ValidatorWebService.SERVICE_PATH)
public class ValidatorWebService extends AbstractWebService {
    public static final String SERVICE_PATH = BASE_PATH + Path.SLASH + "validate";

    @Autowired
    private ValidatorService validatorService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity execute(@RequestBody ValidationModule validationModule) {
        validatorService.validate(validationModule);
            return new ResponseEntity<ValidationModule>(validationModule, HttpStatus.OK);
    }
}
