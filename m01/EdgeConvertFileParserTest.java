import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class EdgeConvertFileParserTest{
   EdgeConvertFileParser testObj;
   
   File constructorFile = new File("Courses.edg");
  
   @Before
   public void setUp() throws Exception{
      testObj = new EdgeConvertFileParser(constructorFile);
      runner();
   }
   
   public void runner(){
      testGetEdgeFields();
      testGetEdgeFields2();
      testGetEdgeTables();
      testGetEdgeTables2();
   }
   
   @Test
   public void testGetEdgeTables(){
      assertNotNull("Expected not Null", testObj.getEdgeTables());
   }
    
   @Test
   public void testGetEdgeTables2(){
      assertArrayEquals("Expected 0", new EdgeTable[0], testObj.getEdgeTables());
   }
    
   @Test
   public void testGetEdgeFields(){
      assertNotNull("Expected not Null", testObj.getEdgeFields());
   }
   
   @Test
   public void testGetEdgeFields2(){
      assertArrayEquals("Expected 0",  new EdgeField[0], testObj.getEdgeFields());
   }           
}