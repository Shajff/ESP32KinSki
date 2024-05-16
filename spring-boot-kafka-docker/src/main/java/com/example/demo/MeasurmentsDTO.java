package com.example.demo;

import java.util.Arrays;

public class MeasurmentsDTO {
    private Integer[] left_ski;
    private Integer[] right_ski;

    public Integer[] getLeft_ski() {
        return left_ski;
    }

    public void setLeft_ski(Integer[] left_ski) {
        this.left_ski = left_ski;
    }

    public Integer[] getRight_ski() {
        return right_ski;
    }

    public void setRight_ski(Integer[] right_ski) {
        this.right_ski = right_ski;
    }

    @Override
    public String toString() {
        return "{" +
                "\"left_ski\":" + Arrays.toString(left_ski) +
                ", \"right_ski\":" + Arrays.toString(right_ski) +
                '}';
    }
}
