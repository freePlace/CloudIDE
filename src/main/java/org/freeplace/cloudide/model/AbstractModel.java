package org.freeplace.cloudide.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Ruslan on 04.12.2015.
 */
public abstract class AbstractModel {
    @Override
    public String toString() { return ReflectionToStringBuilder.toString(this); }
    @Override
    public boolean equals(Object o) { return EqualsBuilder.reflectionEquals(this, o); }
    @Override
    public int hashCode() { return HashCodeBuilder.reflectionHashCode(this); }
}
