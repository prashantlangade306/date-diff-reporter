package com.australiapost.datediffreporter.util;

import java.util.*;

public class DateUtil {

    private final static int MIN_YEAR = 1900;
    private final static int MAX_YEAR = 2020;
    private static Set<String> validDatesSet = new HashSet<String>();

    //Populate all the dates from 1900 till 2020
    static {
        for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= daysInMonth(year, month); day++) {
                    StringBuilder date = new StringBuilder();
                    date.append(String.format("%02d", day));
                    date.append(" ");
                    date.append(String.format("%02d", month));
                    date.append(" ");
                    date.append(String.format("%04d", year));
                    validDatesSet.add(date.toString());
                }
            }
        }
    }

    private static int daysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
            //31 days for 1,3,5,7,8,10 and 12 months.
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;
            case 2:
                //Check for lead year
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                //Except both of the above, default is 30
                daysInMonth = 30;
        }
        return daysInMonth;
    }

    public boolean isValidDate(String date){
        List<String> tokens = getDateTokens(date);
        return validDatesSet.contains(date);
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

    private List<String> getDateTokens(String date) {
        StringTokenizer tokenizer = new StringTokenizer(date, " ");
        List<String> tokens = new ArrayList<String>();

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    public int getDayInMonth(String date){
        List<String> tokens = getDateTokens(date);
        return Integer.valueOf(tokens.get(0));
    }

    public int getMonth(String date){
        List<String> tokens = getDateTokens(date);
        return Integer.valueOf(tokens.get(1));
    }

    public int getYear(String date){
        List<String> tokens = getDateTokens(date);
        return Integer.valueOf(tokens.get(2));
    }
}
