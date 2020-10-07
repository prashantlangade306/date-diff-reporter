package com.australiapost.datediffreporter.processor;

import com.australiapost.datediffreporter.exception.InvalidDateException;
import com.australiapost.datediffreporter.util.DateUtil;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDateProcessor implements operations {
    DateUtil dateUtil;

    public CustomDateProcessor(){
        dateUtil = new DateUtil();
    }

    public boolean isValidUserInput(String str) {

        Pattern pattern = Pattern.compile("\\d\\d \\d\\d \\d\\d\\d\\d, \\d\\d \\d\\d \\d\\d\\d\\d");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

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

    public boolean isValidDates(String[] dates) throws InvalidDateException {
        for(String date : dates){
            if((!dateUtil.isValidDate(date))){
                return false;
            }
        }
        return true;
    }

    public int calculateDifferenceInDays(String firstDate, String secondDate) {
        int secondDateDay = dateUtil.getDayInMonth(secondDate);
        int firstDateDay = dateUtil.getDayInMonth(firstDate);
        int secondDateYear = dateUtil.getYear(secondDate);
        int firstDateYear = dateUtil.getYear(firstDate);
        int secondDateMonth = dateUtil.getMonth(secondDate);
        int firstDateMonth = dateUtil.getMonth(firstDate);
        return (secondDateDay-32075+1461*(secondDateYear+4800+(secondDateMonth-14)/12)/4
                +367*(secondDateMonth-2-(secondDateMonth-14)/12*12)/12-
                3*((secondDateYear+4900+(secondDateMonth-14)/12)/100)/4)-
                    (firstDateDay-32075+1461*(firstDateYear+4800+(firstDateMonth
                            -14)/12)/4+367*(firstDateMonth-2-(firstDateMonth-14)/12*12)/12
                            -3*((firstDateYear+4900+(firstDateMonth-14)/12)/100)/4);

    }

    public String getDatesInOrder(String firstDate, String secondDate){
        if(dateUtil.isFirstDateGreaterThanSecond(firstDate,secondDate)){
            return secondDate +", "+firstDate;
        } else {
            return firstDate +", "+ secondDate;
        }
    }
}

