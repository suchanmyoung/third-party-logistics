package com.logistics.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class VOC {

    private Long vocNum; // 요청 번호
    private Boolean sClaim; // 클레임 여부
    private Boolean isRequestCompensation; // 배상 요청 여부
    private FaultBy faultBy; // 귀책 당사자  >> Enum ?
    private String faultContents; // 귀책 내용
    private String penalty; // 패널티 내용
    private Boolean isCheckByCourier; // 기사 확인 여부
    private Boolean isObjection; // 이의 제기 여부
    private String compensation; // 배상 정보

}
