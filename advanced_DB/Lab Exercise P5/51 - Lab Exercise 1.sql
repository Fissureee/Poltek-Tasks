---------------------------------------------------------------------
-- LAB 07
--
-- Exercise 1
---------------------------------------------------------------------

USE TSQL;
GO

---------------------------------------------------------------------
-- Task 1
-- 
-- 
-- Open the project file F:\10774A_Labs\10774A_07_PRJ\10774A_07_PRJ.ssmssln and the T-SQL script 51 - Lab Exercise 1.sql. To set your database context to that of the TSQL2012 database, highlight the statement USE TSQL2012; and execute the highlighted code. After executing this statement, the TSQL2012 database should be selected in the Available Databases box. In subsequent exercises, you will simply be instructed to ensure that you are connected to the TSQL2012 database.
--
-- Write a SELECT statement to return columns that contain:
--  The current date and time. Use the alias currentdatetime.
--  Just the current date. Use the alias currentdate.
--  Just the current time. Use the alias currenttime.
--  Just the current year. Use the alias currentyear.
--  Just the current month number. Use the alias currentmonth.
--  Just the current day of month number. Use the alias currentday.
--  Just the current week number in the year. Use the alias currentweeknumber.
--  The name of the current month based on the currentdatetime column. Use the alias currentmonthname.
-- 
-- Execute the written statement and compare the results that you got with the desired results shown in the file 52 - Lab Exercise 1 - Task 1 Result.txt. Your results will be different because of the current date and time value.
--
-- Can you use the alias currentdatetime as the source in the second column calculation (currentdate)? Please explain.
---------------------------------------------------------------------
SELECT
    GETDATE() AS currentdatetime,
    CONVERT(TIME, GETDATE()) AS currenttime,
    YEAR(GETDATE()) AS currentyear,
    MONTH(GETDATE()) AS currentmonth,
    DAY(GETDATE()) AS currentday,
    DATEPART(WEEK, GETDATE()) AS currentweeknumber,
    FORMAT(GETDATE(), 'MMMM') AS currentmonthname

-- Yes we can, by using the currentdatetime as the source for the calculation currentdate by using a subquery
FROM
(
    SELECT GETDATE() AS currentdatetime
) AS DateTimeAlias;


---------------------------------------------------------------------
-- Task 2
--  
-- Write December 11, 2011, as a column with a data type of date. Use the different possibilities inside the T-SQL language (cast, convert, specific function, etc.) and use the alias somedate.
---------------------------------------------------------------------
SELECT '2011-12-11' AS somedate;
SELECT CONVERT(DATE, '2011-12-11', 126) AS somedate;
SELECT DATEFROMPARTS(2011, 12, 11) AS somedate;
SELECT PARSE('2011-12-11' AS DATE) AS somedate;


---------------------------------------------------------------------
-- Task 3
-- 
-- Write a SELECT statement to return columns that contain:
--  Three months from the current date and time. Use the alias threemonths.
--  Number of days between the current date and the first column (threemonths). Use the alias diffdays.
--  Number of weeks between April 4, 1992, and September 16, 2011. Use the alias diffweeks.
--  First day in the current month based on the current date and time. Use the alias firstday.
--
-- Execute the written statement and compare the results that you got with the desired results shown in the file 53 - Lab Exercise 1 - Task 3 Result.txt. Some results will be different because of the current date and time value.
---------------------------------------------------------------------
SELECT
    DATEADD(MONTH, 3, GETDATE()) AS threemonths,
    DATEDIFF(DAY, GETDATE(), DATEADD(MONTH, 3, GETDATE())) AS diffdays,
    DATEDIFF(WEEK, '1992-04-04', '2011-09-16') AS diffweeks,
    DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0) AS firstday;


---------------------------------------------------------------------
-- Task 4
-- 
-- The IT department has written a T-SQL statement that creates and populates a table named Sales.Somedates. 
--
-- Execute the provided T-SQL statement.
-- 
-- Write a SELECT statement against the Sales.Somedates table and retrieve the isitdate column. Add a new column named converteddate with a new date data type value based on the column isitdate. If the column isitdate cannot be converted to a date data type for a specific row, then return a NULL. 
--
-- Execute the written statement and compare the results that you got with the desired results shown in the file 54 - Lab Exercise 1 - Task 4 Result.txt. 
-- 
-- What is the difference between the SYSDATETIME and CURRENT_TIMESTAMP functions?
--
-- What is a language-neutral format for the DATE type?
---------------------------------------------------------------------

SET NOCOUNT ON;

IF OBJECT_ID('Sales.Somedates') IS NOT NULL 
	DROP TABLE Sales.Somedates;

CREATE TABLE Sales.Somedates (
	isitdate varchar(9)
);

INSERT INTO Sales.Somedates (isitdate) VALUES 
	('20110101'),
	('20110102'),
	('20110103X'),
	('20110104'),
	('20110105'),
	('20110106'),
	('20110107Y'),
	('20110108');

SET NOCOUNT OFF;

SELECT isitdate
FROM Sales.Somedates;


SELECT
    isitdate,
    CASE
        WHEN ISDATE(isitdate) = 1 THEN CONVERT(DATE, isitdate, 112)
        ELSE NULL
    END AS converteddate
FROM Sales.Somedates;
--1. The difference between SYSDATETIME and CURRENT_TIMESTAMP is that SYSDATETIME returns a DATETIME2 value with a higher precision, including fractional seconds, while CURRENT_TIMESTAMP returns a DATETIME value with a lower precision, rounded to the nearest one-three-hundredth of a second.
--2. A language-neutral format for the DATE type is the ISO 8601 date format, which is YYYY-MM-DD. It's a widely accepted and unambiguous date format that is not affected by regional or language settings.




---------------------------------------------------------------------
-- Task 5
-- 
-- copy-paste text about lab from doc file
---------------------------------------------------------------------
-- drop the table 

DROP TABLE Sales.Somedates;