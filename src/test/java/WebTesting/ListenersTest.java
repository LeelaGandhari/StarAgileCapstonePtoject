package WebTesting;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenersTest {
  @Test(priority=1)
  public void testCae1() {
	  System.out.println("This is test1");
	  Assert.assertEquals(true,true,"Test Fail as condition is not matched");
	  System.out.println("Test Pass as condition is matched");
	  
	  }
  @Test(priority=2)
  public void testCae2() {
	  System.out.println("This is test1");
	  Assert.assertEquals(true,false,"Test Fail as condition is not matched");
	  System.out.println("Test Fail as condition is not matched");
	  
	  }
  
}
