package com.australiapost.datediffreporter.processor;

import com.australiapost.datediffreporter.exception.InvalidDateException;

public interface Operations {
    boolean isValidUserInput(String str);
    String[] splitDates(String str);
    boolean isValidDates(String[] dates) throws InvalidDateException;
    int calculateDifferenceInDays(String firstDate, String secondDate);

}
