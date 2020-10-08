package com.australiapost.datediffreporter;

import com.australiapost.datediffreporter.exception.InvalidDateException;
import com.australiapost.datediffreporter.exception.InvalidUserInputException;
import com.australiapost.datediffreporter.processor.CustomDateProcessor;
import com.australiapost.datediffreporter.processor.DateDiffReporter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter two dates in format 'DD MM YYYY, DD MM YYYY' to find number of days between them.");
        Scanner reader = new Scanner(System.in);
        String datePair = reader.nextLine();

        CustomDateProcessor customDateProcessor = new CustomDateProcessor();
        DateDiffReporter dateDiffReporter = new DateDiffReporter(datePair,customDateProcessor);
        try {
            String formattedOutput = dateDiffReporter.calculateDiffInDays();
            System.out.println(formattedOutput);
        } catch (InvalidDateException e) {
            //Not a good practice, Ideally should print entire stacktrace to help locate the exact failure.
            System.out.println("Please enter a valid date. Only years 1900-2020 are supported.");
        } catch (InvalidUserInputException e) {
            //Not a good practice, Ideally should print entire stacktrace to help locate the exact failure.
            System.out.println("Please enter datepair in the format as DD 'MM YYYY, DD MM YYYY'");
        }
    }
}
