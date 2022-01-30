package com.logistics.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Compensation extends VOC{

    private Long compensationNum;
    private Integer penaltyFee=5000; // 배상 금액
    private Integer penaltyCount=0; // 총 배상 건수

    public Compensation(FaultBy faultBy, String faultContents, String penalty, Boolean isCheckByCourier, Boolean isObjection, String compensation) {
        super(faultBy, faultContents, penalty, isCheckByCourier, isObjection, compensation);
    }
}
