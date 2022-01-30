package com.logistics.domain.repository;

import com.logistics.domain.model.Compensation;
import com.logistics.domain.model.VOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class CompensationRepositoryImpl implements CompensationRepository{

    Map<Long, Compensation> compensationStore = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void register(VOC voc) {
        Compensation comp = new Compensation(voc.getFaultBy(), voc.getFaultContents(), voc.getPenalty(), voc.getIsCheckByCourier(), voc.getIsObjection(), voc.getCompensation());
        comp.setCompensationNum(++sequence);
        comp.setPenaltyCount(comp.getPenaltyCount()+1);
        compensationStore.put(comp.getCompensationNum(), comp);
        log.info("배상 정보 번호 {}가 등록되었습니다.", comp.getCompensationNum());
    }

    @Override
    public List<Compensation> compensationList(){
        return new ArrayList<>(compensationStore.values());
    }
}
