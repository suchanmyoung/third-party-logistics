package com.logistics;

import com.logistics.domain.model.Courier;
import com.logistics.domain.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestData {

    private final CourierRepository courierRepository;

    @PostConstruct
    public void init(){
        Courier courierA = new Courier("기사A", 2000000);
        courierA.setPenalty(true);
        Courier courierB = new Courier("기사B", 4000000);
        Courier courierC = new Courier("기사C", 3000000);


        courierRepository.save(courierA);
        courierRepository.save(courierB);
        courierRepository.save(courierC);
    }

}
