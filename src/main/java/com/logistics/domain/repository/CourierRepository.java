package com.logistics.domain.repository;

import com.logistics.domain.model.Courier;

import java.util.ArrayList;
import java.util.List;

public interface CourierRepository {

    public void save(Courier courier);
    public List<Courier> findAllCouriers();
    public Courier findByName(String name);
    public Courier findByNum(Long id);
    public void penalty(Courier courier, int penalty);
    public void penaltyCheck(Courier courier, int penalty);

}
