package com.logistics.domain.controller.compensation;

import com.logistics.domain.model.Compensation;
import com.logistics.domain.repository.CompensationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/compensation")
public class CompensationController {

    @Autowired
    private final CompensationRepository compensationRepository;

    public CompensationController(CompensationRepository compensationRepository) {
        this.compensationRepository = compensationRepository;
    }

    @ModelAttribute("allComp")
    public List<Compensation> allComp() {
        return compensationRepository.compensationList();
    }

    @GetMapping("compensationList")
    public String compList(){
        return "/compensation/compensationList";
    }



}
