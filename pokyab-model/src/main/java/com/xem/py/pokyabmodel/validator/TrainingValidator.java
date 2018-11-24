
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
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingName", "training.form.trainingName.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "training.form.description.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");
        
        if (training.getWeeks() <= 0) {//training.getWeeks() == null || 
            errors.rejectValue("weeks", "training.form.weeks.notEmpty");
        }
    }
    
}
