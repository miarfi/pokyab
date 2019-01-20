
package com.xem.py.pokyabview.handler;

import com.xem.py.pokyabmodel.dao.UserDAO;
import com.xem.py.pokyabmodel.dto.User;
import com.xem.py.pokyabview.model.RegisterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author arria
 */
@Component
public class RegisterHandler {
    Logger logger = LoggerFactory.getLogger(RegisterHandler.class);
    
    @Autowired
    UserDAO userDAO;    
     
    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }
    
    public String saveAll(RegisterModel model) {
        String transitionValue = "success";
        User user = model.getUser();                
        boolean daoResult;
        logger.info("En saveAll");
        logger.info("user "+user);
        daoResult = userDAO.add(user);
        
        logger.info("daoResult : "+daoResult);
        if (!daoResult) {
            transitionValue = "confirm";
        }        

        return transitionValue;
    }

    public String validateUser(User user, MessageContext error) {
        
        
        String transitionValue = "confirm";
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            error.addMessage(new MessageBuilder().error().source("confirmPassword")
                    .defaultText("Password does not match confirm password!").build());
            transitionValue = "failure";
        }
        if (userDAO.getByEmail(user.getEmail()) != null) {
            error.addMessage(new MessageBuilder().error().source("email")
                    .defaultText("Email address is already taken!").build());
            transitionValue = "failure";
        }


        return transitionValue;
    }
}
