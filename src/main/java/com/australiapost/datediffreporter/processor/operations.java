package com.australiapost.datediffreporter.processor;

public interface operations {
    boolean isValidUserInput(String str);
    String[] splitDates(String str);
    int calculateDifferenceInDays(String firstDate, String secondDate);
}
