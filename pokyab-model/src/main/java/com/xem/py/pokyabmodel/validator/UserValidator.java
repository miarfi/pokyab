
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dao.UserDAO;
import com.xem.py.pokyabmodel.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author arria
 */
public class UserValidator implements Validator{
    @Autowired
    UserDAO userDAO; 

    @Override
    public boolean supports(Class<?> clazz) {
        return Validator.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "common.form.string.notEmpty");        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "common.form.date.notEmpty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "common.form.string.notEmpty");        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "common.form.string.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "common.form.startDate.notEmpty");
        
        if (user.getPassword() != null && user.getConfirmPassword() != null) 
            if (!user.getPassword().equals(user.getConfirmPassword())) 
                errors.rejectValue("confirmPassword", "user.table.confirmPassword.match");
//ToDo revisar errores al usar DAOs!!.                
//        if (user.getEmail() != null) 
//            if (userDAO.getByEmail(user.getEmail()) != null)
//                errors.rejectValue("email", "user.table.email.unique");                 
        
        if (user.getEndDate() != null)
            if (user.getEndDate().getTime() < user.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");
    }
}
