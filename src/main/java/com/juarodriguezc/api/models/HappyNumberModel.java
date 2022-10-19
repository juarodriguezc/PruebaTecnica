package com.juarodriguezc.api.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberModel {
    private int number;
    private boolean isHappy = false;

    public HappyNumberModel(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @JsonProperty("isHappy")
    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean isHappy) {
        isHappy = isHappy;
    }

    public void isHappyNumber(){
        Set<Integer> results = new HashSet<>();
        results.add(this.number);
        int sum = 0;
        Integer numCopy = this.number;

        while(true){
            
            String strNumber = numCopy.toString();
            String[] lNum = strNumber.split("");
            for(String num : lNum){
                int iNum = Integer.parseInt(num);
                sum += (iNum * iNum);
            }
            if(sum == 1){
                this.isHappy = true;
                break;
            }
            if(results.contains(sum)){
                this.isHappy = false;
                break;
            }
            results.add(sum);
            numCopy = sum;
            sum = 0;
        }
    }
}
