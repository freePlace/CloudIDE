package org.freeplace.cloudide.dao.logging;

import org.freeplace.cloudide.dao.AbstractDAO;
import org.freeplace.cloudide.model.logging.LoggingEvent;
import org.springframework.stereotype.Repository;

@Repository
public class LoggingEventDAO extends AbstractDAO<LoggingEvent, Integer> {}