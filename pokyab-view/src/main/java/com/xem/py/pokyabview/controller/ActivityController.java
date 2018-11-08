
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/activity")
public class ActivityController {
    Logger logger = LoggerFactory.getLogger(PageController.class);
    
    @Autowired
    private ActivityDAO activityDAO;          
    
    @RequestMapping(value = {"/activities"})
    public ModelAndView showAllActivities() {
        logger.info("info.Inside showAllActivities method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Activities");
        mv.addObject("userClickActivities", true);

        return mv;
    }    

    
    @RequestMapping(value = {"/manage/activity"})
    public ModelAndView showManageActivity() {
        logger.info("info.Inside showManageActivity method");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Activity");
        mv.addObject("userClickActivity", true);        
        
        //Init new Activity
        Activity activity = new Activity();
        mv.addObject("activity", activity);                
        return mv;
    }    
    
    @RequestMapping(value = {"/manage/{id}/activity"})
    public ModelAndView showManageActivityEdit(@PathVariable int id) {
        logger.info("En showManageActivityEdit");
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Activity");
        mv.addObject("userClickActivity", true);//userClickManageActivity
        
        //Get Activity object
        Activity activity = activityDAO.getActivityById(id);
        mv.addObject("activity", activity);        
        return mv;
    }    
    
    @RequestMapping(value="/manage/activity", method=RequestMethod.POST)
    public String handleActivitySubm(@ModelAttribute Activity activity) {
        logger.info("info.Inside handleActivitySubm method");
        String alertMessage = "";
        boolean daoResult = false;
        logger.info("activity: "+activity.toString());
        if (activity.getActivityId() == 0 ) {
            
            logger.info("activityDAO.add: ");
            activityDAO.add(activity);
            daoResult = true;
            if (daoResult) alertMessage = "Actividad agregada";
        } else {
            daoResult = activityDAO.update(activity);
            if (daoResult) alertMessage = "Actividad actualizada";
        }
        logger.info("alertMessage: "+alertMessage);
        return "redirect:/activities?alertMessage="+alertMessage;
    }
}
