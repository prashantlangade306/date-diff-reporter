package com.australiapost.datediffreporter.processor;

import com.australiapost.datediffreporter.exception.InvalidDateException;
import com.australiapost.datediffreporter.exception.InvalidUserInputException;

public class DateDiffReporter {
    private String userInput;
    private CustomDateProcessor customDateProcessor;

    public DateDiffReporter(String userInput, CustomDateProcessor customDateProcessor){
        this.userInput = userInput;
        this.customDateProcessor = customDateProcessor;
    }

    public String calculateDiffInDays() throws InvalidDateException, InvalidUserInputException {
        //Check if the format is fine
        if(!customDateProcessor.isValidUserInput(userInput))
            throw new InvalidUserInputException("Please enter datepair in the format as DD 'MM YYYY, DD MM YYYY'");

        //Split dates
        String[] dates = customDateProcessor.splitDates(userInput);

        //Validate dates
        if(!customDateProcessor.isValidDates(dates)) throw new InvalidDateException("Invalid Date..");

        //Calculate the difference in days.
        int days = customDateProcessor.calculateDifferenceInDays(dates[0], dates[1]);

        String finalOutput = getFormattedOutput(dates[0], dates[1]) + ", "+days;

        return finalOutput;
    }

    public String getFormattedOutput(String firstDate, String secondDate){
        return customDateProcessor.getDatesInOrder(firstDate, secondDate);
    }
}
