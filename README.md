# date-diff-reporter - Coding assignment for Australia Post

This is an application that displays date difference in days for the supplied user input in the form of date pairs.


## Table of contents
* [General Info](#general-Info)
* [Technologies](#technologies)
* [Code](#code)
* [How it works?](#how-it-works)
* [License and Copyright](#license-and-copyright)

## General Info
This application reads user input in the form of pair of dates in the following format: 
DD MM YYYY, DD MM YYYY

It validates the input data according to the supplied format and computes the difference in days between the two supplied dates.
The output of the application is in the below form 'DD MM YYYY, DD MM YYYY, difference' 

where 
* first date is the earliest
* second date is the latest 
* difference is the number of days

<b>Note:</b> User input is received from standard input.

## Technologies
The application is developed using Java technology and tools such as Junit(testcases), Maven(build tool) and Intellij (IDE).

## Code
*  This is a maven based project which has junit dependency for unit testing.
*  Below is the code structure.
   src/main/java/com/australiapost/datediffreporter/Main.java
   
   src/main/java/com/australiapost/datediffreporter/exception/InvalidDateException.java
   
   src/main/java/com/australiapost/datediffreporter/exception/InvalidUserInputException.java
   
   src/main/java/com/australiapost/datediffreporter/processor/CustomDateProcessor.java
   
   src/main/java/com/australiapost/datediffreporter/processor/DateDiffReporter.java
   
   src/main/java/com/australiapost/datediffreporter/processor/Operations.java
   
   src/main/java/com/australiapost/datediffreporter/util/DateUtil.java
   
   src/test/java/DateDiffReporterTests.java
   
   * src/main/java/com/australiapost/datediffreporter/exception/InvalidDateException.java:
      This class is used to handle invalid date exception in case when the user supplied input has year out of range 1900 - 2020 or invalid date.
      
   * src/main/java/com/australiapost/datediffreporter/exception/InvalidUserInputException.java:
      This class is used to handle invalid user input in case when the user supplied input does not confirm to the expected format 'DD MM YYYY, DD MM YYYY'
      
   *  src/main/java/com/australiapost/datediffreporter/processor/CustomDateProcessor.java:
      This class does below operations.
      
      * Validates the user input in the specified format
      * Splits the user input in two separate dates.
      * Validates if the dates supplied are valid (i.e. between 1900 and 2020)
      * Calculates the date difference in days.
      * Orders the date (early first followed by latest)
   
   *  src/main/java/com/australiapost/datediffreporter/processor/DateDiffReporter.java: 
      This class does all the business logic processing by interacting with CustomDateProcessor class and returns final output to Main class.
      
   *  src/main/java/com/australiapost/datediffreporter/processor/Operations.java:
      This is an interface that defines the contract for implementing class CustomDateProcessor
      
      * boolean isValidUserInput(String str);
      * String[] splitDates(String str);
      * boolean isValidDates(String[] dates) throws InvalidDateException;
      * int calculateDifferenceInDays(String firstDate, String secondDate);
      
    * src/main/java/com/australiapost/datediffreporter/util/DateUtil.java:
      This class is an utility class for custom date manipulation that takes care of the following processing.
      
      * Population of entire date (day month year in dd mm yyyy format) from 1900 till 2020
      * Finds the total number of days for a month and year.
      * Checks if a date is a valid date
      * Checks if the first date is greater than second date.
      * Tokenize the passed in user input in the form of dd mm yyyy
      * Returns days in a month, month and year from entire date string (Via separate methods)
      
    * src/test/java/DateDiffReporterTests.java:
      This class is a unit test suite that covers following test cases to ensure full coverage of the business functionality.
      
       * Tests if the InvalidUserInputException is thrown by the code for any invalid user input.
       * Tests if the InvalidDateException is thrown by the code for any invalid date passed (i.e. wrong day, month or year).
       * Tests if the passed in dates in the form of 'DD MM YYYY, DD MM YYYY' is split in proper format.
       * Tests if the isValidDate method returns false for any invalid date passed (i.e. wrong day, month or year).
       * Tests if the code returns proper formatted output i.e. earliest date, latest date, number of days as a date difference for the dates passed.
       * Tests if the code returns dates in a proper order i.e. earliest followed by latest.
       * Tests if the code returns proper number of days as a date difference for the dates passed.

## How it works?

*  Entire codebase is available at https://github.com/prashantlangade306/date-diff-reporter (Master Branch)
*  Open src/main/java/com/australiapost/datediffreporter/main.java which is the entry point of the application and run it. It shows below message.


   "Please enter two dates in format 'DD MM YYYY, DD MM YYYY' to find number of days between them."
*  In the standard input, enter a date pair in the acceptable format for e.g. 30 06 1982, 06 10 2020
*  The supplied date pair will be validated first to ensure the user input is in acceptable format. If the validation fails, an error message will be shown
   as "Please enter datepair in the format as DD 'MM YYYY, DD MM YYYY'"
*  Post successful date format validation, the user input is split into two separate dates.
*  Next individual date is further validated to ensure it is indeed a valid date (i.e. combination of day, month and year). If either of the date is invalid,
   an error message will be shown as "Please enter a valid date. Only years 1900-2020 are supported."
*  Post successful date validation, date difference in days is calculated between earlier and latest date.
*  Finally, the two dates are compared and are re-arranged in ascending order i.e. earlier followed by latest and appended with the number of days difference.
   in format e.g. '01 01 1900, 31 12 2020, 44194'

## License & Copyright
Prashant Langade
