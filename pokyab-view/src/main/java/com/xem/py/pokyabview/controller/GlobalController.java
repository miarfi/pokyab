
package com.xem.py.pokyabview.controller;


import com.xem.py.pokyabmodel.dao.UserDAO;
import com.xem.py.pokyabmodel.dto.User;
import com.xem.py.pokyabview.model.UserModel;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author arria
 */
@ControllerAdvice
public class GlobalController {
	
    Logger logger = LoggerFactory.getLogger(GlobalController.class);
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private HttpSession session;

    private UserModel userModel = null;
    private User user = null;

    @ModelAttribute("userModel")
    public UserModel getUserModel() {
        logger.info("En getUserModel");
        if (session.getAttribute("userModel") == null) {
            // get the authentication object
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            logger.info("principal: "+authentication.getPrincipal());
            
            if (!authentication.getPrincipal().equals("anonymousUser")) {
                // get the user from the database
                user = userDAO.getByEmail(authentication.getName());

                if (user != null) {
                    // create a new model
                    userModel = new UserModel();
                    // set the name and the id
                    userModel.setId(user.getId());
                    userModel.setFullName(user.getFirstName() + " " + user.getLastName());
                    userModel.setRole(user.getRole());

                    //if(user.getRole().equals("USER")) {
                    //	userModel.setCart(user.getCart());					
                    //}				
                    session.setAttribute("userModel", userModel);
                    return userModel;
                }
            }
        }

        return (UserModel) session.getAttribute("userModel");
    }
		
}