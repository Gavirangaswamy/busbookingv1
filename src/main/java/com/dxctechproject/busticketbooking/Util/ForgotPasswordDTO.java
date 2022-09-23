package com.dxctechproject.busticketbooking.Util;

import lombok.Data;

@Data
public class ForgotPasswordDTO {
	
	private String email;
	private String otp;
	private String password;

}
