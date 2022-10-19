package com.juarodriguezc.api.models;

import java.util.ArrayList;
import java.util.List;

public class NumbersModel {
    private List<HappyNumberModel> numbers = new ArrayList<>();

    public List<HappyNumberModel> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<HappyNumberModel> numbers) {
        this.numbers = numbers;
    }
}
