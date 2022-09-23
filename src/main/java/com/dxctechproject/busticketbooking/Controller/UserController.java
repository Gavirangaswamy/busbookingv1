package com.dxctechproject.busticketbooking.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Entity.User;
import com.dxctechproject.busticketbooking.Exceptions.ResourceNotFoundException;
import com.dxctechproject.busticketbooking.Service.UserService;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    ModelAndView modelAndView = new ModelAndView();
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/displayUsers")
    public ModelAndView displayUsers() {
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users).setViewName("admin/displayUsersPage");
        return modelAndView;
    }

    @GetMapping("/showUserReg")
    public ModelAndView userRegistrationPage() {
        LOGGER.info("InsideShowRegistrationPage");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("user/userReg");
        return modelAndView;
    }

    @PostMapping("/userReg")
    public ModelAndView registerUser(User user) {
        LOGGER.info("InsideRegister()" + user);
        try {
        	modelAndView.addObject("user", userService.save(user));
        	modelAndView.addObject("message", "Successfully registered, Please login");
        	modelAndView.setViewName("user/userLogin");
        }catch(Exception e) {
        	modelAndView.addObject("message", "User already exist, please try Login");
        	modelAndView.setViewName("user/userReg");
        }
        return modelAndView;
    }

    @GetMapping("/userLoginPage")
    public ModelAndView userLoginPage() {
        LOGGER.info("Inside showLoginPage()");
        modelAndView.addObject("message", "");
        modelAndView.setViewName("user/userLogin");
        return modelAndView;
    }


    @PostMapping("/loginUser")
    public ModelAndView loginUser(@RequestParam("email") String email,
                                  @RequestParam("password") String password, ModelMap modelMap,HttpSession session) {
        LOGGER.info("Inside loginAdmin()");
        User user = null;
        try {
            user = userService.findByEmailAndPassword(email, password);
        } catch (ResourceNotFoundException re) {
            re.printStackTrace();
        }
        if (user != null && user.getPassword().equals(password)) {
            modelAndView.setViewName("user/searchBuses");
            modelAndView.addObject("message", "");
            session.setAttribute("user", email);
        } else {
            modelAndView.addObject("message", "Invalid Username or Password");
            modelAndView.setViewName("user/userLogin");
        }
        return modelAndView;
    }
    
    @GetMapping("/searchbuspage")
	public ModelAndView searchbuspage(HttpSession session) {
		LOGGER.info("searchbuspage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", session.getAttribute("user"));
		modelAndView.setViewName("user/searchBuses");
		return modelAndView;
	}
}

