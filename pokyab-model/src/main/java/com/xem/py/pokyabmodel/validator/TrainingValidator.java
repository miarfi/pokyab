
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.Training;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class TrainingValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
         return Training.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Training training = (Training) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "common.form.string.notEmpty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryCode", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weeks", "common.form.int.notEmpty");
        
        if (training.getWeeks() <= 0) //training.getWeeks() != null || 
            errors.rejectValue("weeks", "common.form.int.greater0");
        if (training.getEndDate() != null)
            if (training.getEndDate().getTime() < training.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");
    }
    
}
