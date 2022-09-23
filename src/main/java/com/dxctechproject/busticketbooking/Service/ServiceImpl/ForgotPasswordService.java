package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.dxctechproject.busticketbooking.Entity.User;
import com.dxctechproject.busticketbooking.Util.ForgotPasswordDTO;
import com.dxctechproject.busticketbooking.Util.MailSenderUtil;
import com.dxctechproject.busticketbooking.Util.OTPGenerator;

@Service
public class ForgotPasswordService {

	@Autowired
	private UserServiceImpl impl;
	@Autowired
	private MailSenderUtil util;
	private static final Logger LOGGER = LogManager.getLogger();

	public String validateAndSendOTP(String email) {
		LOGGER.info("validateAndSendOTP method invoked");
		if (Objects.nonNull(email) && !email.isEmpty()) {
			User user = impl.findByEmail(email);
			if (user != null) {
				if (user.getEmail().equals(email)) {
					String otp = OTPGenerator.GetOTP();
					util.sendMail(email, "OTP", otp);
					return otp;
				}
			}else {
				return null;
			}
		}
		return null;
	}

	public boolean validateOTP(ForgotPasswordDTO dto, String otpFromSession) {
		LOGGER.info("validatePassword method invoked");
		if (dto.getOtp().equals(otpFromSession)) {
			if (Objects.nonNull(dto.getPassword())&& !dto.getPassword().isEmpty()) {
				impl.upadatePassword(dto.getPassword(), dto.getEmail());
				return true;
			}
		}
		return false;
	}

}
