package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.Activity;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author miguel
 */
public class ActivityValidator implements Validator{
   @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Activity activity = (Activity) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activityName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activityType", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "metricType", "common.form.string.notEmpty");        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instructions", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalTime", "common.form.int.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uomCode", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantityMin", "common.form.int.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantityMax", "common.form.int.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.date.notEmpty");        
        
        if (activity.getTotalTime() <= 0)           
            errors.rejectValue("totalTime", "common.form.int.greater0");            
        if (activity.getQuantityMin() <= 0)           
            errors.rejectValue("quantityMin", "common.form.int.greater0");          
        if (activity.getQuantityMax() <= 0)           
            errors.rejectValue("quantityMax", "common.form.int.greater0"); 
        if (activity.getQuantityMax() < activity.getQuantityMin())           
            errors.rejectValue("quantityMax", "activity.table.qtyMax.greater.qtyMin");        
        if (activity.getEndDate() != null) {
            if (activity.getEndDate().getTime() < activity.getStartDate().getTime()) {
                errors.rejectValue("endDate", "common.form.endDate.greater");
            }
        }
    }
}   
