package org.freeplace.cloudide.service;

import org.freeplace.cloudide.controller.webservice.model.ValidationModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Ruslan on 06.12.2015.
 */
@Service
@Transactional
public class ValidatorService {

    public void validate(ValidationModule validationModule) {
        // should be implemented. code complete etc
    }

}
