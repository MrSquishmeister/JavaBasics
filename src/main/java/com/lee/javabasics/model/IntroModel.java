package com.lee.javabasics.model;

public class IntroModel {
    public String Reverse (String str) {
        String reversedStr = "";
        for(int i = str.length()-1; i >= 0; i--){
            reversedStr = reversedStr + str.charAt(i);
        }
        return reversedStr;
    }
}
