
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.ActivityDAO;
import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dto.Activity;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.validator.ActivityValidator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
//@RequestMapping("/activity")
@PropertySource("classpath:/messages.properties")
public class ActivityController {
    Logger logger = LoggerFactory.getLogger(ActivityController.class);
    
    @Autowired
    private ActivityDAO activityDAO;       
    @Autowired
    private Environment environment;
    @Autowired
    private LookupValueDAO lookupValueDAO;  
    

    @ModelAttribute("activityTypes")
    public List<LookupValue> getActivityTypes() {
        return lookupValueDAO.getLkpValuesByType("ACTIVITY_TYPE", "");
    }
    
    @ModelAttribute("metricTypes")
    public List<LookupValue> getMetricTypes() {
        return lookupValueDAO.getLkpValuesByType("METRIC_TYPE", "");
    }
    
    @ModelAttribute("uomCodes")
    public List<LookupValue> getUomCodes() {
        return lookupValueDAO.getLkpValuesByType("UOM_CODE", "");
    }
    
    @RequestMapping(value = {"/activities"})
    public ModelAndView showAllActivities(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showAllActivities method");
        ModelAndView mv = new ModelAndView("training/trainingMain");
        mv.addObject("title", "Activities");
        mv.addObject("userClickActivities", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }    

    
    @RequestMapping(value = {"/manage/activity"})
    public ModelAndView showManageActivity() {
        logger.info("info.Inside showManageActivity method");
        ModelAndView mv = new ModelAndView("training/trainingMain");
        mv.addObject("title",  environment.getProperty("activity.table.title"));
        mv.addObject("userClickActivity", true);        
        
        //Init new Activity
        Activity activity = new Activity();
        mv.addObject("activity", activity);                
        return mv;
    }    
    
    @RequestMapping(value = {"/manage/activity/{id}"})
    public ModelAndView showManageActivityEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("En showManageActivityEdit");
        ModelAndView mv = new ModelAndView("training/trainingMain");
        mv.addObject("title", "Activity");
        mv.addObject("userClickActivity", true);
        mv.addObject("alertMessage", alertMessage);
        
        //Get Activity object
        Activity activity = activityDAO.getActivityById(id);
        mv.addObject("activity", activity);        
        return mv;
    }    
    
    @RequestMapping(value="/manage/activity", method=RequestMethod.POST)
    public String handleActivitySubm(@ModelAttribute Activity activity,
            BindingResult result, Model model) {
        logger.info("info.Inside handleActivitySubm method");
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl = "";
        logger.info("activity: "+activity.toString());
        
        //Spring Validator        
        new ActivityValidator().validate(activity, result);
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Activity");
            model.addAttribute("userClickActivity", true);             
            return "training/trainingMain";
        }
        
        if (activity.getActivityId() == 0 ) {            
            logger.info("activityDAO.add: ");
            activityDAO.add(activity);
            daoResult = true;
            if (daoResult) alertMessage = "Actividad agregada";
        } else {
            daoResult = activityDAO.update(activity);
            if (daoResult) alertMessage = "Actividad actualizada";
        }
        if (daoResult) returnUrl = "redirect:/manage/activity/"+activity.getActivityId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/activities?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/activity/{id}/delete", method=RequestMethod.GET)
    public String handleActivityDelete(@PathVariable int id) {
        logger.info("info.Inside handleActivityDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        Activity activity = activityDAO.getActivityById(id);
        if (activity != null) {
            logger.info("activity: "+activity.toString());
            daoResult = activityDAO.delete(activity);
            if (daoResult) alertMessage = "Actividad borrada";                   
        } else {
            alertMessage = "Actividad no encontrada"; 
        }
        logger.info("daoResult: "+daoResult);
        return "redirect:/activities?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/activity/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleActivityActivation(@PathVariable int id) {
        logger.info("info.Inside handleActivityActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        Activity activity = activityDAO.getActivityById(id);
        logger.info("activity:"+activity.toString()); 

        if (activity != null) {
            if (activity.getActive() == 'Y') activity.setActive('N');
            else activity.setActive('Y');
            daoResult = activityDAO.update(activity);
            if (daoResult) alertMessage = "Actividad actualizada satisfactoriamente";
        } else {
            alertMessage = "Actividad no encontrada"; 
        }
        
        logger.info("alertMessage "+alertMessage);
        return alertMessage;
    }
}
