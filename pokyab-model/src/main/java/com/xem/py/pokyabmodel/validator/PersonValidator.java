package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dto.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author miguel
 */
public class PersonValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "common.form.string.notEmpty");        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "common.form.date.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genderCode", "common.form.string.notEmpty"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personType", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");
        
//        if (person.getFile() == null || person.getFile().getOriginalFilename().equals("")) {
//            errors.rejectValue("file", null, "common.form.file.notEmpty");
//            return;
//        }
        if (person.getFile() != null && !person.getFile().getOriginalFilename().equals("") ) {
            if (!(person.getFile().getContentType().equals("image/jpeg")
                    || person.getFile().getContentType().equals("image/png")
                    || person.getFile().getContentType().equals("image/gif"))) {

                errors.rejectValue("file", "common.form.file.notImage");
                return;
            }
        }
        
        if (person.getEndDate() != null)
            if (person.getEndDate().getTime() < person.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");

    }
}
