package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author miguel
 */
public class TeamValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Team team = (Team) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "teamName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupNumber", "common.form.int.notEmpty");          
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainerPerId", "common.form.int.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leagueId", "common.form.int.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seasonId", "common.form.int.notEmpty");        
        
        if (team.getGroupNumber() <= 0)
            errors.rejectValue("groupNumber", "common.form.int.greater0"); 
        if (team.getTrainerPerId() <= 0)
            errors.rejectValue("trainerPerId", "common.form.select.notEmpty");    
        if (team.getSeasonId() <= 0)
            errors.rejectValue("seasonId", "common.form.select.notEmpty");
        if (team.getLeagueId() <= 0)
            errors.rejectValue("leagueId", "common.form.select.notEmpty");
        if (team.getEndDate() != null)
            if (team.getEndDate().getTime() < team.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");
            
        
    }
}
