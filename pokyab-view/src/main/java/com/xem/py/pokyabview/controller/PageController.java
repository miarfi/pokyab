package com.xem.py.pokyabview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author arria
 */
@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home"})
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", "Welcome to Pokyab");
        return mv;
    }

    @RequestMapping(value = {"/about"})
    public ModelAndView about() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = {"/contact"})
    public ModelAndView contact() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact");
        mv.addObject("userClickContact", true);
        return mv;
    }

    @RequestMapping(value = {"/players"})
    public ModelAndView showAllPersons() {

        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Players");
        mv.addObject("userClickPlayers", true);
        //mv.addObject("categories", categoryDAO.list());
        return mv;
    }

}
