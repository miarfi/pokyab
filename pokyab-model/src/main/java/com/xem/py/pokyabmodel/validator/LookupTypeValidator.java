
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.LookupType;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
//@Component //Requerido con Binder y @Validated
public class LookupTypeValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return LookupType.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        LookupType lookupType = (LookupType) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lookupType", "lookupType.form.lookupType.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "lookupType.form.description.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");        
    }    
}
