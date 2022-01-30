package com.logistics.domain.service;

import com.logistics.domain.model.Courier;
import com.logistics.domain.model.VOC;

public interface CompensationService {
    public void register(VOC voc);
    public void objection(Courier courier);
}
