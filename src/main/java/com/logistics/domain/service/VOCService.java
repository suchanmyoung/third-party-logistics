package com.logistics.domain.service;

import com.logistics.domain.model.VOC;

import java.util.List;

public interface VOCService {
    public void register(VOC voc);
    public List<VOC> vocList();
}
