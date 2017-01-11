package com.xwolf.eop.common.validate.il;

import com.xwolf.eop.common.validate.Number;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>
 * </p>
 *
 * @author xwolf
 * @date 2017-01-11 17:18
 * @since V1.0.0
 */
public class IsNumber implements ConstraintValidator<Number, String> {

    @Override
    public void initialize(Number number) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
