package org.freeplace.cloudide.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Ruslan on 04.12.2015.
 */
public abstract class AbstractModel {

    public static final String PREFIX_FOR_INITIALIZABLE_TYPES = "get";
    //private static final String DEFAULT_TABLE_ID = "id";
    private static final String FIELD_ID = "id";



    // todo: fix circle links for this solution
    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this, new CustomToStringStyle()); }
    @Override
    public boolean equals(Object o) { return EqualsBuilder.reflectionEquals(this, o); }
    @Override
    public int hashCode() { return HashCodeBuilder.reflectionHashCode(this); }

    public int getId() {
        try {
            Field idField = this.getClass().getDeclaredField(FIELD_ID);
            idField.setAccessible(true);
            return (int) idField.get(this);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            throw new IllegalAccessError();
        }
    }

    public void setId(int id) {
        try {
            Field idField = this.getClass().getDeclaredField(FIELD_ID);
            idField.setAccessible(true);
            idField.set(this, id);
        } catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new IllegalAccessError(e + "");
        }
    }
}
