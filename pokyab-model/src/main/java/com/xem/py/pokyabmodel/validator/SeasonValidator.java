
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.Season;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class SeasonValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Season season = (Season) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seasonName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seasonCode", "common.form.select.notEmpty");          
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.date.notEmpty");                           
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "common.form.date.notEmpty");  
    }
}
