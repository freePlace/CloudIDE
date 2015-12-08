package org.freeplace.cloudide.model;

/**
 * Created by c3po on 12/8/2015.
 */
import org.apache.commons.lang3.builder.ToStringStyle;

public class CustomToStringStyle extends ToStringStyle {
    private static final long serialVersionUID = 1L;

    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        if (value instanceof AbstractModel) {
            buffer.append(((AbstractModel) value).getId());
        } else {
            buffer.append(value);
        }
    }
}
