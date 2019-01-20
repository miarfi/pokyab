
package com.xem.py.pokyabmodel.validator;

import com.xem.py.pokyabmodel.dao.PersonDAO;
import com.xem.py.pokyabmodel.dao.TeamPersonDAO;
import com.xem.py.pokyabmodel.dto.Person;
import com.xem.py.pokyabmodel.dto.TeamPerson;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private TeamPersonDAO teamPersonDAO;
    
    @Override
    public void validate(Object o, Errors errors) {
        TeamPerson teamPerson = (TeamPerson) o; 
        Person person;
        

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberType", "common.form.select.notEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "statusCode", "common.form.select.notEmpty");        
        
        if (teamPerson.getEndDate() != null)
            if (teamPerson.getEndDate().getTime() < teamPerson.getStartDate().getTime())
                errors.rejectValue("endDate", "common.form.endDate.greater");
                      
        //Person validations
//        boolean existTeamPerson = teamPersonDAO.existTeamPerson(int personId);
//        if (existTeamPerson) {
//             errors.rejectValue("personId", "La persona ya esta asignada en "); 
//        }
        
//        person = personDAO.getPersonById(teamPerson.getPersonId());
//        
//               
        //memberType=PLAYER validations
        if  (teamPerson.getMemberType().equals("PLAYER")) {
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "height", "common.form.int.notEmpty");
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "common.form.int.notEmpty");    
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerNumber", "common.form.int.notEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "positionCode", "common.form.select.notEmpty");
            
            if (teamPerson.getHeight() <= 0)
                errors.rejectValue("height", "common.form.int.greater0");   
            if (teamPerson.getWeight() <= 0)
                errors.rejectValue("weight", "common.form.int.greater0");    
            if (teamPerson.getPlayerNumber() <= 0)
                errors.rejectValue("playerNumber", "common.form.int.greater0");    
//            if ( !person.getPersonType().equalsIgnoreCase( teamPerson.getMemberType() ) ) {
//                 errors.rejectValue("memberType", "El tipo de persona no es PLAYER");    
//            }
        }
    
    }
     
//    public void valPerso(int personId){        
//        
//    }
}
