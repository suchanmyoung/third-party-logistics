package com.logistics.domain.service;

import com.logistics.domain.model.Courier;
import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.CompensationRepository;
import com.logistics.domain.repository.CourierRepository;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService{

    public CompensationServiceImpl(CompensationRepository compensationRepository, CourierRepository courierRepository) {
        this.compensationRepository = compensationRepository;
        this.courierRepository = courierRepository;
    }

    private final CompensationRepository compensationRepository;
    private final CourierRepository courierRepository;

    @Override
    public void register(VOC voc) {
        if (voc.getFaultBy() == FaultBy.Transport) {
            compensationRepository.register(voc);
            if (voc.getCourierName() != null) {
                Courier courier = courierRepository.findByName(voc.getCourierName());
                courierRepository.penalty(courier, 5000);
            }
        }
    }
}
