In order to run the tests, you must drag our edited files (MainTester.java, EdgeConnectorTest.java, EdgeFieldTest.java) to the project Source Code folder. You must compile and run the files from the directory that they are in.

Compile the classes with the command, javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java

Run the tests with the following commmands, 
	Text File, java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar MainTester -f
	Object, java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar MainTester -n "1,Name"
	Help Menu, java -cp .:hamcrest-core-1.3.jar:junit-4.12.jar MainTester -h
