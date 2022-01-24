package com.logistics.domain.controller;

import com.logistics.domain.model.VOC;
import com.logistics.domain.repository.VOCRepository;
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
    public VOCController(VOCRepository vocRepository) {
        this.vocRepository = vocRepository;
    }

    private final VOCRepository vocRepository;

    @GetMapping("/register")
    public String registerForm() {
        return "voc/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute VOC voc) {
        vocRepository.register(voc);
        return "voc/register";
    }
}
