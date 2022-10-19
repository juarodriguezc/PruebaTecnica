package com.juarodriguezc.api.models;

public class SummationModel {
    private int result;


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void calcSummation(int number){
        int sum = 0;
        for(int i = 0; i <= number; i++){
            sum += i;
        }
        this.result = sum;
    }
}
