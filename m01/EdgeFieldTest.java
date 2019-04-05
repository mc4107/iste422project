import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

@RunWith(Parameterized.class)
public class EdgeFieldTest {
   EdgeField testField;

	@Before
	public void setUp() throws Exception {
      testField = new EdgeField("1|Name");
      runner();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data(EdgeField EF){

		EdgeFieldTest E = new EdgeFieldTest(EF);

		return null;
	}

	/**
	 * Constructor for test fixture
	 * @param obj - the EdgeField to be tested
	 */
	public EdgeFieldTest(EdgeField obj){

		//Set the private field to be the input object
		this.testField = obj;
	}
	
	public void runner() {
      //test accessors
      testGetNumFigure();
      testGetName();
      testGetTableID(); 
      testGetTableBound();
      testGetFieldBound();
      testGetDisallowNull();
      testGetIsPrimaryKey();
      testGetDefaultValue();
      testGetVarcharValue();
      testGetDataType();
      testGetStrDataType();
	 
      //test mutators
      testSetTableID();
   	  testSetTableBound();
   	  testSetFieldBound();
   	  testSetDisallowNull();
      testSetIsPrimaryKey();
   	  testSetDefaultValue();
   	  testSetVarcharValue();
   	  testSetDataType();
   	
      //test toString
   	  testToString();
	}

	@Test
	public void testGetNumFigure() {
		assertEquals("numFigure was intialized to 1 via the constructor input string", 1, testField.getNumFigure());
	}
   
   @Test
	public void testGetName() {
		assertEquals("name was intialized to \"Name\" via the constructor input string", "Name", testField.getName());
	}
   
   @Test
	public void testGetTableID() {
		assertEquals("tableID was intialized to 0 in the constructor", 0, testField.getTableID());
	}
   
   @Test
	public void testSetTableID() {
		int testVal = 1;
      testField.setTableID(testVal);
      assertEquals("tableID should be set to " + testVal, testVal, testField.getTableID());
	}
   
   @Test
	public void testGetTableBound() {
		assertEquals("tableBound was intialized to 0 in the constructor", 0, testField.getTableBound());
	}
   
   @Test
	public void testSetTableBound() {
		int testVal = 1;
      testField.setTableBound(testVal);
      assertEquals("tableBound should be set to " + testVal, testVal, testField.getTableBound());
	}
   
   @Test
	public void testGetFieldBound() {
		assertEquals("fieldBound was intialized to 0 in the constructor", 0, testField.getFieldBound());
	}
   
   @Test
	public void testSetFieldBound() {
		int testVal = 1;
      testField.setFieldBound(testVal);
      assertEquals("fieldBound should be set to " + testVal, testVal, testField.getFieldBound());
	}
   
   @Test
	public void testGetDisallowNull() {
		assertEquals("disallowNull was intialized to false in the constructor", false, testField.getDisallowNull());
	}
   
   @Test
	public void testSetDisallowNull() {
		boolean testVal = true;
      testField.setDisallowNull(testVal);
      assertEquals("disallowNull should be set to " + testVal, testVal, testField.getDisallowNull());
	}
   
   @Test
	public void testGetIsPrimaryKey() {
		assertEquals("isPrimaryKey was intialized to false in the constructor", false, testField.getIsPrimaryKey());
	}
   
   @Test
	public void testSetIsPrimaryKey() {
		boolean testVal = true;
      testField.setIsPrimaryKey(testVal);
      assertEquals("isPrimaryKey should be set to " + testVal, testVal, testField.getIsPrimaryKey());
	}
   
   @Test
	public void testGetDefaultValue() {
		assertEquals("defaultValue was intialized to \"\" in the constructor", "", testField.getDefaultValue());
	}
   
   @Test
	public void testSetDefaultValue() {
		String testVal = "unknown";
      testField.setDefaultValue(testVal);
      assertEquals("defaultValue should be set to " + testVal, testVal, testField.getDefaultValue());
	}
   
   @Test
	public void testGetVarcharValue() {
		assertEquals("varcharValue was intialized to " + EdgeField.VARCHAR_DEFAULT_LENGTH + " in the constructor", EdgeField.VARCHAR_DEFAULT_LENGTH, testField.getVarcharValue());
	}
   
   @Test
	public void testSetVarcharValue() {
      //test value that fails validation
		int badTestVal = 0;
      int origVal = testField.getVarcharValue();
      testField.setVarcharValue(badTestVal);
      assertEquals("varcharValue should not be set to " + badTestVal + ",  and should remain the original value of " + origVal, origVal, testField.getVarcharValue());
      
      //test value that passes validation
      int goodTestVal = 2;
      testField.setVarcharValue(goodTestVal);
      assertEquals("varcharValue should be set to " + goodTestVal, goodTestVal, testField.getVarcharValue());
	}
   
   @Test
	public void testGetDataType() {
		assertEquals("dataType was intialized to 0 in the constructor", 0, testField.getDataType());
	}
   
   @Test
	public void testSetDataType() {
      int strDataTypeLen = testField.getStrDataType().length;
      
      //test value that fails 1st condition of validation
		int badTestVal = -1;
      int origVal = testField.getDataType();
      testField.setDataType(badTestVal);
      assertEquals("dataType should not be set to " + badTestVal + ",  and should remain the original value of " + origVal, origVal, testField.getDataType());
      
      //test value that fails 2nd condition of validation
      badTestVal = strDataTypeLen;
      origVal = testField.getDataType();
      testField.setDataType(badTestVal);
      assertEquals("dataType should not be set to " + badTestVal + ",  and should remain the original value of " + origVal, origVal, testField.getDataType());
      
      //test value that passes validation
      int goodTestVal = strDataTypeLen - 1;
      testField.setDataType(goodTestVal);
      assertEquals("dataType should be set to " + goodTestVal, goodTestVal, testField.getDataType());
	}
   
   @Test
	public void testGetStrDataType() {
      String[] expectedVal = {"Varchar",  "Boolean",  "Integer",  "Double"};
		assertEquals("strDataType was intialized to {\"Varchar\", \"Boolean\", \"Integer\", \"Double\"} when it was declared at the top of the class", expectedVal, testField.getStrDataType());
	}
   
   @Test
	public void testToString() {
      String delim = EdgeConvertFileParser.DELIM;
		assertEquals("toString should return the values of all EdgeField attributes,  separated by a delimiter of \"" + EdgeConvertFileParser.DELIM + "\"", 
      testField.getNumFigure() + delim + testField.getName() + delim + testField.getTableID() + delim + testField.getTableBound() + delim + testField.getFieldBound() + delim + testField.getDataType() + delim + testField.getVarcharValue() + delim + testField.getIsPrimaryKey() + delim + testField.getDisallowNull() + delim + testField.getDefaultValue(), 
      testField.toString());
	}

}
