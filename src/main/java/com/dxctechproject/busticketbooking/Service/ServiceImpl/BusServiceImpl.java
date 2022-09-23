package com.dxctechproject.busticketbooking.Service.ServiceImpl;

import com.dxctechproject.busticketbooking.Entity.Bus;
import com.dxctechproject.busticketbooking.Exceptions.ResourceNotFoundException;
import com.dxctechproject.busticketbooking.Repository.BusRepository;
import com.dxctechproject.busticketbooking.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }


    @Override
    public void deleteBusById(Long id) {
        busRepository.deleteById(id);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBus(Long id) {
        return busRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Could not find bus by id", "id", id)
        );
    }

    @Override
    public Bus updateBus(Bus bus) {
        return busRepository.save(bus);
    }
}
