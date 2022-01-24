package com.logistics.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class VOC {

    Long vocNum; // 요청 번호
    Boolean isClaim; // 클레임 여부
    Boolean isRequestCompensation; // 배상 요청 여부
    String faultBy; // 귀책 당사자  >> Enum ?
    String faultContents; // 귀책 내용
    String penalty; // 패널티 내용
    Boolean isCheckByCourier; // 기사 확인 여부
    Boolean isObjection; // 이의 제기 여부
    String compensation; // 배상 정보
}
