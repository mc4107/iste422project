# Milestone 5
###### Refactored Code ReadMe.

#### To Run
To run the EdgeConvert application, navigate to where the EdgeConvert.jar file is stored using either a command line or graphical interface.
If graphical, simply double click the jar file and the program GUI will appear.
If using the command line, execute the following command:
		java -jar EdgeConvert.jar

#### An Alternate DBMS
To alter the program to accept any non **MySql** DBMS, you would need to create another class that extends the *EdgeConvertCreateDLL* class, implementing its abstract methods.  Compile the class.  Then, when running the application, choose the directory that the compiled code is in as the output file definition destination.  Select the new DBMS name from the dropdown when prompted to do so while creating a DDL.

#### An Alternate Input Format
To enable the program to accept different input formats, a class must be written that extends *ConvertFileParser*, implementing the parseFile method, which will read the input file, parsing it according to the new format and storing data in an ArrayList of EdgeTables and an ArrayList of EdgeFields.  Slight changes should then be made to the EdgeMenuListener within *EdgeConvertGUI* to parse a user-selected input file using the new ConvertFileParser subclass.

#### Major Bugs & Refactoring
- Improved flexibility for input file format via a new abstract class *ConvertFileParser*.  Broke up the code within *EdgeConvertFileParser* into two classes that extend *ConvertFileParser* (one to parse .edg files, one for .sav files).  Simplified EdgeMenuListener in *EdgeConvertGUI* by eliminating a chunk of repeated code while revising to work with the abstract class and its children.

- Fix of a program-stalling infinite loop by removing a while loop and avoiding assuming that the user picks a file when prompted to choose an output file.

#### Minor Bugs & Refactoring
- Removal of unused timestamp case within a switch/case block. Added default case as a good coding practice.

- Cut down redundant code and unnecessary method calls within the EdgeMenuListener of *EdgeConvertGUI*.

- Made a lot of unnecessarily global variable local in *EdgeConvertFileParser* and avoided unnecessarily storing values
