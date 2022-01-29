package com.logistics.domain.service;

import com.logistics.domain.model.Compensation;
import com.logistics.domain.model.Courier;
import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.CompensationRepository;
import com.logistics.domain.repository.CourierRepository;
import com.logistics.domain.repository.VOCRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VOCServiceImpl implements VOCService{

    public VOCServiceImpl(VOCRepository vocRepository, CourierRepository courierRepository, CompensationRepository compensationRepository) {
        this.vocRepository = vocRepository;
        this.courierRepository = courierRepository;
        this.compensationRepository = compensationRepository;
    }

    private final VOCRepository vocRepository;
    private final CourierRepository courierRepository;
    private final CompensationRepository compensationRepository;

    public void register(VOC voc) {
        if (voc.getFaultBy() == FaultBy.Transport) {
            compensationRepository.register(voc);
            vocRepository.register(voc);
            if(voc.getCourierName() != null) {
                Courier courier = courierRepository.findByName(voc.getCourierName());
                courierRepository.penalty(courier, 5000);
            }
        } else {
            vocRepository.register(voc);
        }
    }

    public List<VOC> vocList(){
        return vocRepository.vocList();

    }
}
