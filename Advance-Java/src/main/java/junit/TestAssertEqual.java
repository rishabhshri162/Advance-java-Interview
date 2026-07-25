package junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAssertEqual {

	@Test
	public void assertEqaul() {

		int max = Calculation.findMax(new int[] { 1, 2, 3, 4, 5, 6 });

		assertEquals(6, max);
	}

}
