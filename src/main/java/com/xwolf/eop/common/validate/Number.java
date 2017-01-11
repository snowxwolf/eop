package com.xwolf.eop.common.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-11 17:11
 * @since V1.0.0
 */
@Documented
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Number {

    String message() default "{validate.number}";

    int min() default 0;
    int length() default 1;

    //下面这两个属性必须添加
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
