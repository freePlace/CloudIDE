package org.freeplace.cloudide.controller.webservice;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.model.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

/**
 * Created by Ruslan on 04.12.2015.
 */
public abstract class AbstractWebService {
    public static final String BASE_PATH = Path.SLASH + "service";
}
