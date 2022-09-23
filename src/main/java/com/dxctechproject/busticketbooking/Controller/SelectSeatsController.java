package com.dxctechproject.busticketbooking.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Entity.Bus;
import com.dxctechproject.busticketbooking.Entity.Route;
import com.dxctechproject.busticketbooking.Entity.Ticket;
import com.dxctechproject.busticketbooking.Service.BusService;
import com.dxctechproject.busticketbooking.Service.RoutesService;
import com.dxctechproject.busticketbooking.Service.TicketService;

@Controller
public class SelectSeatsController {
	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private RoutesService rService;
	
	@Autowired
	private BusService service;
	
	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "selectBus/{id}/{user}", method = RequestMethod.GET)
	 public String selectBuses(@PathVariable("id") long id,@PathVariable("user") String user, HttpSession session) {
		Route route = rService.getRoute(id);
		session.setAttribute("selectedbus", route);
		session.setAttribute("user", user);
		return "redirect:/selectseats";
	}
	
	@GetMapping("/selectseats")
	public ModelAndView selectseats(HttpSession session) {
		LOGGER.info("selectseats method invoked");
		ModelAndView modelAndView = new ModelAndView();
		Route route = (Route) session.getAttribute("selectedbus");
		modelAndView.addObject("sbus",route );
		List<Ticket> list = ticketService.findAll();
		List<String> seats = new ArrayList<>();
		String[] pickUpArr = route.getPickUp().split(",");
		List<String> pickUps = new ArrayList<>(Arrays.asList(pickUpArr));
		String[] dropArr = route.getDropping().split(",");
		List<String> drops = new ArrayList<>(Arrays.asList(dropArr));
		modelAndView.addObject("pickUps", pickUps);
		modelAndView.addObject("drops", drops);
		Bus bus = service.getBus(route.getBus());
		modelAndView.addObject("seatnos", bus.getNo_of_seats());
		modelAndView.addObject("user", session.getAttribute("user"));
		for (Ticket ticket : list) {
			if(ticket.getRouteid()==route.getId()) {
				String seatstring = ticket.getSeats();
				String seat = (String) seatstring.subSequence(1, seatstring.length()-1);
				seats.add(seat);	
 			}
		}
		modelAndView.addObject("bseats", seats.toString());
		if(bus.getBusType().equalsIgnoreCase("sleeper")||bus.getBusType().equalsIgnoreCase("ac-sleeper")) {
			modelAndView.setViewName("user/sleeperbus");
		}else {
			modelAndView.setViewName("user/normalbus");
		}
		return modelAndView;
	}
	

}
