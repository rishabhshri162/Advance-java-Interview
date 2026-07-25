package junit;


import static org.junit.Assert.fail;

import org.junit.Test;

import junit.framework.TestCase;

public class TestAdd{

	@Test
	public void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(5);
		bean.setName("rishabh");
		bean.setSalary(50000);

		UserModel model = new UserModel();

		model.add(bean);

		bean = model.findByPk(bean.getId());

		if (bean == null) {

			fail("Record is not added...!!!");

		} else {

			System.out.println("Record is  added...!!!");

		}

	}

}