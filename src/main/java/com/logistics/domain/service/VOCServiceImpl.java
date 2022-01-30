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

    public VOCServiceImpl(VOCRepository vocRepository, CourierRepository courierRepository, CompensationService compensationService) {
        this.vocRepository = vocRepository;
        this.courierRepository = courierRepository;
        this.compensationService = compensationService;
    }

    private final VOCRepository vocRepository;
    private final CourierRepository courierRepository;
    private final CompensationService compensationService;

    public void register(VOC voc) {
        vocRepository.register(voc);
        compensationService.register(voc);
    }

    public List<VOC> vocList(){
        return vocRepository.vocList();

    }
}
