package com.juarodriguezc.api.controllers;

import com.juarodriguezc.api.models.SummationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/summation")
public class SummationController {
    @GetMapping()
    public SummationModel getSummation(@RequestParam int number){
        SummationModel summationModel = new SummationModel();
        summationModel.calcSummation(number);
        return summationModel;
    }
}
