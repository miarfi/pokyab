
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.Location;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class LocationValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Location location = (Location) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerTableName", "common.form.string.notEmpty");
//ToDo
//Source to convert from must be an instance of [@javax.persistence.Basic @javax.persistence.Column int]; 
//instead it was a [java.lang.Long]
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerTableId", "common.form.int.notEmpty");                
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationType", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address1", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "common.form.string.notEmpty"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "common.form.string.notEmpty"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "province", "common.form.string.notEmpty"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "common.form.string.notEmpty"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalCode", "common.form.int.notEmpty"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");
                
        if (location.getEndDate() != null)
            if (location.getEndDate().getTime() < location.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");

    }
}
