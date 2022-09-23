package com.dxctechproject.busticketbooking.Service.ServiceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctechproject.busticketbooking.Entity.Route;
import com.dxctechproject.busticketbooking.Exceptions.ResourceNotFoundException;
import com.dxctechproject.busticketbooking.Repository.RouteRepository;
import com.dxctechproject.busticketbooking.Service.RoutesService;

@Service
public class RoutesServiceImpl implements RoutesService {

    @Autowired
    private RouteRepository routeRepository;


    @Override
    public Route saveRoute(Route route) {
//    	for(Bus bus :route.getBus()) 
//    	{
//    	   bus.setRoute(route);
//    	}
//    	route.setBus(route.getBus());
    	
        return routeRepository.save(route);
    }

    @Override
    public void deleteRouteById(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public Route updateRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route getRoute(Long id) {
        return routeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Route not found", "id", id)
        );
    }


    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

	@Override
	public ArrayList<Route> getByOriginAndDestinationAndDate(String origin, String destination, String date) {
		
		return routeRepository.getByOriginAndDestinationAndDate(origin, destination, date);
	}
    
    

}
