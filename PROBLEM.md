### Problem Statement

In the previous assignment 2, we extracted different parts of the query and stored the query parameters/parts in separate classes with properties and methods. 
The classes were given meaningful names like **AggregateFunctions, Restrictions, QueryParameter and QueryParser** based on to the operations they performed.

<br>
In this Assignment 3, we will 

    1. Read the header.  
    2. Identify the Datatype of each field 

**Read the header**
The CSV file contains a set of data, where the first line is header, for example: in our ipl.csv the following are header 
**id, season, city, date, team1, team2, toss_winner, toss_decision, result, dl_applied, winner, win_by_runs, win_by_wickets, player_of_match, venue, umpire1, umpire2, umpire3** 

<br>
**Identify the Datatype of each field**
We cannot identify the data type of the field just by reading the header. We need to read a row which contains actual data.

All the data in the CSV file are in string format. We need to convert the non string data into its respective data type, this is needed because when ever we perform some sort of 
conditional operations we will be in need of the respective data type. 

<br>
For example, the following is the single line data of the CSV file 
**1, 2008, Bangalore, 2008-04-18, Kolkata Knight Riders, Royal Challengers Bangalore, Royal Challengers Bangalore, field, normal, 0, Kolkata Knight Riders, 140, 0, BB McCullum, M Chinnaswamy Stadium, Asad Rauf, RE Koertzen,**

here you can easily find data which is not a string **(for example 2008, 2008-04-18, 140 etc.,).** The numeric data should be converted into integer or double. 

However, for this assignment, we will not try to convert date. It will be addressed in the next assignment.
