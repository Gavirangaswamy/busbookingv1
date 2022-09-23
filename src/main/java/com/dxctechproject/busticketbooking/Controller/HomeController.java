package com.dxctechproject.busticketbooking.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusController.class);

    ModelAndView modelAndView = new ModelAndView();

    @GetMapping("/home")
    public ModelAndView homepage1() {
        LOGGER.info("homepage method invoked");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/adminLogin")
    public ModelAndView adminLogin() {
        LOGGER.info("admin login method invoked");
        modelAndView.setViewName("admin/adminLogin");
        return modelAndView;
    }

    @GetMapping("/userLogin")
    public ModelAndView userLogin() {
        LOGGER.info("admin login method invoked");
        modelAndView.setViewName("user/userLogin");
        return modelAndView;
    }
}
