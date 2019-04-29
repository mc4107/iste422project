# Milestone 5 
###### Refactored Code ReadMe.

#### An Alternate DBMS
In order to alter the program to accept any non **MySql** DBMS, you would need to create another class that extends the *EdgeConvertCreateDLL* class and adheres to the interface, and then choose the new class(or its directory) as the output file definition destination. 

#### Major Bugs & Refactoring

- Improved flexibility for input files via a new abstract class *ConvertFileParser*. This alls the program to cut down on repeated code within EdgeConvertGUI, as well as removing unnescessary global variables local to EdgeConvertFileParser. 
	
	To create a new Input Type
	1. Simply create a new class that extends ConvertFileParser (it must be able to read in a file and parse it into tables and fields)

- Removal and Fix of a program breaking infinite loop. A user would continiously be prompted to choose an output file. 



##### Minor Bugs & Refactoring
- Removal of unused timestamp case within a switch/case block. Added missing default case incase the other options fall through. 

- Removal/Improvment of redudant code within EdgeConvertGUI. 

- Fixed redudancy withing EdgeConvertGUI regarding repeating if statements.











