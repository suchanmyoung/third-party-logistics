package com.logistics.domain.service;

import com.logistics.domain.model.Courier;
import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.CourierRepository;
import com.logistics.domain.repository.VOCRepository;
import org.springframework.stereotype.Service;

@Service
public class VOCServiceImpl implements VOCService{

    public VOCServiceImpl(VOCRepository vocRepository, CourierRepository courierRepository) {
        this.vocRepository = vocRepository;
        this.courierRepository = courierRepository;
    }

    private final VOCRepository vocRepository;
    private final CourierRepository courierRepository;

    public void register(VOC voc) {
        if(voc.getFaultBy() == FaultBy.Transport){
            Courier courier = courierRepository.findByNum(voc.getCourier().getCourierNum());
            courierRepository.penalty(courier, 5000);
        }
        vocRepository.register(voc);
    }
}
