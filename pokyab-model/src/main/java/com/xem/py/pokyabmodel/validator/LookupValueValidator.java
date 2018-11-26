package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.LookupValue;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class LookupValueValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return LookupValue.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        LookupValue lookupValue = (LookupValue) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lookupCode", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "meaning", "common.form.string.notEmpty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");   
    }   
}