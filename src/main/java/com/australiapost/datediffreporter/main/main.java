package com.australiapost.datediffreporter.main;

import com.australiapost.datediffreporter.exception.InvalidDateException;
import com.australiapost.datediffreporter.exception.InvalidUserInputException;
import com.australiapost.datediffreporter.processor.CustomDateProcessor;
import com.australiapost.datediffreporter.processor.DateDiffReporter;

import java.util.Scanner;

public class main {
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
            e.printStackTrace();
        } catch (InvalidUserInputException e) {
            e.printStackTrace();
        }
    }
}
