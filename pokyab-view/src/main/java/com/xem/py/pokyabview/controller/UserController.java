package com.xem.py.pokyabview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */

@Controller
public class UserController{
    
    Logger logger = LoggerFactory.getLogger(PersonController.class);
    
//    @Autowired
//    private PersonDAO personDAO;  
    
    @RequestMapping(value = {"/users"})
    public ModelAndView showAllUsers(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showAllUsers method");
        ModelAndView mv = new ModelAndView("user/users");
        mv.addObject("title", "Users");
//        mv.addObject("userClickUsers", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
}
