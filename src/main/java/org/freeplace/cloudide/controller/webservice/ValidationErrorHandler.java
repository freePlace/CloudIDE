package org.freeplace.cloudide.controller.webservice;

import org.freeplace.cloudide.model.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

/**
 * Created by Ruslan on 22.01.2016.
 */
@ControllerAdvice
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationError processValidationError(MethodArgumentNotValidException ex) {
        return processFieldErrors(ex.getBindingResult().getFieldErrors());
    }

    private ValidationError processFieldErrors(List<FieldError> fieldErrors) {
        ValidationError error = new ValidationError();
        fieldErrors.forEach(fieldError -> error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage()));
        return error;
    }
}