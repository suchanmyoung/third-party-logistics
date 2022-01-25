package com.logistics.domain.repository;

import com.logistics.domain.model.Courier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class CourierRepositoryImpl implements CourierRepository{

    private static Long sequence = 0L;
    private static final Map<Long, Courier> courierStore = new HashMap<>();

    @Override
    public void save(Courier courier) {
        courier.setCourierNum(sequence++);
        courierStore.put(courier.getCourierNum(), courier);
    }

    public List<Courier> findAllCouriers(){
            return new ArrayList<>(courierStore.values());
        }

    @Override
    public Courier findByNum(Long id) {
        return courierStore.get(id);
    }

    @Override
    public Courier findByName(String name){
        List<Courier> allCouriers = findAllCouriers();
        for (Courier courier : allCouriers) {
            boolean equals = courier.getCourierName().equals(name);
            if(equals){
                return courier;
            }
        }
        return null;
    }

    @Override
    public void penalty(Courier courier, int penalty) {
        courier.setSalary(courier.getSalary() - 5000);
        log.info("{}님의 급여가 차감되어 현재 급여는 {} 입니다.", courier.getCourierName(), courier.getSalary());

    }


}

