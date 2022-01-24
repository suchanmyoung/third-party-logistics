package com.logistics.domain.controller.voc;

import com.logistics.domain.model.FaultBy;
import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.VOCRepositoryImpl;
import com.logistics.domain.service.VOCService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/voc")
public class VOCController {

    @Autowired
    public VOCController(VOCRepositoryImpl vocRepository, VOCService vocService) {
        this.vocRepository = vocRepository;
        this.vocService = vocService;
    }

    private final VOCRepositoryImpl vocRepository;
    private final VOCService vocService;

    @ModelAttribute("faultBy")
    public FaultBy[] faultBy(){
        return FaultBy.values();
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
