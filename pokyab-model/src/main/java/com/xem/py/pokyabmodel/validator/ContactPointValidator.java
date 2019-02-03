
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.ContactPoint;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class ContactPointValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ContactPoint contactPoint = (ContactPoint) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerTableName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerTableId", "common.form.string.notEmpty");                
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactType", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "useType", "common.form.select.notEmpty");        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactValue", "common.form.string.notEmpty");

    }
}
