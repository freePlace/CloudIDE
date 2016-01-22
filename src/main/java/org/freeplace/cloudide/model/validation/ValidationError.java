package org.freeplace.cloudide.model.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslan on 22.01.2016.
 */
public class ValidationError {

    private List<FieldError> fieldErrors = new ArrayList<>();

    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, message);
        fieldErrors.add(error);
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
