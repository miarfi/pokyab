
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.LookupUse;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author miguel
 */
public class LookupUseValidator implements Validator{
     @Override
    public boolean supports(Class<?> clazz) {
        return LookupUse.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LookupUse lookupUse = (LookupUse) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tableName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "columnName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");   
        
        if (lookupUse.getEndDate() != null)
            if (lookupUse.getEndDate().getTime() < lookupUse.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");
    }   
}
