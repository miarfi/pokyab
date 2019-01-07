
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.TeamPerson;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author miguel
 */
public class TeamPersonValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TeamPerson teamPerson = (TeamPerson) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "common.form.int.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "common.form.int.notEmpty");    
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerNumber", "common.form.int.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberType", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "positionCode", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phisicCode", "common.form.select.notEmpty");        
        
        if (teamPerson.getHeight() <= 0)
            errors.rejectValue("height", "common.form.int.greater0");   
        if (teamPerson.getWeight() <= 0)
            errors.rejectValue("weight", "common.form.int.greater0");    
        if (teamPerson.getPlayerNumber() <= 0)
            errors.rejectValue("playerNumber", "common.form.int.greater0");    
        
    }
}
