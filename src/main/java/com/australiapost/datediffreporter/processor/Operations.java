package com.australiapost.datediffreporter.processor;

public interface Operations {
    boolean isValidUserInput(String str);
    String[] splitDates(String str);
    int calculateDifferenceInDays(String firstDate, String secondDate);
}
