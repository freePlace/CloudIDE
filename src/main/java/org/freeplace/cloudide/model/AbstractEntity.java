package org.freeplace.cloudide.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.lang.reflect.Field;

/**
 * Created by Ruslan on 04.12.2015.
 */
public abstract class AbstractEntity {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
            new ToStringStyle() {
                protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
                    if (value instanceof AbstractEntity) buffer.append(((AbstractEntity) value).getId());
                    else buffer.append(value);
                }
            }
        );
    }

    @Override
    public boolean equals(Object o) { return EqualsBuilder.reflectionEquals(this, o); }

    @Override
    public int hashCode() { return HashCodeBuilder.reflectionHashCode(this); }

    public abstract int getId();
}
