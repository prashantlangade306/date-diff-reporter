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
*  Enter a date pair in the acceptable format for e.g. 30 06 1982, 06 10 2020

## License & Copyright
Prashant Langade
