package junit;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestAllSuite {

	public static void main(String[] args) {

		TestSuite suite = new TestSuite("Test All");

		suite.addTestSuite(TestSuite1.class);
		suite.addTestSuite(TestSuite2.class);

		TestRunner.run(suite);

	}
}
