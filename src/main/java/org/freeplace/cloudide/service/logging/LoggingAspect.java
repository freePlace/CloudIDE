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

/**
 * Created by Ruslan on 17.01.2016.
 */
@Component
@Aspect
public class LoggingAspect {

    private LoggingEventDAO loggingEventDAO;

    private LoggingTypeDAO loggingTypeDAO;

    @Autowired
    public LoggingAspect(LoggingEventDAO loggingEventDAO, LoggingTypeDAO loggingTypeDAO) {
        this.loggingEventDAO = loggingEventDAO;
        this.loggingTypeDAO = loggingTypeDAO;
    }

    @Around("@annotation("+ ApplicationData.PACKAGE_LOGGING +".Loggable)")
    public Object applicationAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){

        LoggingEvent loggingEvent = new LoggingEvent();
        loggingEvent.setContext(proceedingJoinPoint.getSourceLocation() + ", " + proceedingJoinPoint.getArgs());

        try {
            Object result = proceedingJoinPoint.proceed();
            loggingEvent.setResult(result == null ? "void" : result.toString());
            loggingEvent.setLoggingType(loggingTypeDAO.findOneByColumnValue("name", "DEBUG"));
            loggingEventDAO.create(loggingEvent);
            return result;
        } catch (Throwable e) {
            loggingEvent.setResult(e.toString());
            loggingEvent.setLoggingType(loggingTypeDAO.findOneByColumnValue("name", "ERROR"));
            loggingEventDAO.create(loggingEvent);
            throw new RuntimeException(e.getMessage());
        }
    }
}

