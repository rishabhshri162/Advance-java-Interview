package junit;

import org.junit.Test;

import junit.framework.TestCase;

public class TestAssertNull extends TestCase {

	@Test
	public void testFindByPk() throws Exception {

		UserBean bean = UserModel.findByPk(1);

		assertNull("usernot not null", bean);
//		assertNotNull(bean);
		
//		assertTrue(bean == null);
		
//		String name = "rishabh";
//		
//		assertEquals("rishabh", name);

	}
}
