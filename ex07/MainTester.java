import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;  //for Scanner & ArrayList
import java.io.*;    //for File & IOExceptions

/**
 * Tests EdgeConnector and EdgeField classes using data provided by user
 * @author Team NeedsMoreMembers
 * @version 4/5/19
 */
public class MainTester{
   
   /**
    * Validates args and creates test objects based on them
    * @param args    command line arguments
    */
   public static void main(String[] args){
      ArrayList testObjs = new ArrayList<Object>();
      
      //if no args, add defaults to list
      if(args.length == 0){
         testObjs.add(new EdgeField("1|Name"));
         testObjs.add(new EdgeConnector("1|2|3|testStyle1|testStyle2"));
      }
      //if -h, print help msg
      else if(args[0].equals("-h")){
         printHelpMsg();
      }
      //if -n, try to use following arg as test obj
      else if(args[0].equals("-n")){
         //if not enough args, error & exit
         if(args.length != 2){
            printInvalidMsg("This option must be followed by a test object.");
         }
       
         //try to create a EdgeConnector or EdgeField from arg
         Object testObj = createTestObj(args[1]);
         if(testObj == null){
            printInvalidMsg("The test string must have either 2 or 4 attribute values.");
         }
         testObjs.add(testObj);
      }
      //if -f, try to read test objs from file
      else if(args[0].equals("-f")){
         //if not enough args, error & exit
         if(args.length != 2){
            printInvalidMsg("This option must be followed by a file name.");
         }
         
         //read test strings from file
         try{
            Scanner in = new Scanner(new File(args[1]));
            //for each line, try to create EdgeConnector or EdgeField
            while(in.hasNextLine()){
               Object testObj = createTestObj(in.nextLine());
               if(testObj != null){
                  testObjs.add(testObj);
               }
            }
            in.close();
         }
         catch(FileNotFoundException fnfe){
            System.out.println("Specified file not found");
         }
         
      }
      //if invalid arguments, error & exit
      else{
         printInvalidMsg("Include the option -h to see what arguments are accepted.");
      }
      
      //pass test objects to constructor
      new MainTester(testObjs);
   }
   
   /**
    * Loops through test objects to test each
    * @param testObjs   ArrayList of objects to test
    */
   public MainTester(ArrayList<Object> testObjs){
      for(Object anObj : testObjs){
         if(anObj instanceof EdgeConnector){
            System.out.println("Now testing EdgeConnector: " + getConnectorStr((EdgeConnector)anObj));

            //Construct the new EdgeConnectorTest
            //TODO
            
            JUnitCore junit = new JUnitCore();
            Result result = junit.run(EdgeConnectorTest.class);
            
            for (Failure failure : result.getFailures()){
               System.out.println(failure.toString());
            }
            
            System.out.println(result.wasSuccessful());

         }
         else{
            System.out.println("Now testing EdgeField: " + ((EdgeField)anObj).toString());

            //Construct the new EdgeFieldTest
            EdgeFieldTest EFTest = new EdgeFieldTest();

            //Call the tester
            EFTest.prepare((EdgeField)anObj);

            //Run the tests
            EFTest.runner();
         }
      }
   }
   
   /**
    * Returns summary of EdgeConnector attributes
    * @param obj  EdgeConnector
    * @return summary of EdgeConnector attributes
    */
   private String getConnectorStr(EdgeConnector obj){
      return obj.getNumConnector() + EdgeConvertFileParser.DELIM
           + obj.getEndPoint1() + EdgeConvertFileParser.DELIM
           + obj.getEndPoint2() + EdgeConvertFileParser.DELIM
           + obj.getEndStyle1() + EdgeConvertFileParser.DELIM
           + obj.getEndStyle2();
   }
   
   /**
    * Prints a help message & exits
    */
   private static void printHelpMsg(){
      System.out.println("Tester command line options:"
                           + "\n\t-n\t\tfollowed by a test object string argument for program to use to test"
                           + "\n\t-f\t\tfollowed by a file name argument for a file that contains test object strings for program to test with");
      System.exit(0);                 
   }
   
   /**
    * Prints invalid argument msg & exits
    */
   private static void printInvalidMsg(String details){
      System.out.println("Arguments are invalid.  " + details);
      System.exit(0);
   }
   
   /**
    * Tries to create a test object from a String of obj attributes
    * @param testObjStr    String of comma-separated attributes for test object
    * @return the test object created or null if String was invalid
    */
   private static Object createTestObj(String testObjStr){
      int attrCount = testObjStr.split(",").length;
      switch(attrCount){
         case 2:  return new EdgeField(testObjStr.replaceAll(",",EdgeConvertFileParser.DELIM));
         case 5:  return new EdgeConnector(testObjStr.replaceAll(",",EdgeConvertFileParser.DELIM));
         default: return null;
       }
   }
   
}  //end MainTester class