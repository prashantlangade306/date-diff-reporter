package com.australiapost.datediffreporter.processor;

import com.australiapost.datediffreporter.exception.InvalidDateException;
import com.australiapost.datediffreporter.util.DateUtil;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class performs different operations such as
 * 1. Validates the user input in the specified format
 * 2. Splits the user input in two separate dates.
 * 3. Validates if the dates supplied are valid (i.e. between 1900 and 2020)
 * 4. Calculates the date difference in days.
 * 5. Orders the date (early first followed by latest)
 *
 */
public class CustomDateProcessor implements Operations {
    DateUtil dateUtil;

    public CustomDateProcessor(){
        dateUtil = new DateUtil();
    }

    /**
     * Checks if the user inout is valid or not.
     *
     * @param str
     * @return
     */
    public boolean isValidUserInput(String str) {

        Pattern pattern = Pattern.compile("\\d\\d \\d\\d \\d\\d\\d\\d, \\d\\d \\d\\d \\d\\d\\d\\d");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * Splits the user input into two separate dates.
     *
     * @param str
     * @return
     */
    public String[] splitDates(String str) {

        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        String[] tokens = new String[2];
        int count = 0;
        while (tokenizer.hasMoreElements()) {
            tokens[count] = tokenizer.nextToken().trim();
            count++;
        }
        return tokens;
    }

    /**
     * Checks if the dates are valid.
     *
     * @param dates
     * @return
     * @throws InvalidDateException
     */
    public boolean isValidDates(String[] dates) throws InvalidDateException {
        for(String date : dates){
            if((!dateUtil.isValidDate(date))){
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the difference in days between two dates.
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
    public int calculateDifferenceInDays(String firstDate, String secondDate) {
        int secondDateDay = dateUtil.getDayInMonth(secondDate);
        int firstDateDay = dateUtil.getDayInMonth(firstDate);
        int secondDateYear = dateUtil.getYear(secondDate);
        int firstDateYear = dateUtil.getYear(firstDate);
        int secondDateMonth = dateUtil.getMonth(secondDate);
        int firstDateMonth = dateUtil.getMonth(firstDate);
        return Math.abs((secondDateDay-32075+1461*(secondDateYear+4800+(secondDateMonth-14)/12)/4
                +367*(secondDateMonth-2-(secondDateMonth-14)/12*12)/12-
                3*((secondDateYear+4900+(secondDateMonth-14)/12)/100)/4)-
                    (firstDateDay-32075+1461*(firstDateYear+4800+(firstDateMonth
                            -14)/12)/4+367*(firstDateMonth-2-(firstDateMonth-14)/12*12)/12
                            -3*((firstDateYear+4900+(firstDateMonth-14)/12)/100)/4));

    }

    /**
     * Orders the date in a particular format (earliest followed by latest)
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
    public String getDatesInOrder(String firstDate, String secondDate){
        StringBuilder dateBuilder = new StringBuilder();
        if(dateUtil.isFirstDateGreaterThanSecond(firstDate,secondDate)){
            dateBuilder.append(secondDate).append(", ").append(firstDate);
        } else {
            dateBuilder.append(firstDate).append(", ").append(secondDate);
        }
        return dateBuilder.toString();
    }
}

