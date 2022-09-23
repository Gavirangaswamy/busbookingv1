package com.dxctechproject.busticketbooking.Controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Service.ServiceImpl.ForgotPasswordService;
import com.dxctechproject.busticketbooking.Util.ForgotPasswordDTO;

@Controller
public class ForgotPasswordController {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	ForgotPasswordService resetPasswordService;
	
	@GetMapping("/sendotp")
	public ModelAndView getotppage() {
		LOGGER.info("getotppage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/sendotp");
		return modelAndView;
	}

	
	@PostMapping("/sendotp.do")
	public ModelAndView sendOTP(String user, HttpSession session) {
		LOGGER.info("sendOTP method invoked");
		ModelAndView modelAndView = new ModelAndView();
		String otp = resetPasswordService.validateAndSendOTP(user);
		System.out.println(otp);
		if (otp != null) {
			session.setAttribute(user, otp);
			session.setAttribute("email", user);
			modelAndView.setViewName("user/resetpassword");
		} else {
			String msg = "Entered Email is invalid";
			modelAndView.setViewName("user/sendotp");
			modelAndView.addObject("msg", msg);
		}
		return modelAndView;
	}
	
	
	@PostMapping("/reset.do")
	public ModelAndView resetPassword(ForgotPasswordDTO dto, HttpSession session) {
		LOGGER.info("resetPassword method invoked");
		String sessionOtp = (String) session.getAttribute(dto.getEmail());
		System.out.println(sessionOtp);
		System.out.println(dto.getOtp());
		ModelAndView modelAndView = new ModelAndView();
		if (resetPasswordService.validateOTP(dto, sessionOtp)) {
			modelAndView.addObject("msg", "Password changed successfully!");
			modelAndView.setViewName("user/userLogin");
		} else {
			String msg = "OTP is incorrect";
			modelAndView.setViewName("user/resetpassword");
			modelAndView.addObject("msg", msg);
		}
		return modelAndView;
	}
	 

}
