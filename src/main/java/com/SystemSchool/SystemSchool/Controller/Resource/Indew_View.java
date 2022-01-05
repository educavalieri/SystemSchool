package com.SystemSchool.SystemSchool.Controller.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Indew_View {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView loadinitialPage(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}
