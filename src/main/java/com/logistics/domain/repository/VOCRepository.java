package com.logistics.domain.repository;

import com.logistics.domain.model.VOC;

import java.util.List;

public interface VOCRepository {
    public void register(VOC voc);
    public List<VOC> vodList();
}
