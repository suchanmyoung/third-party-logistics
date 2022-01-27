package com.logistics.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Courier {

    Long courierNum; // 기사 고유번호
    String courierName; //기사 이름
    Integer salary; //급여
    boolean isPenalty = false; // 패널티 정보
    boolean isPenaltyCheck; // 패널티 확인 여부
    boolean isObjection; // 이의 제기 여부

    public Courier(String courierName, Integer salary) {
        this.courierName = courierName;
        this.salary = salary;
    }

    public Courier(String courierName, Integer salary, boolean isObjection) {
        this.courierName = courierName;
        this.salary = salary;
        this.isObjection = isObjection;
    }


}
