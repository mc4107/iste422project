import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeTableTest {

    //Instantiate the test object
    private EdgeTable test;

    @Before
    public void setUp() throws Exception {

        //Create a new Edge Table
        //Testing relies on the input string being "1|test"
        this.test = new EdgeTable("1|test");
    }

    @Test
    public void testGetNumFigure() {
        assertEquals("Method 'getNumFigure' did not return the correct int!", 1 ,test.getNumFigure());
    }

    @Test
    public void testGetName() {
        assertEquals("Method 'getName' did not return the correct String!", "test" ,test.getName());
    }

    @Test
    public void testToString(){

        //Make the arrays and avoid null pointer exception
        test.makeArrays();

        assertEquals("toString method should be equal to this string", "Table: 1\r\n{\r\nTableName: test\r\nNativeFields: \r\nRelatedTables: \r\nRelatedFields: \r\n}\r\n", test.toString());
    }

    @Test
    public void testAddNativeField(){

        //Add a value of 5
        test.addNativeField(5);

        //Make the arrays and avoid null pointer exception
        test.makeArrays();

        assertEquals("The NativeFields array should have a length of 1", 1, test.getNativeFieldsArray().length);
    }

    @Test
    public void testMoveFieldUpNative(){

        //Add values to test
        test.addNativeField(0);
        test.addNativeField(1);
        test.addNativeField(2);
        test.addNativeField(3);

        test.makeArrays();
        int[] Native = test.getNativeFieldsArray();

        //Move the field up
        test.moveFieldUp(2);

        test.makeArrays();
        int[] Native2 = test.getNativeFieldsArray();

        assertEquals("The 3rd element in the first array should equal the 2nd element in the second array", Native[2], Native2[1]);
    }

    @Test
    public void testMoveFieldUpRelated(){

        //Add values to test
        test.addNativeField(0);
        test.addNativeField(1);
        test.addNativeField(2);
        test.addNativeField(3);

        test.makeArrays();

        test.setRelatedField(0, 0);
        test.setRelatedField(1, 1);
        test.setRelatedField(2, 2);
        test.setRelatedField(3, 3);

        //Get the current array
        int[] related = test.getRelatedFieldsArray();

        //Get the integer
        int first = related[2];

        //Move the field up
        test.moveFieldUp(2);

        //Get the new integer
        int[] related2 = test.getRelatedFieldsArray();

        assertEquals("The 3rd element in the first array should equal the 2nd element in the second array", first, related2[1]);
    }

    @Test
    public void testMoveFieldDownNative(){

        //Add values to test
        test.addNativeField(0);
        test.addNativeField(1);
        test.addNativeField(2);
        test.addNativeField(3);

        test.makeArrays();
        int[] Native = test.getNativeFieldsArray();

        //Move the field up
        test.moveFieldDown(2);

        test.makeArrays();
        int[] Native2 = test.getNativeFieldsArray();

        assertEquals("The 3rd element in the first array should equal the 2nd element in the second array", Native[2], Native2[3]);
    }

    @Test
    public void testMoveFieldDownRelated(){

        //Add values to test
        test.addNativeField(0);
        test.addNativeField(1);
        test.addNativeField(2);
        test.addNativeField(3);

        test.makeArrays();

        test.setRelatedField(0, 0);
        test.setRelatedField(1, 1);
        test.setRelatedField(2, 2);
        test.setRelatedField(3, 3);

        //Get the current array
        int[] related = test.getRelatedFieldsArray();

        //Get the integer
        int first = related[2];

        //Move the field up
        test.moveFieldDown(2);

        //Get the new integer
        int[] related2 = test.getRelatedFieldsArray();

        assertEquals("The 3rd element in the first array should equal the 2nd element in the second array", first, related2[3]);
    }

    @Test
    public void testAddRelatedTable(){

        //Start by making the arrays
        test.makeArrays();

        //Get the length of the empty array
        int first = test.getRelatedTablesArray().length;

        //Add a value
        test.addRelatedTable(3);

        //Remake the arrays
        test.makeArrays();

        //Get the length after
        int second = test.getRelatedTablesArray().length;

        //Compare a length of 0 + 1 to 1
        assertEquals("oops", first + 1, second);
    }

}