
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.TrainingActivity;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author miguel
 */
public class TrainActivValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TrainingActivity trainingActivity = (TrainingActivity) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activityNumber", "common.form.int.notEmpty");       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "positionCode", "common.form.select.notEmpty"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startTime", "common.form.time.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endTime", "common.form.time.notEmpty");        
        
        if (trainingActivity.getActivityNumber() <= 0) 
            errors.rejectValue("activityNumber", "common.form.int.greater0");
        
        if (trainingActivity.getActivityId() <= 0) 
            errors.rejectValue("activityId", "common.form.select.notEmpty");
        
    }
}
