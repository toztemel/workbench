package main.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by tayfuno on 14/01/16.
 * Available on target only:
 * TYPE,
 * FIELD,
 * METHOD,
 * PARAMETER,
 * CONSTRUCTOR,
 * LOCAL_VARIABLE,
 * ANNOTATION_TYPE,
 * PACKAGE,
 * TYPE_PARAMETER,
 * TYPE_USE
 */
@Target({ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface Copyright2 {
    String info() default "";
}
