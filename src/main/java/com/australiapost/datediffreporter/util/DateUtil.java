package com.australiapost.datediffreporter.util;

import java.util.*;

/**
 * This class performs different operations such as
 * 1. Population of entire date (day month year in dd mm yyyy format) from 1900 till 2020
 * 2. Finds the total number of days for a month and year.
 * 3. Checks if a date is a valid date
 * 4. Checks if the first date is greater than second date.
 * 5. Tokenize the passed in user input in the form of dd mm yyyy
 * 6. Returns day in a month, month and year from entire date string (Via separate methods)
 *
 */
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

    /**
     * Returns the days for a month and year.
     *
     * @param year
     * @param month
     * @return
     */
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

    /**
     * Checks if the date is a valid date.
     *
     * @param date
     * @return
     */
    public boolean isValidDate(String date){
        List<String> tokens = getDateTokens(date);
        return validDatesSet.contains(date);
    }

    /**
     * Checks if the first date is greater than the second.
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
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

    /**
     * Tokenizes the dates in day, month and year.
     *
     * @param date
     * @return
     */
    private List<String> getDateTokens(String date) {
        StringTokenizer tokenizer = new StringTokenizer(date, " ");
        List<String> tokens = new ArrayList<String>();

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }

    /**
     * Retrieves a day of a month from the date token.
     *
     * @param date
     * @return
     */
    public int getDayInMonth(String date){
        List<String> tokens = getDateTokens(date);
        return Integer.valueOf(tokens.get(0));
    }

    /**
     * Retrieves a month from the date token.
     *
     * @param date
     * @return
     */
    public int getMonth(String date){
        List<String> tokens = getDateTokens(date);
        return Integer.valueOf(tokens.get(1));
    }

    /**
     * Retrieves a year from the date token.
     *
     * @param date
     * @return
     */
    public int getYear(String date){
        List<String> tokens = getDateTokens(date);
        return Integer.valueOf(tokens.get(2));
    }
}
