package com.logistics.domain.controller.courier;

import com.logistics.domain.model.Courier;
import com.logistics.domain.repository.CourierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courier")
public class CourierController {

    public CourierController(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }

    private final CourierRepository courierRepository;


    @GetMapping("/couriers")
    public String couriers(Model model){
        List<Courier> couriers = courierRepository.findAllCouriers();
        model.addAttribute("couriers", couriers);
        return "courier/couriers";
    }



}
