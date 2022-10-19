package com.juarodriguezc.api.controllers;

import com.juarodriguezc.api.models.HappyNumberModel;
import com.juarodriguezc.api.models.NumbersModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/happynumber")
public class HappyNumberController {
    @GetMapping()
    public NumbersModel happyNumbers(@RequestParam int[] numbers){
        NumbersModel numbersModel = new NumbersModel();
        List<HappyNumberModel> lNumber = numbersModel.getNumbers();
        for(int number : numbers){
            HappyNumberModel happyNumber = new HappyNumberModel(number);
            happyNumber.isHappyNumber();
            lNumber.add(happyNumber);
        }
        return numbersModel;
    }
}
