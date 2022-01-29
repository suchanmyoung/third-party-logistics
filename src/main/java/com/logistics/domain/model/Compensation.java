package com.logistics.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Compensation extends VOC{

    private String courierName; // 배송원 정보
    private Integer penaltyFees; // 총 배상 금액
    private Integer penaltyCount; // 총 배상 건수

    public Compensation(FaultBy faultBy, String faultContents, String penalty, Boolean isCheckByCourier, Boolean isObjection, String compensation) {
        super(faultBy, faultContents, penalty, isCheckByCourier, isObjection, compensation);
    }
}
