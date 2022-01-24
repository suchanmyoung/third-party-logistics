package com.logistics.domain.service;

import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.VOCRepository;
import org.springframework.stereotype.Service;

@Service
public class VOCServiceImpl implements VOCService{

    public VOCServiceImpl(VOCRepository vocRepository) {
        this.vocRepository = vocRepository;
    }

    VOCRepository vocRepository;

    public void register(VOC voc) {
        if(voc.getFaultBy() == FaultBy.Transport){
//            vocRepository.penalty(5000);
//            //기사 정보를 넘겨야 하고
//            //이의 제기를 체크하고
//            //급여를 확인해서 차감
        }
        vocRepository.register(voc);
    }
}
