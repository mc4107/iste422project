import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EdgeConvertCreateDDLTest {
   CreateDDLMySQL testObj;
   EdgeTable targetTable;
   EdgeField targetField;

	@Before
	public void setUp() throws Exception {
      //prepare array of EdgeTable test data
      EdgeTable facTable = new EdgeTable("2|Faculty");
      facTable.makeArrays();  //will get NullPointerExceptions during testing w/o making this method call
      EdgeTable studTable = new EdgeTable("1|Student");
      studTable.makeArrays();
      EdgeTable courseTable = new EdgeTable("13|Courses");
      courseTable.makeArrays();
      EdgeTable[] tables = { studTable, facTable, courseTable };
      targetTable = facTable;
      
      //prepare array of EdgeField test data
      targetField = new EdgeField("5|Number");
      EdgeField[] fields = { new EdgeField("3|Grade"), new EdgeField("4|CourseName"), targetField };
      
      //instantiate test object
      testObj = new CreateDDLMySQL(tables,fields);    //EdgeConvertCreateDDLTest is abstract so must instantiate extending class

      //runner();
	}
	
	public void runner() {
      testGetTable();
      testGetField();
	}

	@Test
	public void testGetTable() {
      //test with a table figure number that exists
      int goodVal = targetTable.getNumFigure();
      assertEquals("The table with a figure number of " + goodVal + " should be returned", targetTable, testObj.getTable(goodVal));
      
      //test with a table figure number that doesn't exist
      int badVal = 3;
		assertEquals("There is no table with a figure number of " + badVal + ", so null should be returned", null, testObj.getTable(badVal));
	}
   
   @Test
   public void testGetField() {
		//test with a field figure number that exists
      int goodVal = targetField.getNumFigure();
      assertEquals("The table with a figure number of " + goodVal + " should be returned", targetField, testObj.getField(goodVal));
      
      //test with a field figure number that doesn't exist
      int badVal = 2;
		assertEquals("There is no table with a figure number of " + badVal + ", so null should be returned", null, testObj.getField(badVal));
	}

}
