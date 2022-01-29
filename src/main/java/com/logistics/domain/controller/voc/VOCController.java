package com.logistics.domain.controller.voc;

import com.logistics.domain.model.Courier;
import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.CourierRepository;
import com.logistics.domain.repository.VOCRepository;
import com.logistics.domain.service.VOCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @ModelAttribute("allVoc")
    public List<VOC> allVoc() {
        return vocRepository.vodList();
    }

    @ModelAttribute("faultBy")
    public FaultBy[] faultBy() {
        return FaultBy.values();
    }

    @ModelAttribute("courier")
    public List<Courier> courier() {
        return courierRepository.findAllCouriers();
    }

    @GetMapping("/register")
    public String registerForm() {
        return "voc/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute VOC voc, BindingResult bindingResult) {
        if (String.valueOf(voc.getFaultBy()) == "null") {
            log.error("귀책사 당사자를 선택해주세요.");
            return "voc/register";
        } else {
            vocService.register(voc);
            return "redirect:/voc/register";
            }
    }

    @GetMapping("vocList")
    public String vocList(){
            return "voc/vocList";
    }
}
