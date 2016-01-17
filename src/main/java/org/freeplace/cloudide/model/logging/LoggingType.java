package org.freeplace.cloudide.model.logging;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ruslan on 17.01.2016.
 */
@Entity
public class LoggingType extends AbstractEntity{
    public static final String TABLE_ID = "id_logging_type";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    private String name;

    @OneToMany(mappedBy = "loggingType")
    private List<LoggingEvent> loggingEvents;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LoggingEvent> getLoggingEvents() {
        return loggingEvents;
    }

    public void setLoggingEvents(List<LoggingEvent> loggingEvents) {
        this.loggingEvents = loggingEvents;
    }
}
