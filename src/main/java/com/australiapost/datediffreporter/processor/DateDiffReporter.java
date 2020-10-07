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
        //Check if the user input is valid
        if(!customDateProcessor.isValidUserInput(userInput)) throw new InvalidUserInputException("Please enter datepair in the format as DD 'MM YYYY, DD MM YYYY'");

        //Split the dates
        String[] dates = customDateProcessor.splitDates(userInput);

        //Validate the dates
        if(!customDateProcessor.isValidDates(dates)) throw new InvalidDateException("Please enter a valid date. Only years 1900-2020 are supported.");

        //Calculate the difference in days.
        int days = customDateProcessor.calculateDifferenceInDays(dates[0], dates[1]);

        //Format the input in the required format
        String finalOutput = getFormattedOutput(dates[0], dates[1]) + ", "+days;

        return finalOutput;
    }

    public String getFormattedOutput(String firstDate, String secondDate){
        return customDateProcessor.getDatesInOrder(firstDate, secondDate);
    }
}
