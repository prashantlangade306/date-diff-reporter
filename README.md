# date-diff-reporter - Coding assignment for Australia Post

This is a application that displays date difference in days for the supplied user input in the form of date pairs.


## Table of contents
* [General Info](#general-Info)
* [Technologies](#technologies)
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
