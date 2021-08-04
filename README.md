# MonthlySlip
A program that generates a monthly payment slip from the entered data. The source code and an executable will be provided. A version with encapsulation and working aws would be provided if they are completed.

<br /> Assumptions made:
1. Names must only be letters and hyphens
2. Slips are generated for the entirety of the month
3. Super rate is a double. 
4. Users may want to create multiple CSVs.
5. The user may want information at the end for clarity.

<br /> There are multiple versions of the program. One is an executable, one is java with a singular class (MonthlySlipSimple), one with encapsulation (MonthlySlip) and an AWS version. 

<br />Instructions on how to use the program:
1. Execute the program
2. Follow the prompts
3. A cvs would be generated in the end
4. type the character y to continue generating more cvs
5. type anything else without including the character y to terminate the program

<br /> Instructions to run the executable:
1. Download the entire package
2. Go into MonthlySlipExecutable file
3. Double click on the MonthlySlip.bat if you cannot execute the .Jar file

<br /> Note: MonthlySlip version. Instructions to run the src file (MonthlySlipSimple/MonthlySlip):
1. Download the entire package, a terminal can be used to download package or click code (green button) then download zip.
2. Open your IDE of choice
3. Extract MonthlySlipSimple into source root (optional)
4. Click file
5. Click open
6. Navigate to EmployeeMonthlySlipSimple folder
7. Then go from src>main>java>EmployeeMonthlySlipSimple
8. Some IDEs would require to build project and select Java version
9. Use the run function on the IDE (Some IDEs may require additional configurations)

<br /> Instructions to run aws version:
1. Would be a different repository
2. A link would be provided if working


<br /> Notes:
1. Made with eclipse and IntelliJ using Java version 16 and 11 depending on which file.
2. The aws version is not working at the moment, currently trying to aws and spring. Currently stuck on pipeline phase, source > build working but not deploy.
3. The executable version is running on old code. 
4. If the user wants to store data into a database, JSON can be an option.
5. A GUI with labels, text fields and buttons could be added to give users an easier time to enter data.
6. There are many ways to go with the dates, users can type monday, mon, 04/05, 5th of may, 23 APRIL 2020; asking the user to type month to generate the slip for entire month was done for simplicity.
7. Payment period can use dates considering leap years with java.util.Date. A prompt could also be made to ask the day, the month, then the year for start date and end date.
8. "Full Name:", "Income Tax:" and so forth was added for user clarity.
9. Encapsulation can be used for each individual field then call for every data at the end with Employee e1 = new Employee() for JSON could be added. A single class was used due to time constraints. 
10. If the user wish to type '%9' for super rate, the program could include superRate.replace("%","") then parse the string into a double.
11. Loops for incorrect inputs was added to stop the program to terminate itself if a user put the wrong data type into a field. The loops were also made to let users to continue entering data till completion.

### <br />*Please contact me if there is any trouble on running the code. Thank you for the opportunity and take care!*

