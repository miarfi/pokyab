
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.League;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class LeagueValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        League league = (League) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leagueName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leagueType", "common.form.select.notEmpty");          
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryCode", "common.form.select.notEmpty");                           
        
        if (league.getEndDate() != null)
            if (league.getEndDate().getTime() < league.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");
    }
}
