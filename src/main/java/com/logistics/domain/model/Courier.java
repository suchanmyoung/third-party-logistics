package com.logistics.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Courier {

    private Long courierNum; // 기사 고유번호
    private String courierName; //기사 이름
    private Integer salary; //급여
    private boolean isPenalty = false; // 패널티 정보
    private boolean isPenaltyCheck; // 패널티 확인 여부
    private boolean isObjection = false; // 이의 제기 여부

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
