Milestone 01

README
Replace the Courses.edg file within the working example with our simplified Courses.edg file.  This altered file will be used for testing the EdgeCovnertFileParser class.  Place the rest of the files within the working example folder. 
Open terminal and navigate to your working example directory. Once there, type in the following to run the tests.
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar \EdgeConvertFileParserTest.java EdgeConnectorTest.java EdgeConvertCreateDDLTest.java EdgeFieldTest.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar \org.junit.runner.JUnitCore EdgeConvertFileParserTest.java EdgeConnectorTest.java EdgeConvertCreateDDLTest.java EdgeFieldTest.java
