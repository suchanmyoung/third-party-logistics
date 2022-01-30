package com.logistics;

import com.logistics.domain.model.Courier;
import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.CourierRepository;
import com.logistics.domain.repository.VOCRepository;
import com.logistics.domain.service.VOCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestData {

    private final CourierRepository courierRepository;
    private final VOCRepository vocRepository;
    private final VOCService vocService;

    @PostConstruct
    public void initCourier(){
        Courier courierA = new Courier("기사A", 2000000);
        courierA.setPenalty(true);
        Courier courierB = new Courier("기사B", 4000000);
        Courier courierC = new Courier("기사C", 3000000);


        courierRepository.save(courierA);
        courierRepository.save(courierB);
        courierRepository.save(courierC);
    }

    @PostConstruct
    public void initVOC(){
        VOC vocA = new VOC(FaultBy.Customer, "배송물품 누락", "급여 5천원 차감", false, false, "배상정보 없음");
        VOC vocB = new VOC(FaultBy.Transport, "기사A","운송사 오배송", "없음", false, false, "배상정보 없음");
        VOC vocC = new VOC(FaultBy.Customer, "배송물품 누락", "급여 5천원 차감", true, true, "배상정보 없음");
        VOC vocD = new VOC(FaultBy.Transport, "기사B","배송 지연", "급여 5천원 차감", true, true, "배상정보 없음");

        vocService.register(vocA);
        vocService.register(vocB);
        vocService.register(vocC);
        vocService.register(vocD);
    }

}
