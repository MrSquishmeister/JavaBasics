package com.lee.javabasics.model;

public class CalculatorModel {

    public int calculate(int num1, int num2, char operator){
        return switch (operator) {
            case '/' -> num1 / num2;
            case '*' -> num1 * num2;
            case '-' -> num1 - num2;
            case '+' -> num1 + num2;
            default -> 0;
        };
    }
}
