package org.freeplace.cloudide.dao.logging;

import org.freeplace.cloudide.dao.AbstractDAO;
import org.freeplace.cloudide.model.logging.LoggingEvent;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Ruslan on 17.01.2016.
 */
@Repository
public class LoggingEventDAO extends AbstractDAO<LoggingEvent, Integer> {
}
