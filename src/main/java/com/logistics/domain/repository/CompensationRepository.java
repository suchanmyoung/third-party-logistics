package com.logistics.domain.repository;

import com.logistics.domain.model.Compensation;
import com.logistics.domain.model.VOC;

import java.util.List;

public interface CompensationRepository {
    public void register(VOC voc);
    public List<Compensation> compensationList();
}
