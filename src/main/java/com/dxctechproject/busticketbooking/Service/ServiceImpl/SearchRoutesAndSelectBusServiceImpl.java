package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechproject.busticketbooking.Entity.Bus;
import com.dxctechproject.busticketbooking.Entity.BusRoute;
import com.dxctechproject.busticketbooking.Entity.Route;
import com.dxctechproject.busticketbooking.Service.SearchRoutesAndSelectBusService;
@Service
public class SearchRoutesAndSelectBusServiceImpl implements SearchRoutesAndSelectBusService {
	public static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private RoutesServiceImpl impl;

	@Override
	public List<Route> validateSearch(String origin, String destination, String date) {
		LOGGER.info("validateSearch method invoked");
    	List<Route> route= null;
    	if(validateSearchValues(origin, destination, date)) {
    		LocalDate parsDate=LocalDate.parse(date);
    		if(parsDate.isBefore(LocalDate.now())){
    			route= null;
    		}else {
    			route=impl.getByOriginAndDestinationAndDate(origin, destination, date);
    		}
    	}else {
    		route=null;
    	}
		return route;
	}
    	
    public boolean validateSearchValues(String from, String to, String date) {
    		LOGGER.info("validateSearchValues method invoked");
    		if ((Objects.nonNull(from) && !from.isEmpty()) && (Objects.nonNull(to) && !to.isEmpty()) && (Objects.nonNull(date) && !date.isEmpty())) {
    			return true;
    		}
    		return false;
    	}

	@Override
	public BusRoute copyAllValues(Route route, Bus bus) {
		BusRoute busroute = new BusRoute();
		busroute.setBusid(bus.getId());
		busroute.setBusName(bus.getBusName());
		busroute.setBusType(bus.getBusType());
		busroute.setOrigin(route.getOrigin());
		busroute.setDestination(route.getDestination());
		busroute.setTravelDate(route.getTravelDate());
		busroute.setTravelTime(route.getTravelTime());
		busroute.setTktFare(route.getTktFare());
		busroute.setId(route.getId());
		return busroute;
	}

}
