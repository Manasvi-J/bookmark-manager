package com.webapp.service;

import lombok.var;
import org.springframework.stereotype.Service;

@Service
public class HashingService {

    private static final String allowedVals = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowedChars = allowedVals.toCharArray();
    private int base = allowedChars.length;

    public String encode(long input){
        var shortLink = new StringBuilder();

        if(input == 0) {
            return String.valueOf(allowedChars[0]);
        }

        while (input > 0) {
            shortLink.append(allowedChars[(int) (input % base)]);
            input = input / base;
        }

        return shortLink.reverse().toString();
    }

    /*public long decode(String input) {
        var characters = input.toCharArray();
        var length = characters.length;

        var id = 0;

        var counter = 1;
        for (int i = 0; i < length; i++) {
            id += allowedVals.indexOf(characters[i]) * Math.pow(base, length - counter);
            counter++;
        }
        return id;
    }*/
}