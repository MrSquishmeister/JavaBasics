package com.lee.javabasics.model;

public class BankModel {
    public int Login(int userID, int userPin){
        if(userID == 123 && userPin == 123){
            return 500;
        }
        return 0;
    }
}
