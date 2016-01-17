package org.freeplace.cloudide.service.logging;

/**
 * Created by Ruslan on 17.01.2016.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.dao.logging.LoggingEventDAO;
import org.freeplace.cloudide.dao.logging.LoggingTypeDAO;
import org.freeplace.cloudide.model.logging.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Ruslan on 17.01.2016.
 */
@Component
@Aspect
public class LoggingAspect {

    @Autowired
    private LoggingEventDAO loggingEventDAO;

    @Autowired
    private LoggingTypeDAO loggingTypeDAO;

    @Around("@annotation("+ ApplicationData.PACKAGE_LOGGING +".Loggable)")
    public Object applicationAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){

        LoggingEvent loggingEvent = new LoggingEvent();
        loggingEvent.setContext(proceedingJoinPoint.toString());

        try {
            Object result = proceedingJoinPoint.proceed();
            loggingEvent.setResult(result == null ? "Empty value" : result.toString());
            loggingEventDAO.create(loggingEvent);
            loggingEvent.setLoggingType(loggingTypeDAO.findOneByColumnValue("DEBUG", "name"));
            return result;
        } catch (Throwable e) {
            loggingEvent.setResult(e.toString());
            loggingEventDAO.create(loggingEvent);
            loggingEvent.setLoggingType(loggingTypeDAO.findOneByColumnValue("ERROR", "name"));
            throw new RuntimeException(e.getMessage());
        }
    }
}

