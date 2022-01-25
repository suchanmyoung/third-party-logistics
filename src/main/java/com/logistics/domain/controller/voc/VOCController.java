package com.logistics.domain.controller.voc;

import com.logistics.domain.model.Courier;
import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.CourierRepository;
import com.logistics.domain.repository.VOCRepository;
import com.logistics.domain.repository.VOCRepositoryImpl;
import com.logistics.domain.service.VOCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/voc")
public class VOCController {

    @Autowired
    public VOCController(VOCRepository vocRepository, VOCService vocService, CourierRepository courierRepository) {
        this.vocRepository = vocRepository;
        this.vocService = vocService;
        this.courierRepository = courierRepository;
    }

    private final VOCRepository vocRepository;
    private final VOCService vocService;
    private final CourierRepository courierRepository;

    @ModelAttribute("faultBy")
    public FaultBy[] faultBy(){
        return FaultBy.values();
    }

    @ModelAttribute("courier")
    public List<Courier> courier(){
        return courierRepository.findAllCouriers();
    }

    @GetMapping("/register")
    public String registerForm() {
        return "voc/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute VOC voc) {
        vocService.register(voc);
        return "redirect:/voc/register";
    }
}
