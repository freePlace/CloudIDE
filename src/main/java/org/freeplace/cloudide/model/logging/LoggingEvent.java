package org.freeplace.cloudide.model.logging;

import org.freeplace.cloudide.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by Ruslan on 17.01.2016.
 */
@Entity
public class LoggingEvent extends AbstractEntity{

    public static final String TABLE_ID = "id_logger";

    @Id
    @GeneratedValue
    @Column(name = TABLE_ID)
    private int id;

    @ManyToOne
    @JoinColumn(name = LoggingType.TABLE_ID)
    private LoggingType loggingType;

    private String context;

    private String result;

    @Override
    public int getId() {
        return id;
    }

    public LoggingType getLoggingType() {
        return loggingType;
    }

    public void setLoggingType(LoggingType loggingType) {
        this.loggingType = loggingType;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
