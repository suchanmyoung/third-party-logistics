package com.logistics.domain.repository;

import com.logistics.domain.model.VOC;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class VOCRepositoryImpl implements VOCRepository{

    private static Map<Long, VOC> vocStore = new HashMap<>();
    private static Long sequence = 0L;

    public void register(VOC voc) {
        voc.setVocNum(++sequence);
        vocStore.put(voc.getVocNum(), voc);
        log.info("VOC 번호 {}가 등록되었습니다.", voc.getVocNum());
    }

    public List<VOC> vodList(){
        return new ArrayList<>(vocStore.values());
    }
}
