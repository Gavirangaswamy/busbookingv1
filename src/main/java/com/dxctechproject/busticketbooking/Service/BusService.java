package com.dxctechproject.busticketbooking.Service;

import com.dxctechproject.busticketbooking.Entity.Bus;

import java.util.List;


public interface BusService {

    Bus saveBus(Bus bus);


    void deleteBusById(Long id);

    Bus getBus(Long id);

    Bus updateBus(Bus bus);

    List<Bus> getAllBuses();
}
