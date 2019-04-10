import static org.junit.Assert.*;
import org.junit.Test;

public class EdgeConnectorTest {
   EdgeConnector testObj;
   
	public void prepare(EdgeConnector testObj){
    	this.testObj = testObj;
   }

	
   public void runner() {
      testGetNumConnector();
      testGetEndPoint1();
      testGetEndPoint2();
      testGetEndStyle1();
      testGetEndStyle2();
      testGetIsEP1Field();
      testGetIsEP2Field();
      testGetIsEP1Table();
      testGetIsEP2Table();
//  //        //testSetIsEP1Field();
//  //        //testSetIsEP2Field();
//  //        //testSetIsEP1Table(); 
//  //        //testSetIsEP2Table();
// 
   }



	@Test
	public void testGetNumConnector() {
		assertEquals("numConnector was intialized to 1 so it should be 1",1,testObj.getNumConnector());
      System.out.println("Test testGetNumConnector: Passed");
	}

	@Test
	public void testGetEndPoint1() {
		assertEquals("EndPoint1 was intialized to 2",2,testObj.getEndPoint1());
      System.out.println("Test testGetEndPoint1: Passed");
	}

	@Test
	public void testGetEndPoint2() {
		assertEquals("EndPoint2 was intialized as 3",3,testObj.getEndPoint2());
      System.out.println("Test testGetEndPoint2: Passed");
	}

	@Test
	public void testGetEndStyle1() {
		assertEquals("endStyle1 was intilized to \"testStyle1\"","testStyle1",testObj.getEndStyle1());
      System.out.println("Test testGetEndStyle1: Passed");
	}

	@Test
	public void testGetEndStyle2() {
		assertEquals("endStyle1 was intilized to \"testStyle1\"","testStyle2",testObj.getEndStyle2());
      System.out.println("Test testGetEndStyle2: Passed");
	}

	@Test
	public void testGetIsEP1Field() {
		assertEquals("isEP1Field should be false",false,testObj.getIsEP1Field());
      System.out.println("Test testGetISEP1Field: Passed");
	}

	@Test
	public void testGetIsEP2Field() {
		assertEquals("IsEP2Field should be false",false,testObj.getIsEP2Field());
      System.out.println("Test testGetISEP2Field: Passed");
	}

	@Test
	public void testGetIsEP1Table() {
		assertEquals("isEP1Table should be false",false,testObj.getIsEP1Table());
      System.out.println("Test testGetIsEP1Table: Passed");
	}

	@Test
	public void testGetIsEP2Table() {
		assertEquals("isEP2Table should be false",false,testObj.getIsEP2Table());
      System.out.println("Test testGetISEP2Table: Passed");
	}

	@Test
	public void testSetIsEP1Field() {
		testObj.setIsEP1Field(true);
      assertEquals("isEP1Filed should be what you set it to",true,testObj.getIsEP1Field());
      System.out.println("Test testSetIsEP1Field: Passed");
                
	}

	@Test
	public void testSetIsEP2Field() {
		testObj.setIsEP2Field(true);
      assertEquals("isEP2Filed should be what you set it to",true,testObj.getIsEP2Field());
      System.out.println("Test testSetIsEP2Field: Passed");
	}

	@Test
	public void testSetIsEP1Table() {
		testObj.setIsEP1Table(true);
      assertEquals("isEp1Table should be what you set it to",true,testObj.getIsEP1Table());
      System.out.println("Test testSetIsEP1Table: Passed");
	}

	@Test
	public void testSetIsEP2Table() {
		testObj.setIsEP2Table(true);
      assertEquals("isEp2Table should be what you set it to",true,testObj.getIsEP2Table());
      System.out.println("Test testSetIsEP2Table: Passed");
	}

}
