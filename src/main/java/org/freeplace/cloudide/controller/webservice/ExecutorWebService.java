package org.freeplace.cloudide.controller.webservice;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.controller.webservice.model.ExecutionModule;
import org.freeplace.cloudide.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ruslan on 04.12.2015.
 */
@RestController
@RequestMapping(ExecutorWebService.SERVICE_PATH)
public class ExecutorWebService extends  AbstractWebService{
    public static final String SERVICE_PATH = BASE_PATH + Path.SLASH + "execute";

    @Autowired
    private ExecutorService executorService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity execute(@RequestBody ExecutionModule executionModule) {
        executorService.execute(executionModule);
        return new ResponseEntity<ExecutionModule>(executionModule, HttpStatus.OK);
    }
}
