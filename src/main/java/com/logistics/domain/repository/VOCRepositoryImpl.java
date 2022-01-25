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
}
