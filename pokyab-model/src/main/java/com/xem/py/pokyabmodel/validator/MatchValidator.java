
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.Match;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class MatchValidator  implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Match match = (Match) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeTeamId", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "awayTeamId", "common.form.select.notEmpty");          //        Valid
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "seasonId", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leagueId", "common.form.select.notEmpty");        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matchDate", "common.form.date.notEmpty");   
        
        if (match.getSeasonId() <= 0)
            errors.rejectValue("seasonId", "common.form.select.notEmpty");
        if (match.getLeagueId() <= 0)
            errors.rejectValue("leagueId", "common.form.select.notEmpty");                         
    }
}

