package junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestDelete {
	
	
	@Test
	public void delete() throws Exception {

		UserModel.delete(6);

		UserBean bean = UserModel.findByPk(6);

//		assertTrue(bean ==null);
		assertNull(bean);

	}
}