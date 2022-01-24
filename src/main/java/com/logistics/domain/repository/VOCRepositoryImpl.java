package com.logistics.domain.repository;

import com.logistics.domain.model.VOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class VOCRepositoryImpl implements VOCRepository{

    private static Map<Long, VOC> vocStore = new HashMap<>();
    private static Long sequence = 0L;

    public void register(VOC voc) {
        voc.setVocNum(++sequence);
        vocStore.put(voc.getVocNum(), voc);
    }

    public void panalty(int penaltyFee){

        //운송사 귀책 >> 비용 청구 접수 및 발급 >>패널티 발급 및 앱 푸시 >> 사인하면 월급에서 차감
    }
}
