package com.dxctechproject.busticketbooking.Service;

import java.util.List;

import com.dxctechproject.busticketbooking.Entity.Bus;
import com.dxctechproject.busticketbooking.Entity.BusRoute;
import com.dxctechproject.busticketbooking.Entity.Route;

public interface SearchRoutesAndSelectBusService {
	
    public List<Route> validateSearch(String origin, String destination, String date);
    
    public BusRoute copyAllValues(Route route,Bus bus);
}