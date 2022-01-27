package com.logistics.domain.controller.courier;

import com.logistics.domain.model.Courier;
import com.logistics.domain.repository.CourierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/courier")
public class CourierController {

    public CourierController(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    private final CourierRepository courierRepository;

    @ModelAttribute("couriers")
    public List<Courier> allCourier() {
        return courierRepository.findAllCouriers();
    }

    @GetMapping("/couriers")
    public String couriers(){
        return "courier/couriers";
    }

    @GetMapping("/penaltyCheck")
    public String penaltyCheck(){
        return "courier/penaltyCheck";
    }

    @PostMapping("/{courierNum}/penaltyCheck")
    public String penalthPay(@PathVariable Long courierNum,
                             @RequestParam(required = false) String courierName,
                             @RequestParam boolean isPenaltyCheck){
        Courier courier = courierRepository.findByName(courierName);
        courier.setPenaltyCheck(isPenaltyCheck);
        courierRepository.penaltyCheck(courier, 5000);
        return "redirect:/courier/penaltyCheck";
    }
}
