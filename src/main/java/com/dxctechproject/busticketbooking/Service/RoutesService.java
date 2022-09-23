package com.dxctechproject.busticketbooking.Service;

import com.dxctechproject.busticketbooking.Entity.Route;

import java.util.List;


public interface RoutesService {

    Route saveRoute(Route route);

    void deleteRouteById(Long id);

    Route updateRoute(Route route);

    Route getRoute(Long id);

    List<Route> getAllRoutes();
    
    List<Route> getByOriginAndDestinationAndDate(String origin, String destination, String date);

}
