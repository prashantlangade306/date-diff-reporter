package com.australiapost.datediffreporter.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DateUtil {

    private final static int MIN_YEAR = 1900;
    private final static int MAX_YEAR = 2020;
    private final static int MIN_MONTH = 1;
    private final static int MAX_MONTH = 12;
    private final static int DAYS_IN_MONTH = 31; //Assumming month of 31 days

    public boolean isValidDay(String daysInMonth){
        return Integer.valueOf(daysInMonth) <= DAYS_IN_MONTH;
    }

    public boolean isValidMonth(String month){
        int intMonth = Integer.valueOf(month);
        return intMonth >= MIN_MONTH && intMonth <= MAX_MONTH;
    }

    public boolean isValidYear(String year){
        int intYear = Integer.valueOf(year);
        return intYear >= MIN_YEAR && intYear <= MAX_YEAR;
    }

    public boolean isValidDate(String date){
        StringTokenizer tokenizer = new StringTokenizer(date, " ");
        List<String> tokens = new ArrayList<String>();

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        String dayInMonth = tokens.get(0);
        String monthInYear = tokens.get(1);
        String year = tokens.get(2);

        return isValidDay(dayInMonth) && isValidMonth(monthInYear) && isValidYear(year);
    }

    public int getDayInMonth(String date){
        StringTokenizer tokenizer = new StringTokenizer(date, " ");
        List<String> tokens = new ArrayList<String>();

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        return Integer.valueOf(tokens.get(0));
    }

    public boolean isFirstDateGreaterThanSecond(String firstDate, String secondDate){
        //First check year
        int firstYear = getYear(firstDate);
        int secondYear = getYear(secondDate);
        if(firstYear > secondYear){
            return true;
        } else if(firstYear == secondYear){
            //Check for month
            int firstMonth = getMonth(firstDate);
            int secondMonth = getMonth(secondDate);
            if(firstMonth > secondMonth){
                return true;
            }

            if(firstMonth == secondMonth){
                int firstDay = getDayInMonth(firstDate);
                int secondDay = getDayInMonth(secondDate);
                if(firstDay > secondDay){
                    return true;
                }
            }
        }
        return false;
    }

    public int getMonth(String date){
        StringTokenizer tokenizer = new StringTokenizer(date, " ");
        List<String> tokens = new ArrayList<String>();

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        return Integer.valueOf(tokens.get(1));
    }
    public int getYear(String date){
        StringTokenizer tokenizer = new StringTokenizer(date, " ");
        List<String> tokens = new ArrayList<String>();

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        return Integer.valueOf(tokens.get(2));
    }
}
