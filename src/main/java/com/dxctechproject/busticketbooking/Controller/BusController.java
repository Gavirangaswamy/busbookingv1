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
import com.dxctechproject.busticketbooking.Service.BusService;

@Controller
public class BusController {

    @Autowired
    private BusService busService;
    ModelAndView modelAndView = new ModelAndView();

    public static final Logger LOGGER = LoggerFactory.getLogger(BusController.class);

    @GetMapping("/showCreate")
    public ModelAndView showCreate() {
        modelAndView.setViewName("admin/addBus");
        return modelAndView;
    }

    @PostMapping("/saveBus")
    public ModelAndView saveBus(Bus bus) {
        Bus busSaved = busService.saveBus(bus);
        modelAndView.addObject("bus", busSaved);
        modelAndView.setViewName("admin/addBus");
        return modelAndView;
    }


    @GetMapping("/displayBuses")
    public ModelAndView displayBuses() {
        List<Bus> buses = busService.getAllBuses();
        modelAndView.addObject("buses", buses).setViewName("admin/displayBusesPage");
        return modelAndView;
    }


    @GetMapping("/AdminDashboard")
    public ModelAndView AdminDashboard() {
        modelAndView.setViewName("admin/Admin_dashboard");
        return modelAndView;
    }

    @RequestMapping("/deleteBus")
    public ModelAndView deleteBus(@RequestParam("id") Long id) {
        busService.deleteBusById(id);
        List<Bus> buses = busService.getAllBuses();
        modelAndView.addObject("buses", buses).setViewName("admin/displayBusesPage");
        return modelAndView;
    }

    @GetMapping("/showUpdateBus")
    public ModelAndView showUpdate(@RequestParam("id") Long id) {
        Bus bus = busService.getBus(id);
        modelAndView.addObject("bus", bus).setViewName("admin/updateBusPage");
        return modelAndView;
    }

    @PostMapping("/updateBus")
    public ModelAndView updateBus(Bus bus) {
        busService.updateBus(bus);
        List<Bus> buses = busService.getAllBuses();
        modelAndView.addObject("buses", buses).setViewName("admin/displayBusesPage");
        return modelAndView;
    }
}
