package com.dxctechproject.busticketbooking.Controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Entity.Admin;
import com.dxctechproject.busticketbooking.Exceptions.ResourceNotFoundException;
import com.dxctechproject.busticketbooking.Service.AdminService;

@Controller
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    ModelAndView modelAndView = new ModelAndView();
    @Autowired
    private AdminService adminService;
    
    @GetMapping("/showAdminReg")
    public ModelAndView registrationPage() {
        LOGGER.info("InsideShowRegistrationPage");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("admin/adminReg");
        return modelAndView;
    }

    @PostMapping("/adminReg")
    public ModelAndView register(Admin admin) {
        LOGGER.info("InsideRegister()" + admin);
        try {
        	modelAndView.addObject("user", adminService.save(admin));
        	modelAndView.addObject("message", "Successfully registered, Please login");
        	modelAndView.setViewName("admin/adminLogin");
        }catch(Exception e) {
        	modelAndView.addObject("message", "Admin already exist, please try Login");
        	modelAndView.setViewName("admin/adminReg");
        }
        return modelAndView;
    }

    @GetMapping("/showLoginPage")
    public ModelAndView showLoginPage() {
        LOGGER.info("Inside showLoginPage()");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("admin/adminLogin");
        return modelAndView;
    }

    @PostMapping("/loginAdmin")
    public ModelAndView loginAdmin(@RequestParam("email") String email,
                                   @RequestParam("password") String password,HttpSession session) {
        LOGGER.info("Inside loginAdmin()");
        Admin admin = null;
        try {
            admin = adminService.findByEmailAndPassword(email, password);
        } catch (ResourceNotFoundException re) {
            re.printStackTrace();
        }
        if (admin != null && admin.getPassword().equals(password)) {
        	modelAndView.addObject("message", "");
            modelAndView.setViewName("admin/Admin_dashboard");
            session.setAttribute("user", email);
        } else {
            modelAndView.addObject("message", "Invalid Username or Password");
            modelAndView.setViewName("admin/adminLogin");
        }
        return modelAndView;
    }
}
