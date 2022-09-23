package com.dxctechproject.busticketbooking.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Entity.BusRoute;
import com.dxctechproject.busticketbooking.Entity.Route;
import com.dxctechproject.busticketbooking.Service.BusService;
import com.dxctechproject.busticketbooking.Service.SearchRoutesAndSelectBusService;

@Controller
public class SearchRoutesAndSelectBusController {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	public SearchRoutesAndSelectBusService impl;
	
	@Autowired
	private BusService bService;
	

	
	@GetMapping("/searchBus")
	public ModelAndView getBuses(String origin, String destination, String date,String user, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<Route> route = impl.validateSearch(origin, destination, date);
		ArrayList<BusRoute> busroutes = new ArrayList<>();
		if(route!=null && !route.isEmpty()) {
			for (Route route1 : route) {
				busroutes.add(impl.copyAllValues(route1,bService.getBus(route1.getBus())));
			}
			mav.addObject("user", session.getAttribute("user"));
			mav.addObject("bus", busroutes);
			mav.setViewName("user/selectBus");
		}else {
			String msg = "Sorry! No buses available";
			mav.addObject("msg", msg);
			mav.addObject("user", session.getAttribute("user"));
			mav.setViewName("user/searchBuses");
		}
		return mav;
	}
	
}
