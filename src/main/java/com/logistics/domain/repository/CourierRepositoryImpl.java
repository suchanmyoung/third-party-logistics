package com.logistics.domain.repository;

import com.logistics.domain.model.Courier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void penalty(Courier courier, int penalty) {
        courier.setSalary(courier.getSalary() - 5000);
        System.out.println(courier.toString());

    }


}

