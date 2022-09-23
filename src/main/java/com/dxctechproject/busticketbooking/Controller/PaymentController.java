package com.dxctechproject.busticketbooking.Controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Entity.Payment;
import com.dxctechproject.busticketbooking.Entity.Route;
import com.dxctechproject.busticketbooking.Entity.Ticket;
import com.dxctechproject.busticketbooking.Service.BusService;
import com.dxctechproject.busticketbooking.Service.PaymentService;
import com.dxctechproject.busticketbooking.Service.RoutesService;
import com.dxctechproject.busticketbooking.Service.TicketService;
import com.dxctechproject.busticketbooking.Util.MailSenderUtil;
import com.dxctechproject.busticketbooking.Util.PaytmDetailPojo;
import com.paytm.pg.merchant.PaytmChecksum;

@Controller
public class PaymentController {
	@Autowired
	private PaytmDetailPojo paytmDetailPojo;
	@Autowired
	private Environment env;
	@Autowired
	private PaymentService payService;
	@Autowired
	private TicketService ticketService;
	
	@Autowired
    private RoutesService routeService;
	
	@Autowired
	private BusService busService;
	
	private Ticket ticket;
	@Autowired
	private MailSenderUtil util;

	@PostMapping(value = "/submitPaymentDetail")
	public ModelAndView getRedirect(Payment payment, Ticket ticket, HttpSession session) throws Exception {
		Payment pay = payService.saveDetails(payment);
		System.out.println(pay.getOrderId());
		System.out.println(ticket);
		this.ticket = ticket;
		ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetailPojo.getPaytmUrl());
		TreeMap<String, String> parameters = new TreeMap<>();
		paytmDetailPojo.getDetails().forEach((k, v) -> parameters.put(k, v));
		parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
		parameters.put("EMAIL", env.getProperty("paytm.email"));
		parameters.put("ORDER_ID", pay.getOrderId());
		parameters.put("TXN_AMOUNT", pay.getTxnAmount());
		parameters.put("CUST_ID", pay.getCustId());
		String checkSum = getCheckSum(parameters);
		parameters.put("CHECKSUMHASH", checkSum);
		modelAndView.addAllObjects(parameters);
		return modelAndView;
	}

	@PostMapping(value = "/pgresponse")
	public String getResponseRedirect(HttpServletRequest request, Model model, HttpSession session) {
		Map<String, String[]> mapData = request.getParameterMap();
		TreeMap<String, String> parameters = new TreeMap<String, String>();
		String paytmChecksum = "";
		for (Entry<String, String[]> requestParamsEntry : mapData.entrySet()) {
			if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())) {
				paytmChecksum = requestParamsEntry.getValue()[0];
			} else {
				parameters.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
			}
		}
		String result;
		boolean isValideChecksum = false;
		System.out.println("RESULT : " + parameters.toString());
		try {
			isValideChecksum = validateCheckSum(parameters, paytmChecksum);
			if (isValideChecksum && parameters.containsKey("RESPCODE")) {
				if (parameters.get("RESPCODE").equals("01")) {
					result = "Payment Successful";
				} else {
					result = "Payment Failed";
				}
			} else {
				result = "Checksum mismatched";
			}
		} catch (Exception e) {
			result = e.toString();
		}
		session.setAttribute("status", parameters.get("RESPMSG"));
		parameters.remove("CHECKSUMHASH");
		return "redirect:/ticket";
	}

	@GetMapping("/ticket")
	public ModelAndView successPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		String status = (String) session.getAttribute("status");
		modelAndView.addObject("status", status);
		modelAndView.addObject("cond", status.contains("Success"));
		if (status.contains("Success")) {
			Ticket tkt = ticketService.save(ticket);
			Route route = routeService.getRoute(tkt.getRouteid());
			util.sendMail(tkt.getUser(), "Ticket" + tkt.getTicketId() + "\n\n",
					"Thank You for Booking With Us!." + "\n\n Pickup :  " + tkt.getPickup()+", "+route.getOrigin() + "\n\n Drop :  "
							+ tkt.getDroppoint()+", "+ route.getDestination() + "\n\n Seats :  " + tkt.getSeats().substring(1, tkt.getSeats().length()-1)+ "\n\n Tavel Date :  "+route.getTravelDate()+ "\n\n Departure Time :  "+route.getTravelTime() + "\n\n Amount :  "
							+ tkt.getAmount()+" \n\n\n Happy😊 Journey!");
			if (tkt != null) {
				modelAndView.addObject("ticket", tkt);
				modelAndView.addObject("ticketId", tkt.getTicketId());
			}
		}
		session.setAttribute("user", ticket.getUser());
		modelAndView.setViewName("user/bookingsuccessfull");
		return modelAndView;
	}

	private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
		return PaytmChecksum.verifySignature(parameters, paytmDetailPojo.getMerchantKey(), paytmChecksum);
	}

	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return PaytmChecksum.generateSignature(parameters, paytmDetailPojo.getMerchantKey());
	}
}