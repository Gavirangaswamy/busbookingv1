package com.dxctechproject.busticketbooking.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctechproject.busticketbooking.Entity.Bus;
import com.dxctechproject.busticketbooking.Entity.Route;
import com.dxctechproject.busticketbooking.Service.BusService;
import com.dxctechproject.busticketbooking.Service.RoutesService;

@Controller
public class RoutesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoutesController.class);

    ModelAndView modelAndView = new ModelAndView();

    @Autowired
    private RoutesService routeService;
    
    @Autowired
    private BusService busService;

    @GetMapping("/saveRoutePage")
    public ModelAndView saveRoutesPage() {
        LOGGER.info("Inside Routes info/save route page");
        List<Bus> bus = busService.getAllBuses();
        modelAndView.setViewName("admin/addRoutes");
        modelAndView.addObject("Bus",bus);
        System.out.println(bus);
        return modelAndView;
    }

	@PostMapping("/saveRoute")
    public ModelAndView saveRoute(Route route) {
        LOGGER.info("Inside Routes info..");
        List<Route> route1 = routeService.getAllRoutes();
        boolean check = true;
        for (Route route2 : route1) {
			if(route2.getBus()==route.getBus()) {
				check=false;
			}
		}
        if(check) {
        	Route routeSaved = routeService.saveRoute(route);
            modelAndView.addObject("route", routeSaved);
            modelAndView.setViewName("redirect:/displayRoutes");
        } 
        else {
        	String message = "This bus is already in used..";
        	modelAndView.addObject("message", message);
        	modelAndView.setViewName("admin/addRoutes");
        }
        return modelAndView;
    }

    @GetMapping("/displayRoutes")
    public ModelAndView displayRoutesPage() {
        LOGGER.info("Inside Routes info/display routes");
        List<Route> routes = routeService.getAllRoutes();
        modelAndView.addObject("routes", routes);
        modelAndView.setViewName("admin/displayRoutesPage");
        return modelAndView;
    }


    @GetMapping("/showUpdateRoute")
    public ModelAndView showUpdate(@RequestParam("id") Long id) {
        Route route = routeService.getRoute(id);
        modelAndView.addObject("route", route);
        modelAndView.setViewName("admin/updateRoutesPage");
        return modelAndView;
    }

    @PostMapping("/updateRoute")
    public ModelAndView updateRoute(Route route) {
        routeService.updateRoute(route);
        List<Route> routes = routeService.getAllRoutes();
        modelAndView.addObject("routes", routes);
        modelAndView.setViewName("admin/displayRoutesPage");
        return modelAndView;
    }

    @RequestMapping("/deleteRoute")
    public ModelAndView deleteRoute(@RequestParam("id") Long id) {
        routeService.deleteRouteById(id);
        List<Route> routes = routeService.getAllRoutes();
        modelAndView.addObject("routes", routes);
        modelAndView.setViewName("admin/displayRoutesPage");
        return modelAndView;
    }
}
