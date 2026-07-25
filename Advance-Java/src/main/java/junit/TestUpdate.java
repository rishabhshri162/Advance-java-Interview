package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUpdate {

	@Test
	public void update() throws Exception {

		UserBean bean = UserModel.findByPk(1);

		bean.setName("rishabh");

		UserModel.update(bean);

		UserBean data = UserModel.findByPk(1);

		assertEquals("rishabh", data.getName());

	}

}
