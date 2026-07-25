package junit;

import static org.junit.Assert.fail;

import org.junit.Test;

import junit.framework.TestCase;

public class TestFail extends TestCase{
	
	
	@Test
	public void testFail() throws Exception {
		
		
		UserBean bean  = UserModel.findByPk(18);
		
		if (bean == null) {
			
			fail("record not found");
			
		}else {
			System.out.println("success");
		}
	}

}
