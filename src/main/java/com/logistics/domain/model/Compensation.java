package com.logistics.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Compensation extends VOC{

    private Long compensationNum;
    private String courierName; // 배송원 정보
    private Integer penaltyFee=5000; // 배상 금액
    private Integer penaltyCount=0; // 총 배상 건수
    //배상 금액을 카운트할 방법을 찾아야 해..

    public Compensation(FaultBy faultBy, String faultContents, String penalty, Boolean isCheckByCourier, Boolean isObjection, String compensation) {
        super(faultBy, faultContents, penalty, isCheckByCourier, isObjection, compensation);
    }
    //Compensation을 등록해야함....
    //등록하면서 부모정보인 VOC를 참조해서.....
    // 등록하는 API를 만들어야 함..
    //지금 couriers / penaltyCheck가 사실은 Compensation의 역할이지 않을까?
}
