package com.dxctechproject.busticketbooking.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Entity.Bus;
import com.dxctechproject.busticketbooking.Entity.Cancelled;
import com.dxctechproject.busticketbooking.Entity.Route;
import com.dxctechproject.busticketbooking.Entity.Ticket;
import com.dxctechproject.busticketbooking.Service.BusService;
import com.dxctechproject.busticketbooking.Service.CancelledService;
import com.dxctechproject.busticketbooking.Service.RoutesService;
import com.dxctechproject.busticketbooking.Service.TicketService;
import com.dxctechproject.busticketbooking.Util.MailSenderUtil;
import com.dxctechproject.busticketbooking.Util.PdfGenerator;
import com.lowagie.text.DocumentException;


@Controller
public class TicketController {
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	private CancelledService service;
	
	@Autowired
    private RoutesService routeService;
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private MailSenderUtil util;
	
	public Cancelled getTicket(String ticketId) {
		Ticket entity = ticketService.findById(ticketId);
		Cancelled ticket = new Cancelled();
		ticket.setTicketId(entity.getTicketId());
		Route route = routeService.getRoute(entity.getRouteid());
		Bus bus = busService.getBus(route.getBus());
		ticket.setBusName(bus.getBusName());
		ticket.setBusNumber(bus.getBusRegNo());
		ticket.setRouteName(route.getRouteName());
		ticket.setOrigin(route.getOrigin());
		ticket.setDestination(route.getDestination());
		ticket.setTravelDate(route.getTravelDate());
		ticket.setTravelTime(route.getTravelTime());
		ticket.setAmount(entity.getAmount());
		ticket.setCount(entity.getCount());
		ticket.setSeats(entity.getSeats().substring(1,(entity.getSeats()).length()-1));
		ticket.setCancelledAt(entity.getBookedAt());
		ticket.setUser(entity.getUser());
		return ticket;
	}
	
	@GetMapping("/bookingprocess")
	public ModelAndView paymentpage(String totalamount,String totalcount, String route,String seatnumbers,String pickup,String drop,String user, HttpSession session) {
		LOGGER.info("paymentpage method invoked");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		if(seatnumbers!=null && !seatnumbers.isEmpty() && Integer.valueOf(totalcount)>0 && Integer.valueOf(totalcount)<=5) {
			modelAndView.setViewName("user/payment");
			modelAndView.addObject("seatnumbers", seatnumbers);
			modelAndView.addObject("totalamount", totalamount);
			modelAndView.addObject("totalcount", totalcount);
			modelAndView.addObject("pickup", pickup);
			modelAndView.addObject("drop",drop);
			modelAndView.addObject("route", route);
		}else {
			Route route1 = (Route) session.getAttribute("selectedbus");
			Bus bus = busService.getBus(route1.getBus());
			String[] pickUpArr = route1.getPickUp().split(",");
			List<String> pickUps = new ArrayList<>(Arrays.asList(pickUpArr));
			String[] dropArr = route1.getDropping().split(",");
			List<String> drops = new ArrayList<>(Arrays.asList(dropArr));
			modelAndView.addObject("pickUps", pickUps);
			modelAndView.addObject("drops", drops);
			modelAndView.addObject("sbus",route1 );
			modelAndView.addObject("seatnos", bus.getNo_of_seats());
			List<Ticket> list = ticketService.findAll();
			List<String> seats = new ArrayList<>();
			for (Ticket ticket : list) {
				if(ticket.getRouteid()==route1.getId()) {
					String seatstring = ticket.getSeats();
					String seat = (String) seatstring.subSequence(1, seatstring.length()-1);
					seats.add(seat);	
	 			}
			}
			String msg = "";
			if(totalcount.equals("")){
				msg ="Please Select Seats!";
			}else if(Integer.valueOf(totalcount)>5) {
				msg = "Maximum 5 seats allowed";
			}
			modelAndView.addObject("msg", msg);
			modelAndView.addObject("bseats", seats.toString());
			if(bus.getBusType().equalsIgnoreCase("sleeper")||bus.getBusType().equalsIgnoreCase("ac-sleeper")) {	
				modelAndView.setViewName("user/sleeperbus");
			}else {
				modelAndView.setViewName("user/normalbus");
			}
		}
		return modelAndView;
	}
	
	
	
	@RequestMapping("bookedtickets")
	public ModelAndView showBookedTickets(HttpSession session) {
		LOGGER.info("bookedticketpage method invoked");
		ModelAndView mv = new ModelAndView();
		List<Ticket> ids = ticketService.findByEmail(session.getAttribute("user").toString().toLowerCase());
		List<Cancelled> tickets = new ArrayList<>();
		Cancelled ticket = new Cancelled();
		for(Ticket entity:ids) {
			ticket = getTicket(entity.getTicketId());
			tickets.add(ticket);
		}
		mv.addObject("bookedTickets", tickets);
		mv.setViewName("user/bookedtickets");
		return mv;
	}
	
	@PostMapping("cancelticket")
	public String cancelTicket(HttpSession session,@RequestParam("ticketId") String ticketId) {
		Cancelled ticket = getTicket(ticketId);
		ticketService.deleteTicketById(ticketId);
		Cancelled tkt = service.cancelTicket(ticket);
		util.sendMail(tkt.getUser(), "Ticket" + tkt.getTicketId() + "\n",
				"Your Ticket has been cancelled successfully!." + "\n\n Pickup: " + tkt.getOrigin() + "\n\n Drop: "
						+ tkt.getDestination() + "\n\n Seats: " + tkt.getSeats()+ "\n\n Departure Time: "+tkt.getTravelTime() + "\n\n Tavel Date: "+tkt.getTravelDate() + "\n\n Amount: "
						+ tkt.getAmount()+" \n\n 😊!");
		return "redirect:/cancelledtickets";
	}
	
	@RequestMapping("cancelledtickets")
	public ModelAndView showCancelledTickets(HttpSession session) {
		LOGGER.info("cancelled tickets page method invoked");
		ModelAndView mv = new ModelAndView();
		List<Cancelled> tickets = service.findByEmail(session.getAttribute("user").toString().toLowerCase());
		mv.addObject("cancelledTickets", tickets);
		mv.setViewName("user/cancelledtickets");
		return mv;
	}
	
  
	  //@RequestParam int ticketId,
	  @RequestMapping("print/{ticketId}")
		public String generatePdf(@PathVariable("ticketId") String ticketId, HttpServletResponse response,HttpSession session) throws DocumentException, IOException {
			response.setContentType("application/pdf");
//			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
//			String currentDateTime = dateFormat.format(new java.util.Date());
			String headerkey = "Content-Disposition";			
			Cancelled ticket = getTicket(ticketId);
			
			String headervalue = "attachment; filename=pdf_" + ticket.getTicketId() + ".pdf";
//			String headervalue = "attachment; filename=pdf_" + session.getAttribute("user").toString() + ".pdf";
			response.setHeader(headerkey, headervalue);
	        PdfGenerator exporter = new PdfGenerator(ticket);
	        exporter.generate(response);   
	        return "user/searchBuses";
	  }
	  
	  @GetMapping("displayTickets")
	  public ModelAndView showTicketDetails() {
		  ModelAndView mv = new ModelAndView();
		  List<Ticket> tkts = ticketService.findAll();
		  List<Cancelled> tickets = new ArrayList<>();
		  for(Ticket ticket:tkts) {
			  tickets.add(getTicket(ticket.getTicketId()));
		  }
		  mv.addObject("tickets", tickets);
		  mv.setViewName("admin/displayticketspage");
		  return mv;
	  }

}
