package com.lee.javabasics.model;

public class NumberGameModel {

    int randomInt = (int)(10.0 * Math.random());

    public String Hint(int numGuess){
        if(numGuess < randomInt){
            return "Guess number too low";
        } else if (numGuess > randomInt) {
            return "Guess number too high";
        } else {
            return "You guessed right it was " + randomInt;
        }
    }
}
