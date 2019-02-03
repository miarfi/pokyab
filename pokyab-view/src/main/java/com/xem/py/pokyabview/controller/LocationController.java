
package com.xem.py.pokyabview.controller;

import com.xem.py.pokyabmodel.dao.LookupValueDAO;
import com.xem.py.pokyabmodel.dao.LocationDAO;
import com.xem.py.pokyabmodel.dto.LookupValue;
import com.xem.py.pokyabmodel.dto.Location;
import com.xem.py.pokyabmodel.validator.LocationValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LocationController {
        Logger logger = LoggerFactory.getLogger(LocationController.class);
    
    @Autowired
    private LocationDAO locationDAO;  
    @Autowired
    private LookupValueDAO lookupValueDAO; 
    
    //Form Lists
    @ModelAttribute("locationTypes")
    public List<LookupValue> getLocationTypes() {
        return lookupValueDAO.getLkpValuesByType("LOCATION_TYPE", "");
    }   
    
    @RequestMapping(value = {"/locations"})
    public ModelAndView showAllLocations(@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("info.Inside showAllLocations method");
        ModelAndView mv = new ModelAndView("location/locationMain");
        mv.addObject("title", "Locations");
        mv.addObject("userClickLocations", true);
        mv.addObject("alertMessage", alertMessage);
        return mv;
    }
    
    @RequestMapping(value={"/manage/location"})
    public ModelAndView showManageLocation() {
        ModelAndView mv = new ModelAndView("location/locationMain");
        mv.addObject("title", "Location");
        mv.addObject("userClickLocation", true);        
        
        //Init new Location
        Location location = new Location();
        mv.addObject("location", location);                
        return mv;
    }
    
    @RequestMapping(value = {"/manage/location/{id}"})
    public ModelAndView showManageLocationEdit(@PathVariable int id
        ,@RequestParam(name = "alertMessage", required = false) String alertMessage) {
        logger.info("En showManageLocationEdit");
        ModelAndView mv = new ModelAndView("location/locationMain");
        mv.addObject("title", "Location");
        mv.addObject("userClickLocation", true);
        mv.addObject("alertMessage", alertMessage);
        
        //Get Location object
        Location location = locationDAO.getLocationById(id);
        mv.addObject("location", location);        
        return mv;
    }    
    
    @RequestMapping(value="/manage/location", method=RequestMethod.POST)
    public String handleLocationSubmission(@ModelAttribute Location location
            ,HttpServletRequest request,BindingResult result, Model model) {
        logger.info("info.Inside handleLocationSubmission method");
        String alertMessage = "";
        boolean daoResult = false;
        String returnUrl = "";
        logger.info("location:"+location.toString());
        
        //Spring Validator        
        new LocationValidator().validate(location, result);        
        logger.info("Errores"+result.getErrorCount());
        
        if (result.hasErrors()) {
            model.addAttribute("title", "Direccion");
            model.addAttribute("userClickLocation", true);             
            return "location/locationMain";
        }
        
        if (location.getLocationId() == 0) {
            daoResult = locationDAO.add(location);
            if (daoResult) alertMessage = "Direccion agregada";            
        } else {
            daoResult = locationDAO.update(location);
            if (daoResult) alertMessage = "Direccion modificada"; 
        }
        
               
        if (daoResult) returnUrl = "redirect:/manage/location/"+location.getLocationId()+"?alertMessage="+alertMessage;
        else returnUrl = "redirect:/locations?alertMessage="+alertMessage;
        
        logger.info("daoResult: "+daoResult+" alertMessage: "+alertMessage);
        return returnUrl;
    }
    
    @RequestMapping(value="/manage/location/{id}/delete", method=RequestMethod.GET)
    public String handleLocationDelete(@PathVariable int id) {
        logger.info("info.Inside handleLocationDelete method");
        String alertMessage = "";
        boolean daoResult = false;
        Location location = locationDAO.getLocationById(id);
        if (location != null) {
            logger.info("location: "+location.toString());
            daoResult = locationDAO.delete(location);
            if (daoResult) alertMessage = "Direccion borrada";                   
        } else 
            alertMessage = "Direccion no encontrada"; 
        
        logger.info("daoResult: "+daoResult);
        return "redirect:/locations?alertMessage=" + alertMessage;
    }
   
    @RequestMapping(value="/manage/location/{id}/activation", method=RequestMethod.GET)
    @ResponseBody
    public String handleLocationActivation(@PathVariable int id) {
        logger.info("info.Inside handleLocationActivation method");
        String alertMessage = "";
        boolean daoResult = false;
        Location location = locationDAO.getLocationById(id);
        logger.info("location:"+location.toString()); 

        if (location != null) {
            if (location.getActive() == 'Y') location.setActive('N');
            else location.setActive('Y');
            daoResult = locationDAO.update(location);
            if (daoResult) alertMessage = "Direccion actualizada satisfactoriamente";
        } else 
            alertMessage = "Direccion no encontrada"; 
        
        return alertMessage;
    }

}