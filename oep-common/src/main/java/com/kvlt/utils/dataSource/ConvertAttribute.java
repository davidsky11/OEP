package com.kvlt.utils.dataSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ConvertAttribute
 *
 * @author KVLT
 * @date 2017-03-14.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConvertAttribute {

    String name();

    String type() default "field";

    String target() default "";
}
